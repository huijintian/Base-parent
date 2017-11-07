package com.base.akka.actor;

import akka.actor.UntypedAbstractActor;

/**
 * Created by mengtian on 2017/11/7
 * 模拟耗时actor
 */
public class ConsumeActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String) {
            Thread.sleep(3000l);
            System.out.println("received a message:" + message + " , but need more time to deal.");
            sender().tell("deal over.", self());
        } else {
            unhandled(message);
        }
    }
}
