package com.example.www.controller;

import com.example.www.domain.User;
import com.example.www.service.LoginService;
import com.example.www.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class UserController {
    @Autowired
    private SignInService signInService;
    @Autowired
    private LoginService loginService;


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }
    @RequestMapping("/toSignIn")
    public String toSignIn() {
        return "signIn";
    }
    @RequestMapping("/login")
    public String login(String email, String password, Model model) {
        User user = loginService.login(email,password);
        if (user == null)//登录失败，重新登录
            return "login";
        else {
            model.addAttribute("user",user);//登录成功
            return "logs";
        }
    }
    @RequestMapping("/signIn")
    public String signIn(String email, String password) {
        if (signInService.signIn(email, password) == null)//注册失败
            return "signIn";//重新注册
        else
            return "login";//前往登录
    }

}
