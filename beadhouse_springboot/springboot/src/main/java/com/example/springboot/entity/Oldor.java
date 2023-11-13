package com.example.springboot.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Thread;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "oldor")
public class Oldor {
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String time;
    private String name;
    private String sex;
    private String phone;
    private double height;
    private double weight;
    private String blood;
    @TableField(value = "systolic_pressure")
    private Integer systolicPressure;
    @TableField(value = "diastolic_pressure")
    private Integer diastolicPressure;
    @TableField(value = "blood_sugar")
    private double bloodSugar;

}
