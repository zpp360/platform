package com.zhengpp.platform.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContorller {

    private static Logger log = Logger.getLogger(HelloContorller.class);

    @GetMapping(name = "hello")
    public String hello(){
        log.error("error:hello");
        return "hello";
    }

}
