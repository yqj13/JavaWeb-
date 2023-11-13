package com.example.springboot.controller.Request;

import lombok.Data;

@Data
public class Messagerequest {
    private Integer pageSize;
    private Integer pageNum;
    private Integer currentPage;
    private String title;
}
