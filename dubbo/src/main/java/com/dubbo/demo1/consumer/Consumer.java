package com.dubbo.demo1.consumer;

import com.dubbo.demo1.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mengtian on 2018/3/7
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("" +
                "demo1/consumer.xml");
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        String hello = demoService.sayHello("world");
        System.out.println(hello);
    }
}
