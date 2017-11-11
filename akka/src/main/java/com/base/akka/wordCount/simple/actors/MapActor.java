package com.base.akka.wordCount.simple.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import com.base.akka.wordCount.simple.message.MapData;
import com.base.akka.wordCount.simple.message.WordCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by mengtian on 2017/11/11
 */
public class MapActor extends AbstractActor {

    private ActorRef reduceActor = null;

    private List<String> STOP_WORD = Arrays.asList(new String[]{"a", "an", "and"});

    public MapActor(ActorRef reduceActor) {
        this.reduceActor = reduceActor;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    MapData data = evaluateExpression(message);
                    reduceActor.tell(data, self());
                })
                .build();
    }

    private MapData evaluateExpression(String message) {
        List<WordCount> wordCounts = new ArrayList<>();
        StringTokenizer parse = new StringTokenizer(message);
        while (parse.hasMoreTokens()) {
            String word = parse.nextToken().toLowerCase();
            if (!STOP_WORD.contains(word)) {
                wordCounts.add(new WordCount(word, Integer.valueOf(1)));
            }
        }
        return new MapData(wordCounts);
    }
}
