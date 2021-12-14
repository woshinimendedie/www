package com.example.www.service;

import com.example.www.domain.Log;

import java.util.List;

public interface LogService {
    boolean saveLog(Log log);
    List<Log> showLogsByUser(String email);

}
