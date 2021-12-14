package com.example.www.service.impl;

import com.example.www.domain.User;
import com.example.www.mapper.UserMapper;
import com.example.www.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl implements SignInService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User signIn(String email, String password) {
        String temp = userMapper.findEmail(email);
        if(temp != null)
            return null;//没有查出来就可以进行查询操作
        else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            userMapper.save(user);
            return user;
        }
    }

}
