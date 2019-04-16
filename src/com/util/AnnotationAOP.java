package com.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

/**
 * @author : 张晋飞
 * date : 2019/4/16
 */
// 不属于dao service controller
@Component
//AOP 的切面注解版
@Aspect
public class AnnotationAOP {

    @Autowired
    private TransactionUtil transactionUtil;

    private TransactionStatus begin;

    // execution 执行的方程式：方法返回值类型  包名.类名.方法名(..) 参数
    @Before("execution(* com.serivce.*.*(..))")
    public void before(){
        System.out.println("前置通知");
    }

    @After("execution(* com.serivce.*.*(..))")
    public void after(){
        System.out.println("后置通知");
    }

    @AfterReturning("execution(* com.serivce.*.*(..))")
    public void runtime(){
        System.out.println("运行通知");
    }

    @AfterThrowing("execution(* com.serivce.*.*(..))")
    public void throwing(){
        System.out.println("异常通知");
        transactionUtil.rollback(begin);
        System.out.println("事务回滚");

    }

    @Around("execution(* com.serivce.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        begin = transactionUtil.begin();
        System.out.println("事务开启");

        System.out.println("环绕通知前");
        // 执行方法 放行
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知后");

        transactionUtil.commit(begin);
        System.out.println("事务提交");
    }


}
