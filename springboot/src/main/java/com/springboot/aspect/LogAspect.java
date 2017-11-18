package com.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by mengtian on 2017/11/17
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(public * com.springboot.controller.*Controller.*(..))")
    public void controller() {
    }

    @Before("controller()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        System.out.println("Ip:" + request.getRemoteHost());
        System.out.println("http_method:" + request.getMethod());
        System.out.println("args:" + Arrays.toString(joinPoint.getArgs()));
    }

    /*@Around("controller()")
    public void time(ProceedingJoinPoint joinPoint) {
        //方法进入时间
        long startTime = System.currentTimeMillis();
        //执行方法
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        //此次运行的方法名称
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName().concat(".").concat(signature.getName());
        System.out.println(String.format("method: %s process time: %d", methodName, endTime - startTime));
    }*/
}
