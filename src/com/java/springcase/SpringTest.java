package com.java.springcase;

import com.java.javacase.JavaWork;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext=  new ClassPathXmlApplicationContext("spring.xml");
        //这里将控制权交个SpringIOC
        JavaWork javawork = applicationContext.getBean("javawork", JavaWork.class);
        javawork.doTest();

    }
}
