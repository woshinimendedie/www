package com.example.www.controller;


import com.example.www.domain.User;
import com.example.www.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LogController {
    @Autowired
    private LogService logService;
    @RequestMapping("/logs")
    public String showLogs(Model model, @SessionAttribute User user) {
        model.addAttribute("logs",logService.showLogsByUser(user.getEmail()));
        return "logs";
    }

    }


