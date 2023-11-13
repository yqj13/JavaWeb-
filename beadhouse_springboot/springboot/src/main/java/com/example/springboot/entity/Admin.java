package com.example.springboot.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer id;
    private String userName;
    private String password;
    private String phone;
}
