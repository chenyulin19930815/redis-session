package com.ch.redissession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@SpringBootApplication
@EnableCaching
@EnableRedisHttpSession
@RestController
public class RedisSessionApplication {

    @Autowired
    private HttpSession session;

    public static void main(String[] args) {
        SpringApplication.run(RedisSessionApplication.class, args);
    }

    @GetMapping("/user/add")
    public String addUser() {
        //添加session
        session.setAttribute("user", "Jack");
        return "add Jack success !";
    }

    @GetMapping("/user/q")
    public String getUser() {
        //获取session
        Object user = session.getAttribute("user");
        return String.format("get %s from session success !",String.valueOf(user));
    }
}
