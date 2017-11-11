package com.base.akka.future;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.base.akka.future.actors.ProcessOrderActor;

/**
 * Created by mengtian on 2017/11/11
 */
public class FutureApp {
    public static void main(String[] args) throws InterruptedException {
        ActorSystem actorSystem = ActorSystem.create("future");
        ActorRef processActor = actorSystem.actorOf(Props.create(ProcessOrderActor.class));
        processActor.tell(Integer.valueOf(456), ActorRef.noSender());

        Thread.sleep(5000l);

        actorSystem.terminate();
    }
}
