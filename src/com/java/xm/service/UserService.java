package com.java.xm.service;

import com.java.xm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//业务层注释
@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public void add(){
        System.out.println("UserService.add....");
        dao.add();
    }
}
