package com.dao;

import com.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : 张晋飞
 * date : 2019/4/15
 */
// 持久层  数据访问层 DAO
@Repository("userDao")
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(User user){
        System.out.println("UserDao.add......");
        String sql="insert into user (username,password) values (? ,?)";
        int i = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        System.out.println("添加成功"+i);
    }
    public void update(User user){
        System.out.println("UserDao.add......");
        String sql="update user set username=?,password= ? where u_id = ? ";
        int i = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),user.getuId());
        System.out.println("修改成功"+i);
    }
    public void delete(int id){
        System.out.println("UserDao.add......");
        String sql="delete from user where u_id=? ";
        int i = jdbcTemplate.update(sql, id);
        System.out.println("删除成功"+i);
    }

    public void query(){
        String sql="select * from user";

        List<User> list = new ArrayList<>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int uId = resultSet.getInt("u_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                list.add(new User(uId,username,password));
            }
        });

        System.out.println(list);
    }
    public void queryMapper(){
        String sql="select * from user where u_id=?";
//        List<Map<String, Object>> query = jdbcTemplate.query(sql, new ColumnMapRowMapper());
        List<User> query = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class),11);
        System.out.println(query);
    }
}
