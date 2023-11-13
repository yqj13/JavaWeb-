package com.example.springboot.mapper;


import com.example.springboot.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    Admin selectByUsername(String userName);

//    Admin update(Admin ad);
@Insert("insert into admin(userName, password, phone) "+
"values (#{userName}, #{password}, #{phone})")
    void insert(Admin ad);
}
