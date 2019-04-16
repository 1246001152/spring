package com.test;

import com.entiy.User;
import com.serivce.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : 张晋飞
 * date : 2019/4/15
 */
public class SpringTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user = new User();
        user.setuId(1);
        user.setUsername("11111");
        user.setPassword("11111");
//        userService.add(user);
//        userService.update(user);
//        userService.delete(1);
//        userService.query();
        userService.queryMapper();
    }
}
