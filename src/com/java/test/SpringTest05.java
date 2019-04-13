package com.java.test;

import com.java.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest05 {

    public static void main(String[] args) {

       ApplicationContext ac = new ClassPathXmlApplicationContext("spring05.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
    }
}
