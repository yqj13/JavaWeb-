package com.example.springboot.controller.Request;

import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    private String password;
}
