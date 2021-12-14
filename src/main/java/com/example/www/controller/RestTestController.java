package com.example.www.controller;

import com.example.www.domain.Log;
import com.example.www.domain.User;
import com.example.www.mapper.LogMapper;
import com.example.www.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestTestController {
    @Autowired
    private LogMapper logMapper;

    @RequestMapping("/load")
    @ResponseBody // 用于前后端分离的项目
    @CrossOrigin
    public List<Log> send() {
        return logMapper.findByUserEmail("tom");
    }

    @RequestMapping("/receive")
    @ResponseBody
    @CrossOrigin
    public String receive(@RequestBody Log log) {
        System.out.println("从前台来的是：" + log);
        return "OK";
    }

}
