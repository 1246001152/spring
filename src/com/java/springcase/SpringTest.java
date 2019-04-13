package com.java.springcase;

import com.java.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext=  new ClassPathXmlApplicationContext("spring.xml");
//        User user = applicationContext.getBean("user", User.class);
//        System.out.println(user);
        User user1 = applicationContext.getBean("user1", User.class);
        System.out.println(user1);

    }
}
