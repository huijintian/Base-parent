package com.base.akka.calculator;

import akka.actor.ActorRef;
import akka.actor.TypedActor;
import akka.actor.TypedActor.Receiver;
import akka.actor.TypedActor.PreStart;
import akka.actor.TypedActor.PostStop;
import akka.dispatch.Futures;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Option;
import scala.concurrent.Future;

/**
 * Created by mengtian on 2017/11/11
 */
public class Calculator implements Receiver, PreStart, PostStop, CalculatorInt {

    LoggingAdapter log = Logging.getLogger(TypedActor.context().system(), this);

    Integer counter = 0;

    @Override
    public void postStop() {
        log.info("Actor stop.");
    }

    @Override
    public void preStart() {
        log.info("Actor start.");
    }

    @Override
    public void onReceive(Object msg, ActorRef actorRef) {
        log.info("Received message -> {}", msg);
    }

    @Override
    public Future<Integer> add(Integer first, Integer second) {
        return Futures.successful(first + second);
    }

    @Override
    public Future<Integer> subtract(Integer first, Integer second) {
        return Futures.successful(first - second);
    }

    @Override
    public void incrementCount() {
        counter++;
    }

    @Override
    public Option<Integer> incrementAndReturn() {
        return Option.some(++counter);
    }
}
