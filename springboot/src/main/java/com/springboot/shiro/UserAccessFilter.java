package com.springboot.shiro;

import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by mengtian on 2017/12/28
 */
public class UserAccessFilter extends UserFilter {
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        response.getWriter().write("{code:404}");
        response.flushBuffer();
    }
}
