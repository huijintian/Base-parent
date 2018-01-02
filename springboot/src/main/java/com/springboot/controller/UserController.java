package com.springboot.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mengtian on 2017/12/27
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{id}")
    @ResponseBody
    @RequiresPermissions("read")
    public String info(@PathVariable("id") Integer id) {
        return "as:" + id;
    }
}
