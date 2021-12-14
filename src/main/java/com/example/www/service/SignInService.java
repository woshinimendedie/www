package com.example.www.service;

import com.example.www.domain.User;

public interface SignInService {
    User signIn(String email, String password);
}
