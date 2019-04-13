package com.java.test;

import com.java.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest03 {

    public static void main(String[] args) {

        ApplicationContext applicationContext=  new ClassPathXmlApplicationContext("spring.xml");
        User user7 = applicationContext.getBean("user7", User.class);
        System.out.println(user7.getLove());
        User user8 = applicationContext.getBean("user8", User.class);
        System.out.println(user8.getEat());
        User user9 = applicationContext.getBean("user9", User.class);
        System.out.println(user9.getMovie());
        System.out.println(user9.getAddress().getProperty("address1"));
    }
}
