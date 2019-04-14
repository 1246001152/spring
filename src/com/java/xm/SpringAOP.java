package com.java.xm;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringAOP {

    @Before("execution(* com.java.xm.service.*.*(..))")
    public void before(){
        System.out.println("前置通知");
    }

    @After("execution(* com.java.xm.service.UserService.add(..))")
    public void after(){
        System.out.println("后置通知");
    }

    @AfterReturning("execution(* com.java.xm.service.UserService.add(..))")
    public void runtime(){
        System.out.println("运行通知");
    }
    @AfterThrowing("execution(* com.java.xm.service.UserService.add(..))")
    public void throwing(){
        System.out.println("异常通知");
    }

    @Around("execution(* com.java.xm.service.UserService.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知后");
    }


}
