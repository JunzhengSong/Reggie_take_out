package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.User;
import com.itheima.reggie.mapper.UserMapper;
import com.itheima.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author sjz
 * @version 1.0
 * @description TODO
 * @date 2023/3/6 14:26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {//忘了implements UserService会无法发现 bean
}
//bean not found 忘记写注解了一般