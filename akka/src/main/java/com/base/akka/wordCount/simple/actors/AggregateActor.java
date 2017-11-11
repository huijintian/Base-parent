package com.base.akka.wordCount.simple.actors;

import akka.actor.AbstractActor;
import com.base.akka.wordCount.simple.message.ReduceData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengtian on 2017/11/11
 */
public class AggregateActor extends AbstractActor {

    private Map<String, Integer> finalResult = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ReduceData.class, message -> {
                    aggregateInMemoryReduce(message.getReduceData());
                })
                .match(String.class, m -> {
                    System.out.println(finalResult.toString());
                })
                .build();
    }

    private void aggregateInMemoryReduce(HashMap<String, Integer> reduceData) {
        Integer count = null;
        for (String key : reduceData.keySet()) {
            if (finalResult.containsKey(key)) {
                count = finalResult.get(key) + reduceData.get(key);
                finalResult.put(key, count);
            } else {
                finalResult.put(key, reduceData.get(key));
            }
        }
    }
}
