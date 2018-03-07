package com.dubbo.demo1.provider;

import com.dubbo.demo1.DemoService;

/**
 * Created by mengtian on 2018/3/7
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println(" be called");
        return "Hello " + name;
    }
}
