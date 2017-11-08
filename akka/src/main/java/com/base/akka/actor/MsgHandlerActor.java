package com.base.akka.actor;

import akka.actor.AbstractActor;
import com.base.akka.msg.ChineseMsg;
import com.base.akka.msg.EnglishMsg;

/**
 * Created by mengtian on 2017/11/8
 */
public class MsgHandlerActor extends AbstractActor {

    @Override
    public void preStart() throws Exception {
        System.out.println("msg handler init");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ChineseMsg.class, m -> {
                    System.out.println("当前线程：" + Thread.currentThread().getName());
                    System.out.println("中文消息:" + m.toString());
                    Thread.sleep(3000l);
                    System.out.println(m.getDesc() + "处理完成");
                })
                .match(EnglishMsg.class, m -> {
                    System.out.println("当前线程：" + Thread.currentThread().getName());
                    System.out.println("英文消息:" + m.toString());
                    Thread.sleep(3000l);
                    System.out.println(m.getDesc() + "处理完成");
                })
                .matchAny(m -> {
                    System.out.println(m.getClass());
                }).build();
    }
}
