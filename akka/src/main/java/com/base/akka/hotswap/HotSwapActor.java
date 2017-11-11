package com.base.akka.hotswap;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by mengtian on 2017/11/11
 */
public class HotSwapActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    System.out.println("hi, i am actor. receive message:" + message);
                    getContext().become(receiveBuilder()
                            .match(String.class, m -> {
                                System.out.println("ho. receive message:" + m);
                                //importance
                                getContext().unbecome();
                            })
                            .build(), false);
                })
                .build();
    }

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("hotSwap");
        ActorRef actor = actorSystem.actorOf(Props.create(HotSwapActor.class), "hotActor");
        actor.tell("1", ActorRef.noSender());
        actor.tell("2", ActorRef.noSender());
        actor.tell("3", ActorRef.noSender());
        actor.tell("4", ActorRef.noSender());
        actor.tell("5", ActorRef.noSender());
        actor.tell("6", ActorRef.noSender());
        actorSystem.terminate();
    }
}
