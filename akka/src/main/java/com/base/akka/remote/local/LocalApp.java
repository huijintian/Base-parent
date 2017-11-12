package com.base.akka.remote.local;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.base.akka.remote.local.actors.LocalActor;
import com.typesafe.config.ConfigFactory;

/**
 * Created by mengtian on 2017/11/12
 */
public class LocalApp {

    public static void main(String[] args) throws InterruptedException {
        ActorSystem actorSystem = ActorSystem.create("localNodeApp", ConfigFactory.load().getConfig("localSys"));

        ActorRef localActor = actorSystem.actorOf(Props.create(LocalActor.class), "localActor");
        localActor.tell("Hello", ActorRef.noSender());

        Thread.sleep(5000l);
//        actorSystem.terminate();
    }
}
