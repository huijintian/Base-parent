package com.base.akka.calculator.strategyAndChild;

import akka.actor.*;
import akka.actor.TypedActor.Receiver;
import akka.actor.TypedActor.PreStart;
import akka.actor.TypedActor.PostStop;
import akka.actor.TypedActor.Supervisor;
import akka.dispatch.Futures;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Function;
import akka.japi.Option;
import com.base.akka.calculator.CalculatorInt;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by mengtian on 2017/11/12
 */
public class SupervisorActor implements Receiver, PreStart, PostStop, Supervisor, CalculatorInt {

    LoggingAdapter log = Logging.getLogger(TypedActor.context().system(), this);
    Integer counter = 0;

    ActorRef childActor = TypedActor.context().actorOf(
            Props.create(ChildActor.class), "childActor");

    @Override
    public void postStop() {
        log.info("Actor stop.");
    }

    @Override
    public void preStart() {
        log.info("Actor start.");
    }

    @Override
    public void onReceive(Object message, ActorRef actorRef) {
        log.info("Received message -> {}", message);
        log.info("sender :{}", TypedActor.context().sender());
        if (message instanceof Integer) {
            System.out.println(message);
        } else {
            childActor.tell(message, TypedActor.context().self());
        }
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

    @Override
    public SupervisorStrategy supervisorStrategy() {
        System.out.println(8888);
        return strategy;
    }

    private static SupervisorStrategy strategy = new OneForOneStrategy(10, Duration.apply(10, TimeUnit.SECONDS), new Function<Throwable, SupervisorStrategy.Directive>() {
        @Override
        public SupervisorStrategy.Directive apply(Throwable throwable) throws Exception {
            if (throwable instanceof ArithmeticException) {
                return SupervisorStrategy.resume();
            } else if (throwable instanceof IllegalArgumentException) {
                return SupervisorStrategy.restart();
            } else if (throwable instanceof NullPointerException) {
                return SupervisorStrategy.stop();
            }
            return SupervisorStrategy.escalate();
        }
    });
}
