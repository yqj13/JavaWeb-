package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.controller.Request.Oldorrequest;
import com.example.springboot.entity.Oldor;
import com.example.springboot.mapper.OldorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OldorService extends ServiceImpl<OldorMapper, Oldor> {
    @Autowired
    private OldorMapper oldorMapper;
    public List<Oldor> queryByPage(Oldorrequest oldorrequest) {
        return oldorMapper.queryByPage(oldorrequest.getPageNum(), oldorrequest.getPageSize(), oldorrequest.getName(), oldorrequest.getSex(), oldorrequest.getBlood());
    }
    public long count(Oldorrequest oldorrequest) {
        return oldorMapper.count(oldorrequest);
    }

    public List<String> queryNormal() {
        List<String> strings = oldorMapper.queryNormal();
        return strings;
    }

    public List<String> queryHigher() {
        List<String> strings = oldorMapper.queryHigher();
        return strings;
    }

    public List<String> queryLower() {
        List<String> strings = oldorMapper.queryLower();
        return strings;
    }

    public List<String> queryNoReport() {
        List<String> strings= oldorMapper.queryNoReport();
        return strings;
    }


    public Integer selectBMIThin() {
        Integer integer = oldorMapper.selectBMIThin();
        return integer;
    }

    public Integer selectBMINormal() {
        Integer integer = oldorMapper.selectBMINormal();
        return integer;
    }

    public Integer selectBMIOverWeight() {
        Integer integer = oldorMapper.selectBMIOverWeight();
        return integer;
    }

    public Integer selectBMIFat() {
        Integer integer = oldorMapper.selectBMIFat();
        return integer;
    }

    public Integer selectHight1() {
        Integer integer = oldorMapper.selectHight1();
        return integer;
    }

    public Integer selectHight2() {
        Integer integer = oldorMapper.selectHight2();
        return integer;
    }

    public Integer selectHight3() {
        Integer integer = oldorMapper.selectHight3();
        return integer;
    }

    public Integer selectHight4() {
        Integer integer = oldorMapper.selectHight4();
        return integer;
    }

    public Integer selectHight5() {
        Integer integer = oldorMapper.selectHight5();
        return integer;
    }

    public Integer selectWeight1() {
        Integer integer = oldorMapper.selectWeight1();
        return integer;
    }

    public Integer selectWeight2() {
        Integer integer = oldorMapper.selectWeight2();
        return integer;
    }

    public Integer selectWeight3() {
        Integer integer = oldorMapper.selectWeight3();
        return integer;
    }

    public Integer selectWeight4() {
        Integer integer = oldorMapper.selectWeight4();
        return integer;
    }

    public Integer selectWeight5() {
        Integer integer = oldorMapper.selectWeight5();
        return integer;
    }
}

