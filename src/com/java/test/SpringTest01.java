package com.java.test;

import com.java.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest01 {

    public static void main(String[] args) {

        ApplicationContext applicationContext=  new ClassPathXmlApplicationContext("spring.xml");
        User user1 = applicationContext.getBean("user", User.class);
        System.out.println(user1);
        ((ClassPathXmlApplicationContext) applicationContext).close();

    }
}
