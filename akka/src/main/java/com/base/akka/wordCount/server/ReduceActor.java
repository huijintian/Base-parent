package com.base.akka.wordCount.server;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import java.util.Iterator;
import java.util.List;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by mengtian on 2017/11/10
 */
public class ReduceActor extends AbstractActor {

    private ActorRef actorRef = null;

    public ReduceActor(ActorRef actorRef) {
        this.actorRef = actorRef;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(List.class, message -> {
                    NavigableMap reduced = reduce(message);
                    actorRef.tell(reduced, self());
                })
                .build();
    }

    private NavigableMap reduce(List message) {
        NavigableMap navigableMap = new ConcurrentSkipListMap();
        Iterator iterator = message.iterator();
        while (iterator.hasNext()) {
            Result result = (Result) iterator.next();
            if (navigableMap.containsKey(result.getWord())) {
                Integer value = (Integer) navigableMap.get(result.getWord());
                value++;
                navigableMap.put(result.getWord(), value);
            } else {
                navigableMap.put(result.getWord(), Integer.valueOf(1));
            }
        }
        return navigableMap;
    }
}
