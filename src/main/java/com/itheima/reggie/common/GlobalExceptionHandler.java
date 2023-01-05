package com.itheima.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理，底层基于代理，代理controller
 * 通过aop把方法拦截到，如果抛异常，统一在此处处理
 * @ControllerAdvice用于：
 * 全局异常处理
 * 全局数据绑定
 * 全局数据预处理
 * @ResponseBody
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody //将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML数据。表示该方法的返回结果直接写入HTTP响应正文中，一般在异步获取数据时使用
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());
        //处理异常信息
        if(ex.getMessage().contains("Duplicate entry")){
            String[] split = ex.getMessage().split(" ");//选中split ctrl+alt+v  regex（正则表达式）：使用谁进行分割 此处是空格
            String msg = split[2]+"已存在";
            return R.error(msg);
        }
        return R.error("未知错误");
    }

}
