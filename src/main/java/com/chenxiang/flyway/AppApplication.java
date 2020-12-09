package com.chenxiang.flyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author cx
 * @version 1.0
 * @date 2020/8/14 14:24
 */
@SpringBootApplication(scanBasePackages = "com.chenxiang")
public class AppApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Demo1Application启动类
        return builder.sources(AppApplication.class);
    }
        public static void main(String[] args) {
            SpringApplication.run(AppApplication.class, args);
        }

}
