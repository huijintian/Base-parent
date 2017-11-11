package com.base.akka.wordCount.simple.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import com.base.akka.wordCount.simple.message.MapData;
import com.base.akka.wordCount.simple.message.ReduceData;
import com.base.akka.wordCount.simple.message.WordCount;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mengtian on 2017/11/11
 */
public class ReduceActor extends AbstractActor {

    private ActorRef aggragateActor = null;

    public ReduceActor(ActorRef aggragateActor) {
        this.aggragateActor = aggragateActor;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(MapData.class, message -> {
                    ReduceData reduceData = reduce(message.getWordCounts());
                    aggragateActor.tell(reduceData, self());
                })
                .build();
    }

    private ReduceData reduce(List<WordCount> wordCounts) {
        HashMap<String, Integer> reduce = new HashMap<>();
        for (WordCount wordCount : wordCounts) {
            if (reduce.containsKey(wordCount.getWord())) {
                reduce.put(wordCount.getWord(), reduce.get(wordCount.getWord()) + 1);
            } else {
                reduce.put(wordCount.getWord(), 1);
            }
        }
        return new ReduceData(reduce);
    }
}
