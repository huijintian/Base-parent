package com.base.akka.wordCount.server;

import akka.actor.AbstractActor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by mengtian on 2017/11/10
 */
public class AggregateActor extends AbstractActor {

    private Map<String, Integer> finalReducedMap = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Map.class, m -> {
                    aggregateMemoryReduce(m);
                })
                .match(String.class, m -> {
                    if (m.compareTo("DISPLAY_LIST") == 0) {
                        System.out.println(finalReducedMap.toString());
                    }
                }).build();
    }

    private void aggregateMemoryReduce(Map reduces) {
        Iterator iterator = reduces.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (finalReducedMap.containsKey(key)) {
                Integer count = (Integer) reduces.get(key) + finalReducedMap.get(key);
                finalReducedMap.put(key, count);
            } else {
                finalReducedMap.put(key, (Integer) reduces.get(key));
            }
        }
    }
}
