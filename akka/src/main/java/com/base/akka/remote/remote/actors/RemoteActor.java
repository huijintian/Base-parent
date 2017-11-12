package com.base.akka.remote.remote.actors;

import akka.actor.AbstractActor;

/**
 * Created by mengtian on 2017/11/12
 */
public class RemoteActor extends AbstractActor {

    @Override
    public void preStart() throws Exception {
        System.out.println("ready to receive message.");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    System.out.println("received message:" + message + " from " + sender());
                    getSender().tell("Hello, this is remote actor", self());
                }).build();
    }
}
