package com.java.xm;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aop {

    public void before(){
        System.out.println("Aop前置通知");
    }

    public void after(){
        System.out.println("Aop后置通知");
    }

    public void runtime(){
        System.out.println("Aop运行通知");
    }
    public void throwing(){
        System.out.println("Aop异常通知");
    }

    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Aop环绕通知前");
        proceedingJoinPoint.proceed();
        System.out.println("Aop环绕通知后");
    }

}
