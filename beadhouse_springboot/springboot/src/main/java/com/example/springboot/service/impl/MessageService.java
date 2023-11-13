package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.controller.Request.Oldorrequest;
import com.example.springboot.entity.Message;
import com.example.springboot.entity.Oldor;
import com.example.springboot.mapper.MessageMapper;
import com.example.springboot.mapper.OldorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService extends ServiceImpl<MessageMapper, Message> {
    @Autowired
    private MessageMapper messageMapper;


    public List<Message> selectAll() {
        List<Message> messages = messageMapper.seletAll();
        return messages;
    }
}

