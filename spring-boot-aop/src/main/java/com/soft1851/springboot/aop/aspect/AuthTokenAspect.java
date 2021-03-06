package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author xgp
 */
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    /**
     * 配置加上自定义注释的方法为切点
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken){
    }

//    @Around(value = "doAuthToken(authToken)",argNames = "proceedingJoinPoint,authToken")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, AuthToken authToken) throws Throwable{
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert servletRequestAttributes != null;
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        //去的注解中的role_name的值
//        String[] roleIds = authToken.role_id();
//        if (roleIds.length <= 1){
//            //只需要认证（登录）
//            String id = request.getHeader("id");
//            //如果id不为空，可以调用目标方法
//            if (id != null){
//                return proceedingJoinPoint.proceed();
//            }
//            return "请输入账号";
//        }else {
//            return "账号错误，无法访问";
//        }
//    }

    @Around(value = "doAuthToken(authToken)",argNames = "proceedingJoinPoint,authToken")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, AuthToken authToken) throws Throwable{
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //去的注解中的role_name的值
        String[] roleNames = authToken.role_id();
        if (roleNames.length <= 1){
            //只需要认证（登录）
            String id = request.getHeader("id");
            //如果id为空，可以调用目标方法
            if (id != null){
                return proceedingJoinPoint.proceed();
            }
            return "请先登录";
        }else {
            //验证身份
            String role = request.getHeader("role");
            //log.info(role);
            //遍历roleNames数组，匹配role
            for (String roleName : roleNames){
                if (roleName.equals(role)){
                    //身份匹配成功，调用目标方法
                    return proceedingJoinPoint.proceed();
                }
            }
            return "权限不足，无法访问";
        }
    }
}
