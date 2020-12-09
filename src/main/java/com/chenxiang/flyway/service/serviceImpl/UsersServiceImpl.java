package com.chenxiang.flyway.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenxiang.flyway.mapper.mapper1.UserMapper;
import com.chenxiang.flyway.mapper.mapper2.UserMappers;
import com.chenxiang.flyway.model.User;
import com.chenxiang.flyway.service.UserService;
import com.chenxiang.flyway.service.UsersService;
import org.springframework.stereotype.Service;

/**
 * @author cx
 * @version 1.0
 * @date 2020/8/27 11:05
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UserMappers, User> implements UsersService {
}
