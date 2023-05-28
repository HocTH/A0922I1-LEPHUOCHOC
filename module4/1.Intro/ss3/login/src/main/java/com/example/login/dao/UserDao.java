package com.example.login.dao;

import com.example.login.model.Login;
import com.example.login.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("Hoc");
        u1.setAccount("hoc");
        u1.setEmail("hoclephuoc1998@gmail.com");
        u1.setPassword("123456");
        users.add(u1);
        User u2 = new User();
        u1.setAge(25);
        u1.setName("Tinh");
        u1.setAccount("tinh");
        u1.setEmail("nguyenthitinh1997@gmail.com");
        u1.setPassword("123456");
        users.add(u2);
        User u3 = new User();
        u1.setAge(25);
        u1.setName("Hoai");
        u1.setAccount("hoai");
        u1.setEmail("hoailephuoc1995@gmail.com");
        u1.setPassword("123456");
        users.add(u3);
    }
    public static User checkLogin(Login login){
        for (User u:users){
            if (u.getAccount().equals(login.getAccount()) && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
