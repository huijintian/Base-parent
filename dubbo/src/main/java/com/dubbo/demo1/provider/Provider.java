package com.dubbo.demo1.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by mengtian on 2018/3/7
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "demo1/provider.xml");

        context.start();
        System.in.read();
    }
}
