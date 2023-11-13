package com.example.springboot.controller.Request;

import lombok.Data;

@Data
public class Oldorrequest {
    private Integer currentPage;
    private Integer pageSize;
    private Integer pageNum;
    private String name;
    private String sex;
    private String blood;
}
