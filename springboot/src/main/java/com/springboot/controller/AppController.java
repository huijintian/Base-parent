package com.springboot.controller;

import com.springboot.config.ConfigInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mengtian on 2017/11/18
 */
@Controller
public class AppController {

    @Autowired
    private ConfigInstance configInstance;

    @RequestMapping("/")
    @ResponseBody
    public String app() {
        return "hello world";
    }
}
