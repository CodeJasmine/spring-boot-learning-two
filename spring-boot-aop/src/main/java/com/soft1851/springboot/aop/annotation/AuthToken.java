package com.soft1851.springboot.aop.annotation;

import java.lang.annotation.*;

/**
 * @author xgp
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthToken {
    /**
     * 访问接口将需要的身份，默认为空，即登录即可访问，可以定义多个
     * @return
     */
    String[] role_id() default "";
}
