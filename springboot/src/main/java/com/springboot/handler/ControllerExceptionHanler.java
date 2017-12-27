package com.springboot.handler;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengtian on 2017/12/27
 */
@ControllerAdvice
public class ControllerExceptionHanler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHanler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleException(AuthorizationException e, Model model) {
        logger.error("权限验证出错", e);
        Map<String, Object> map = new HashMap<>();
        map.put("status", HttpStatus.FORBIDDEN.value());
        map.put("message", "No message available");
        model.addAttribute("errors", map);
        return "error";
    }
}
