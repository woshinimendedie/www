package com.example.www.service;

import com.example.www.domain.User;

public interface LoginService {
    User login(String email, String password);

}
