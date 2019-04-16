package com.serivce;

import com.dao.UserDao;
import com.entiy.User;
import com.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author : 张晋飞
 * date : 2019/4/15
 */
// 业务层
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    @Autowired
    private TransactionUtil transaction;



    public void add(User user){
        System.out.println("UserService.add......");
        // 开始事务
        TransactionStatus begin = null;
        try {
            begin = transaction.begin();
            userDao.add(user);
//            System.out.println(1/0);
            transaction.commit(begin);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback(begin);
        }
    }
    public void add01(User user){
        System.out.println("UserService.add01......");
        userDao.add(user);
        // 在service 不要去捕捉异常，抛出异常，异常交给controller解决
//        System.out.println(1/0);
    }
    public void add03(User user){
        System.out.println("UserService.add03......");
        userDao.add(user);
        System.out.println(1/0);
    }

    @Transactional
    public void add04(User user){
        System.out.println("UserService.add04......");
        userDao.add(user);
//        System.out.println(1/0);
    }

    public void update(User user){
        userDao.update(user);
    }
    public void delete(int id){
        userDao.delete(id);
    }
    public void query(){
        userDao.query();
    }
    public void queryMapper(){
        userDao.queryMapper();
    }
}
