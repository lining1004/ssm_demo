package com.briup.web.exceptionhandler;

import com.briup.utils.Result;
import com.briup.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 * 本质 aop 中异常通知
 * @Author lining
 * @Date 2022/10/17
 */
@ControllerAdvice //扫描com.briup
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception ex){
        //根据不同的异常类型，返回的信息也是不同
        return ResultUtil.error(ex.getMessage());
    }
}
