package com.example.springboot.service.impl;


import com.example.springboot.controller.Request.LoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    AdminMapper adminMapper;

    public Admin login(LoginRequest res) {
      Admin admin = adminMapper.selectByUsername(res.getUserName());
      if (admin == null){
          return null;
//          throw new ServiceException("账号不存在");
      }
      if (!admin.getPassword().equals(res.getPassword())){
          return null;
//          throw new ServiceException("用户名或密码错误");
      }
        return admin;
    }


    public void logon(Admin ad) {
         adminMapper.insert(ad);
    }
}
