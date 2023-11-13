package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "notice")
public class Message {
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    @TableField(value = "author_id")
    private Integer authorId;
    private String time;
    private boolean open;
    @TableField(exist = false)
    private String admin;


}
