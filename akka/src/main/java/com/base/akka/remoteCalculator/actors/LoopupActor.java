package com.base.akka.remoteCalculator.actors;

import akka.actor.*;
import com.base.akka.remoteCalculator.op.Op;
import scala.PartialFunction;
import scala.concurrent.duration.Duration;
import scala.runtime.BoxedUnit;

import java.util.concurrent.TimeUnit;

/**
 * Created by mengtian on 2017/11/13
 */
public class LoopupActor extends AbstractActor {
    private final String path;
    private ActorRef calculator = null;

    Receive active = receiveBuilder()
            .match(Op.MathOp.class, message -> {
                calculator.tell(message, self());
            })
            .match(Op.AddResult.class, add -> {
                System.out.println(String.format("add result: %d + %d = %d",
                        add.getN1(),
                        add.getN2(),
                        add.getResult()));
            })
            .match(Op.SubtractResult.class, sub -> {
                System.out.println(String.format("sub result: %d - %d = %d",
                        sub.getN1(),
                        sub.getN2(),
                        sub.getResult()));
            })
            .match(Terminated.class, terminated -> {
                System.out.println("calculator terminated.");
                sendIdentifyRequest();
                getContext().unbecome();
            })
            .match(ReceiveTimeout.class, message -> {

            })
            .build();


    public LoopupActor(String path) {
        this.path = path;
        sendIdentifyRequest();
    }

    private void sendIdentifyRequest() {
        getContext().actorSelection(path).tell(new Identify(path), self());
        getContext().system().scheduler().scheduleOnce(
                Duration.create(3, TimeUnit.SECONDS), self(), ReceiveTimeout.getInstance(),
                getContext().dispatcher(), self()
        );
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ActorIdentity.class, identity -> {
                    calculator = identity.getRef();
                    if (calculator == null) {
                        System.out.println("remote actor not available:" + path);
                    } else {
                        getContext().watch(calculator);
                        getContext().become(active, true);
                    }
                })
                .match(ReceiveTimeout.class, x -> {
                    sendIdentifyRequest();
                })
                .build();
    }
}
