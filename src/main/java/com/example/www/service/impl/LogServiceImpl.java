package com.example.www.service.impl;

import com.example.www.domain.Log;
import com.example.www.mapper.LogMapper;
import com.example.www.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LogServiceImpl implements LogService{
    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Log> showLogsByUser(String email) {//查询登录历史
        return logMapper.findByUserEmail(email);
    }

    @Transactional //事务处理，增删改记得都加这个注解
    @Override
    public boolean saveLog(Log log) {//保存
        return logMapper.save(log) == 1;
    }
}
