package com.xingcheng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingcheng.mapper.UserInfoMapper;
import com.xingcheng.domain.UserInfo;
import com.xingcheng.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * 会员表(UserInfo)表服务实现类
 *
 * @author xingcheng.wu
 * @since 2024-04-23 12:40:10
 */
@Service("userInfoServiceImpl")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}

