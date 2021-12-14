package com.example.www;

import com.example.www.mapper.LogMapper;
import com.example.www.mapper.UserMapper;
import com.example.www.service.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WwwApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogMapper logMapper;

    @Autowired
    private LogService logsService;

    @Test
    void contextLoads() {
        userMapper.findEmail("");
    }

    @Test
    void contextLoad1s() {
        userMapper.findEmail("");
    }

    @Test
    void contextLo11ads() {
        userMapper.findEmail("");
    }





}
