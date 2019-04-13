package com.java.entity;

public abstract class User {
    private Integer id;
    private String username;
    private String password;
    private Role role;

//    public Role getRole() {
//        return role;
//    }
    public abstract Role getRole();

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

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        System.out.println("有参constructor");
    }

    public User() {
        System.out.println("无参constructor");
    }
    // 就是使用这个构造方法进行构造方法自动装配
    public User(Role role) {
        this.role = role;
    }
}
