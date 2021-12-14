package com.example.www.service.impl;

import com.example.www.domain.Log;
import com.example.www.domain.User;
import com.example.www.mapper.LogMapper;
import com.example.www.mapper.UserMapper;
import com.example.www.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogMapper logMapper;

    @Override
    @Transactional
    public User login(String email, String password) {
        User user = userMapper.findByEmailAndPassword(email, password);
        if(user == null)
            return null;//没有查出来帐号就可以进行登录操作
        else {
            LocalDateTime now = LocalDateTime.now();
            Log log = new Log();
            log.setLoginTime(now);
            log.setUser(user);
            logMapper.save(log);
            userMapper.update(email, now);
            return user;
        }
    }
}
