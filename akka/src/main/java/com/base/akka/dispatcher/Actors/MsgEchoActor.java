package com.base.akka.dispatcher.Actors;

import akka.actor.AbstractActor;

/**
 * Created by mengtian on 2017/11/12
 */
public class MsgEchoActor extends AbstractActor {

    int messageProcessed = 0;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchAny(message -> {
                    Thread.sleep((int)message * 100l);
                    messageProcessed++;
                    System.out.println(String.format("received message '%s' in Actor %s " +
                                    "using Thread id: %s, name: %s" +
                                    "total message processed %s",
                            message, self().path().name(),
                            Thread.currentThread().getId(),
                            Thread.currentThread().getName(),
                            messageProcessed));
                    System.out.println(String.format("receive time: %s", System.currentTimeMillis()));
                }).build();
    }
}
