package com.java.test;

import com.java.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest02 {

    public static void main(String[] args) {

        // bean注入
        ApplicationContext applicationContext=  new ClassPathXmlApplicationContext("spring.xml");
        User user3 = applicationContext.getBean("user3", User.class);
        System.out.println(user3.getRole().getName());
//        内部bean注入
        User user4 = applicationContext.getBean("user4", User.class);
        System.out.println(user4.getRole().getName());
//        注入null
        User user5 = applicationContext.getBean("user5", User.class);
        System.out.println(user5.getRole());
    }
}
