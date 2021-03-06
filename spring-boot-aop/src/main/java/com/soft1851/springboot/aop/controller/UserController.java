package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
//    @Resource
//    private UserMapper userMapper;
//    String id = userMapper.selectId();

//    @GetMapping("user")
//    @AuthToken(role_id = {})
//    public String signIn(){
//        log.info("当前用户："+ userMapper.getByAccount());
//        return "登录成功";
//    }
//    /**
//     * 无需任何校验，不用加注解
//     * @param name
//     * @return
//     */
//    @GetMapping("hello")
//    public  String hello(String name){
//        log.info("hello()方法无需鉴权，无需认证。当前用户名："+name);
//        return "hello方法访问成功";
//    }

//    /**
//     * 需要登录校验：此时该方法需要加注解，但是不需要传角色
//     * @param name
//     * @return
//     */
//    @GetMapping("user")
//    @AuthToken
//    public String user(String name){
//        log.info("user()方法需认证。当前用户名："+name);
//        return "user()方法访问成功";
//    }

    /**
     * 需要鉴权，此时该方法需要加注解，需要传角色
     * 角色可以传多个
     * 如果需要更复杂的逻辑操作，建议使用String Security、Apache Shino等安全框架
     * @param name
     * @return
     */
    @GetMapping("admin")
    @AuthToken(role_id = {"123456","Admin"})
    public String admin(String name){
        log.info("当前用户名："+name);
        return "访问成功";
    }

}
