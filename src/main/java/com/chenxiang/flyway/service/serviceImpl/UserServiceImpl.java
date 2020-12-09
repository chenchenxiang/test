package com.chenxiang.flyway.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenxiang.flyway.mapper.mapper1.UserMapper;
import com.chenxiang.flyway.model.User;
import com.chenxiang.flyway.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author cx
 * @version 1.0
 * @date 2020/8/26 15:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements  UserService {
}
