package com.qfedu.service.impl;

import com.qfedu.entity.User;
import com.qfedu.mapper.UserMapper;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public User selectUserByEmail(String userEmail) {
        User user =userMapper.selectUserByEmail(userEmail);
        return user;
    }

    public void insertEmail(String userEmail) {
        userMapper.insertEmail(userEmail);
    }

    public int selectByEmail(String userEmail) {
        System.out.println("userService"+userEmail);
       int result = userMapper.selectByEmail(userEmail);

        return result;
    }
}
