package com.java.test;

import com.java.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest04 {

    public static void main(String[] args) {

       ApplicationContext ac = new ClassPathXmlApplicationContext("spring04.xml");
        User user1 = ac.getBean("user", User.class);
        User user2 = ac.getBean("user", User.class);
        System.out.println(user1==user2);
        //方法动态注入
        System.out.println(user1.getRole().getName());
    }
}
