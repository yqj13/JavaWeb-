package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.controller.Request.Oldorrequest;
import com.example.springboot.entity.Oldor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OldorMapper extends BaseMapper<Oldor> {
//    List<Oldor> queryByPage(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
    List<Oldor> queryByPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("name") String name, @Param("sex") String sex, @Param("blood") String blood);

    long count(Oldorrequest oldorrequest);

    List<String> queryNormal();

    List<String> queryHigher();

    List<String> queryLower();

    List<String> queryNoReport();


    Integer selectBMIThin();

    Integer selectBMINormal();

    Integer selectBMIOverWeight();

    Integer selectBMIFat();

    Integer selectHight1();

    Integer selectHight2();

    Integer selectHight3();

    Integer selectHight4();

    Integer selectHight5();

    Integer selectWeight1();

    Integer selectWeight2();

    Integer selectWeight3();

    Integer selectWeight4();

    Integer selectWeight5();
}

