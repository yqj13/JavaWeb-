package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.controller.Request.Oldorrequest;
import com.example.springboot.entity.Oldor;
import com.example.springboot.entity.Result;
import com.example.springboot.service.impl.OldorService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class OldorController {

    @Autowired
    private OldorService oldorService;
    @GetMapping("/page")
    public Result queryByPage(Oldorrequest oldorrequest){
        oldorrequest.setPageNum((oldorrequest.getCurrentPage() - 1) * oldorrequest.getPageSize());
        List<Oldor> oldors = oldorService.queryByPage(oldorrequest);
        long count = oldorService.count(oldorrequest);
        Map<String, Object> map = new HashMap<>();
        map.put("data",oldors);
        map.put("total", count);
        return Result.success(map);
    }

    @GetMapping("/selectBMI")
    public Result selectBMI(){
        Integer thin = oldorService.selectBMIThin();
        Integer normal = oldorService.selectBMINormal();
        Integer overweight = oldorService.selectBMIOverWeight();

        Integer integer = oldorService.selectBMIFat();
        Map<String, Integer> map = new HashMap<>();

        map.put("thin", thin);
        map.put("normal", normal);
        map.put("overweight", overweight);

        map.put("fat", integer);
        System.out.println(map);
        return Result.success(map);
    }
    @GetMapping("/selectHight")
    public Result selectHight(){
        Integer hight1 = oldorService.selectHight1();
        Integer hight2 = oldorService.selectHight2();
        Integer hight3 = oldorService.selectHight3();
        Integer hight4 = oldorService.selectHight4();
        Integer hight5 = oldorService.selectHight5();
        Map<String, Integer> map = new HashMap<>();
        map.put("hight1", hight1);
        map.put("hight2", hight2);
        map.put("hight3", hight3);
        map.put("hight4", hight4);
        map.put("hight5", hight5);
        return Result.success(map);
    }
    @GetMapping("/selectWeight")
    public Result selectWeight(){
        Integer weight1 = oldorService.selectWeight1();
        Integer weight2 = oldorService.selectWeight2();
        Integer weight3 = oldorService.selectWeight3();
        Integer weight4 = oldorService.selectWeight4();
        Integer weight5 = oldorService.selectWeight5();
        Map<String, Integer> map = new HashMap<>();
        map.put("weight1", weight1);
        map.put("weight2", weight2);
        map.put("weight3", weight3);
        map.put("weight4", weight4);
        map.put("weight5", weight5);
        return Result.success(map);
    }
    @PostMapping("/oldor")
    public Result save(@RequestBody Oldor oldor){
        oldor.setTime(getCurrentDate());
        boolean save = oldorService.save(oldor);
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
        Oldor byId = oldorService.getById(id);
        return Result.success(byId);
    }
    @PutMapping()
    public Result update(@RequestBody Oldor oldor){
        System.out.println(oldor);
        oldor.setTime(getCurrentDate());
        boolean b = oldorService.saveOrUpdate(oldor);
        System.out.println(b);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
       oldorService.removeById(id);
        return Result.success();
    }

    @GetMapping("/report")
    public Result queryNormal(){
        Map [] maps = new Map[2];
        Map<String, List<String>> map = new HashMap<>();
        Map<String,Integer> map1 = new HashMap<>();

        List<String> normal = oldorService.queryNormal();
        int normalNum = normal.size();
        List<String> higher = oldorService.queryHigher();
        int higherNum = higher.size();
        List<String> lower = oldorService.queryLower();
        int lowerNum = lower.size();
        map.put("normal", normal);
        map.put("higher", higher);
        map.put("lower", lower);
        map1.put("normalNum", normalNum);
        map1.put("higherNum", higherNum);
        map1.put("lowerNum", lowerNum);

        List<String> noReport = oldorService.queryNoReport();
        int noReportNum = noReport.size();
        map.put("noReport", noReport);
        map1.put("noReportNum", noReportNum);
        maps[0] = map;
        maps[1] = map1;
        System.out.println(maps);
        return Result.success(maps);
    }

}
