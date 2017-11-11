package com.base.akka.wordCount.simple.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

/**
 * Created by mengtian on 2017/11/11
 */
public class MasterActor extends AbstractActor {

    private ActorRef aggrageteActor = getContext()
            .actorOf(Props.create(AggregateActor.class), "aggregateActor");

    private ActorRef reduceActor = getContext()
            .actorOf(Props.create(ReduceActor.class, aggrageteActor), "reduceActor");

    private ActorRef mapActor = getContext()
            .actorOf(Props.create(MapActor.class, reduceActor), "mapActor");

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    if (message.equals("result")) {
                        aggrageteActor.tell(message, self());
                    } else {
                        mapActor.tell(message, self());
                    }
                })
                .build();
    }
}
