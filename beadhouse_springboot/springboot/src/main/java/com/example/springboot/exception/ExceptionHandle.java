package com.example.springboot.exception;


import com.example.springboot.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public Result serviceExceptionError(ServiceException e){
        log.error("业务异常", e);
        return Result.error(e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionError(Exception e){
        e.printStackTrace();
        return Result.error("系统错误");
    }
}
