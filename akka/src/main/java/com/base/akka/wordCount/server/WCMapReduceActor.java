package com.base.akka.wordCount.server;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

/**
 * Created by mengtian on 2017/11/10
 */
public class WCMapReduceActor extends AbstractActor {

    private ActorRef mapRouter;
    private ActorRef aggregateActor;

    public WCMapReduceActor(ActorRef mapRouter, ActorRef aggregateActor) {
        this.mapRouter = mapRouter;
        this.aggregateActor = aggregateActor;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    if (message.compareTo("DISPLAY_LIST") == 0) {
                        aggregateActor.tell(message, sender());//sender?
                    } else {
                        mapRouter.tell(message, self());
                    }
                })
                .build();
    }
}
