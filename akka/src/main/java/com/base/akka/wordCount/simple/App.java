package com.base.akka.wordCount.simple;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.base.akka.wordCount.simple.actors.MasterActor;

/**
 * Created by mengtian on 2017/11/11
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        ActorSystem actorSystem = ActorSystem.create("MapReduce");
        ActorRef master = actorSystem.actorOf(Props.create(MasterActor.class), "master");

        master.tell("The quick brown fox tried to jump over the lazy dog and fell on the dog", ActorRef.noSender());
        master.tell("Dog and Fox belong to the same family", ActorRef.noSender());

        Thread.sleep(3000l);
        master.tell("result", ActorRef.noSender());

        Thread.sleep(3000l);
        actorSystem.terminate();
    }
}
