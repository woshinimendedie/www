package com.example.www.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Log {
    private Integer id;
    private LocalDateTime loginTime;
    private User user;


}
