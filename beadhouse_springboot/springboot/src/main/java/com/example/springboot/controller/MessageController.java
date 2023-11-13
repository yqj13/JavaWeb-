package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.controller.Request.Messagerequest;
import com.example.springboot.controller.Request.Oldorrequest;
import com.example.springboot.entity.Message;
import com.example.springboot.entity.Result;
import com.example.springboot.service.impl.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@CrossOrigin
@RestController
@RequestMapping("/notice")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @GetMapping("/getByPage")
    public Result getByPage(@RequestParam Integer pageNum,
                            @RequestParam(required = false, defaultValue = "9") Integer pageSize,
                            @RequestParam String title){
        QueryWrapper<Message> queryWrapper = new QueryWrapper<Message>().orderByDesc("id");
        queryWrapper.like(StringUtils.isNotBlank(title), "title", title);
        Page<Message> page = messageService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return Result.success(page);
    }
    @GetMapping("/selectAll")
    public Result selectAll(){
        List<Message> messages = messageService.selectAll();
        return Result.success(messages);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Message message){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(format);
        message.setTime(format);
        message.setOpen(true);
        messageService.save(message);
        return Result.success();
    }
    @PostMapping("/message")
    public Result save(@RequestBody Message message){
        message.setTime(getCurrentDate());
        boolean save = messageService.save(message);
        System.out.println(save);
        return Result.success();
    }
    public String getCurrentDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        return format;
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Message byId = messageService.getById(id);
        return Result.success(byId);
    }

    @PutMapping()
    public Result update(@RequestBody Message message){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(format);
        message.setTime(format);
        message.setTime(format);
        boolean b = messageService.saveOrUpdate(message);
        System.out.println(b);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
       messageService.removeById(id);
        return Result.success();
    }
}
