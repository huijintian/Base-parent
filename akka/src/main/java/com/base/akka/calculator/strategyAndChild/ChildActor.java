package com.base.akka.calculator.strategyAndChild;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by mengtian on 2017/11/12
 */
public class ChildActor extends AbstractActor {

    LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public void preStart() throws Exception {
        log.info("child actor start -> :{}", self().path());
    }

    @Override
    public void postStop() throws Exception {
        log.info("child actor stop -> :{}", self().path());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    throw new IllegalArgumentException("boom!");
                })
                .match(Integer.class, value -> {
                    if (value <= 10) {
                        getSender().tell(value * value, self());
                    } else {
                        System.out.println(value);
                    }
                }).build();
    }
}
