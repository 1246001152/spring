package com.java.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Role role = new Role();
    private List<String> love;
    private Set<String> eat;
    private Map<String,String> movie;
    private Properties address;

    public Properties getAddress() {
        return address;
    }

    public void setAddress(Properties address) {
        this.address = address;
    }

    public Set<String> getEat() {
        return eat;
    }

    public void setEat(Set<String> eat) {
        this.eat = eat;
    }

    public Map<String, String> getMovie() {
        return movie;
    }

    public void setMovie(Map<String, String> movie) {
        this.movie = movie;
    }

    public List<String> getLove() {
        return love;
    }

    public void setLove(List<String> love) {
        this.love = love;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void destory() {
        System.out.println("bean销毁");
    }

    public void init() {
        System.out.println("bean初始化");
    }
}
