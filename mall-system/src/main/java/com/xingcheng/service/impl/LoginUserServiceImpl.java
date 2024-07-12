package com.xingcheng.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.constant.Constants;
import com.xingcheng.constant.SystemRedisConstant;
import com.xingcheng.domain.SysUser;
import com.xingcheng.dto.LoginDto;
import com.xingcheng.enums.ReturnCodeEnum;
import com.xingcheng.exception.PublicException;
import com.xingcheng.mapper.SysUserMapper;
import com.xingcheng.service.LoginUserService;
import com.xingcheng.util.uuid.UUID;
import com.xingcheng.vo.LoginVo;
import com.xingcheng.vo.ValidateCodeVo;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.concurrent.TimeUnit;

/**
 * 会员表(UserInfo)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-23 12:40:10
 */
@Service("loginUserServiceImpl")
public class LoginUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements LoginUserService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public LoginVo login(LoginDto loginDto) {
        String captcha = loginDto.getCaptcha();
        String key = loginDto.getCodeKey();
        String redisKey = String.format(SystemRedisConstant.VALIDATE_CODE_KEY, key);
        //2 根据获取的redis里面key ，查询redis里面存储验证码
        // set("user:validate"+key
        String redisCode = redisTemplate.opsForValue().get(redisKey);

        //3 比较输入的验证码和 redis存储验证码是否一致
        if(StrUtil.isEmpty(redisCode) || !StrUtil.equalsIgnoreCase(redisCode,captcha)) {
            throw new PublicException(ReturnCodeEnum.VERIFICATION_CODE_INEXISTENCE);
        }
        // 4.删除验证码
        redisTemplate.delete(redisKey);

        String userName = loginDto.getUserName();
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(SysUser::getUsername, userName);
        SysUser dbsUser = getOne(queryWrapper);
        String md5Password =
                DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());
        // 5.校验用户是否存在
        if (null == dbsUser || !StrUtil.equals(md5Password,dbsUser.getPassword())) {
            throw new PublicException(ReturnCodeEnum.USERNAME_INEXISTENCE);
        }
        String token = UUID.randomUUID().toString();
        // 6.把登录成功用户信息放到redis里面
        String loginKey = String.format(SystemRedisConstant.LOGIN_USER_KEY, token);
        redisTemplate.opsForValue()
                .set(loginKey,
                        JSONUtil.toJsonStr(dbsUser),
                        7,
                        TimeUnit.DAYS);

        //9 返回loginvo对象
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        return loginVo;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(String.format(SystemRedisConstant.LOGIN_USER_KEY, token));
    }

    @Override
    public ValidateCodeVo generateValidateCode() {
        //1 通过工具生成图片验证码
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(150, 48, 4, 2);
        String codeValue = circleCaptcha.getCode();//4位验证码值
        String imageBase64 = circleCaptcha.getImageBase64(); //返回图片验证码，base64编码

        //2 把验证码存储到redis里面
        String key = UUID.randomUUID().toString().replaceAll("-","");
        redisTemplate.opsForValue().set(String.format(SystemRedisConstant.VALIDATE_CODE_KEY,key),
                codeValue,
                5,
                TimeUnit.MINUTES);

        //3 返回ValidateCodeVo对象
        ValidateCodeVo validateCodeVo = new ValidateCodeVo();
        validateCodeVo.setCodeKey(key); //redis存储数据key
        validateCodeVo.setCodeValue(String.format(Constants.WEB_DATA_IMAGE, imageBase64));
        return validateCodeVo;
    }

}

