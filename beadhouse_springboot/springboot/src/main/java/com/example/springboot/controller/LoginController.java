package com.example.springboot.controller;


import com.example.springboot.controller.Request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Result;
import com.example.springboot.service.impl.LoginService;
import com.example.springboot.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@CrossOrigin("http://localhost:8081")
@CrossOrigin
@RestController
@RequestMapping("")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        Admin login = loginService.login(loginRequest);
        if(login != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", login.getId());
            claims.put("name",login.getUserName());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("账号或密码错误");
//        return (loginService.login(loginRequest) != null) ? Result.success() : Result.error("账号或密码错误");
    }
    @PostMapping("/logon")
    public Result logon(@RequestBody Admin ad){
//        loginService.login(loginRequest);
        loginService.logon(ad);
        return Result.success();
    }

}
