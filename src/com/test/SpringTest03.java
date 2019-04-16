package com.test;

import com.entiy.User;
import com.serivce.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : 张晋飞
 * date : 2019/4/15
 */
public class SpringTest03 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring03.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user = new User();
        user.setUsername("22222");
        user.setPassword("22222");
        userService.add03(user);
    }
}
