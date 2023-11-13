package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.controller.Request.Oldorrequest;
import com.example.springboot.entity.Message;
import com.example.springboot.entity.Oldor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper extends BaseMapper<Message> {

    List<Message> seletAll();
}

