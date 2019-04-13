package com.java.test;

import com.java.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        User user = classPathXmlApplicationContext.getBean("user", User.class);
        System.out.println(user);

    }
}
