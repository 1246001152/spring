package com.java.springcase;

import com.java.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext=  new ClassPathXmlApplicationContext("spring.xml");
//        User user = applicationContext.getBean("user", User.class);
//        System.out.println(user);
//        属性注入
//        User user1 = applicationContext.getBean("user1", User.class);
//        System.out.println(user1);
//        构造方法注入
        User user2 = applicationContext.getBean("user2", User.class);
        System.out.println(user2);
        User user3 = applicationContext.getBean("user3", User.class);
        System.out.println(user3);
        User user4 = applicationContext.getBean("user4", User.class);
        System.out.println(user4);


    }
}
