package com.chenxiang.flyway.mapper.mapper1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenxiang.flyway.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cx
 * @version 1.0
 * @date 2020/8/26 15:10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
