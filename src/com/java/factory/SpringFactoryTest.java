package com.java.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFactoryTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext=  new ClassPathXmlApplicationContext("spring.xml");
        //非静态
        Car car1 = applicationContext.getBean("car1", Car.class);
        System.out.println(car1);
        //静态
        Car car2 = applicationContext.getBean("car2", Car.class);
        System.out.println(car2);
    }
}
