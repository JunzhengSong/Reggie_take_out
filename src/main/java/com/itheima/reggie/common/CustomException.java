package com.itheima.reggie.common;

/**
 * 一般项目都有自己的异常类用于处理自定义的业务异常
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){//目的：将提示信息传进来
        super(message);
    }
}
