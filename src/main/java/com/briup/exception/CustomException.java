package com.briup.exception;

/**
 * 自定义异常类 表示当业务异常使用该类
 * @Author lining
 * @Date 2022/10/17
 */
public class CustomException extends RuntimeException{

    public CustomException(String message) {
        super(message);
    }
}
