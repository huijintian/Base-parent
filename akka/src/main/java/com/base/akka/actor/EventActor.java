package com.base.akka.actor;

import akka.actor.AbstractActor;
import com.base.akka.msg.ChineseMsg;
import com.base.akka.msg.EnglishMsg;

/**
 * Created by mengtian on 2017/11/7
 */
public class EventActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ChineseMsg.class, m -> {
                    System.out.println("中文");
                    System.out.println(m.getDesc());
                    Thread.sleep(3000l);
                })
                .match(EnglishMsg.class, m -> {
                    System.out.println("英文");
                    System.out.println(m.getDesc());
                    Thread.sleep(3000l);
                })
                .build();
    }
}
