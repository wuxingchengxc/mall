package com.xingcheng.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.xingcheng.constant.SystemRedisConstant;
import com.xingcheng.domain.Result;
import com.xingcheng.domain.SysUser;
import com.xingcheng.enums.ReturnCodeEnum;
import com.xingcheng.util.AuthContextUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@Component
public class LoginAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.如果是option请求则直接放行
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }
        // 2.校验是否存在token 不存在则直接返回登录
        String token = request.getHeader("token");
        // 3.校验token是否存在redis中，不存在返回登录
        if (StrUtil.isBlank(token)) {
            // 返回报错重新登录
            responseNoLoginInfo(response);
            return false;
        }
        String userJson = redisTemplate.opsForValue().get(String.format(SystemRedisConstant.LOGIN_USER_KEY, token));
        if (StrUtil.isBlank(userJson)) {
            // 返回报错重新登录
            responseNoLoginInfo(response);
            return false;
        }
        // 4.将redis中过期时间延长30min
        redisTemplate.expire(String.format(SystemRedisConstant.LOGIN_USER_KEY, token), 30, TimeUnit.MINUTES);

        // 5.将用户信息保存至线程私有变量中
        AuthContextUtil.set(JSONUtil.toBean(userJson, SysUser.class));
        return true;
    }

    /**
     * 当所有的方法执行完成后删除线程变量
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        AuthContextUtil.remove();
    }


    //响应208状态码给前端
    private void responseNoLoginInfo(HttpServletResponse response) {
        Result<Object> result = Result.error(ReturnCodeEnum.RC208);
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSONUtil.toJsonStr(result));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) writer.close();
        }
    }
}
