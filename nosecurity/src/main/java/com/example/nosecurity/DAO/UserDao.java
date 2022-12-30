package com.example.nosecurity.DAO;

import com.example.nosecurity.data.User;
import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<Integer, User> Users=null;
    static {
        Users=new HashMap<Integer,User>();
        Users.put(1,new User(1,"jeep","1234"));
        Users.put(2,new User(2,"user","1234"));
        Users.put(3,new User(3,"jeep1","12345"));
        Users.put(4,new User(4,"user1","12345"));
    }
    private static Integer initId=4;
    public void save(User user){
        if(user.getUserid()==null){
            user.setUserid(initId++);
        }
        Users.put(user.getUserid(), user);
    }
}
