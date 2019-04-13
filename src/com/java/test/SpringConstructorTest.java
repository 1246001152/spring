package com.java.test;

import com.java.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConstructorTest {

    public static void main(String[] args) {

       ApplicationContext ac = new ClassPathXmlApplicationContext("constructor.xml");
        User user = ac.getBean("user", User.class);
        System.out.println(user.getRole().getName());

    }
}
