package com.base.akka.wordCount.client;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

/**
 * Created by mengtian on 2017/11/10
 */
public class ClientActor extends AbstractActor {

    private ActorRef remoteServer = null;

    private ActorRef fileReadActor = null;

    private long start;

    public ClientActor(ActorRef remoteServer) {
        this.remoteServer = remoteServer;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, m -> {
                    remoteServer.tell(m, self());
                }).build();
    }

    @Override
    public void preStart() throws Exception {
        start = System.currentTimeMillis();
    }

    @Override
    public void postStop() throws Exception {
        long timeSpent = (System.currentTimeMillis() - start) / 1000;
        System.out.println("timeSpent:" + timeSpent);
    }
}
