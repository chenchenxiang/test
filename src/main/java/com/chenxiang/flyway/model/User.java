package com.chenxiang.flyway.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author cx
 * @version 1.0
 * @date 2020/8/26 15:04
 */
@Data
@TableName("user")
public class User {

    private String id ;

    private String name ;

    private int age ;

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}
