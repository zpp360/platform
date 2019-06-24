package com.zhengpp.platform.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class CommonExceptionHandler {
    private static Logger log = Logger.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e){
        //输错错误到日志文件
        log.error(e,e);
        //返回系统异常
        return "error";
    }

}
