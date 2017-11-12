package com.base.akka.remote.remote;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.base.akka.remote.remote.actors.RemoteActor;
import com.typesafe.config.ConfigFactory;

/**
 * Created by mengtian on 2017/11/12
 */
public class RemoteApp {

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("RemoteNodeApp",
                ConfigFactory.load().getConfig("remoteSys"));

        ActorRef remoteActor = actorSystem.actorOf(Props.create(RemoteActor.class), "remoteActor");

        System.out.println("remoteNode ready");
    }
}
