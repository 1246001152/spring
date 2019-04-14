package com.java.xm;

import com.java.xm.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring07.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.add();

    }
}
