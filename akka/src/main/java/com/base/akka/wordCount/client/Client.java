package com.base.akka.wordCount.client;

import akka.actor.*;
import akka.japi.Creator;
import akka.kernel.Bootable;
import com.typesafe.config.ConfigFactory;

/**
 * Created by mengtian on 2017/11/10
 */
public class Client implements Bootable {
    @Override
    public void startup() {

    }

    @Override
    public void shutdown() {

    }

    public static void main(String[] args) {
        final String fileName = "";

        ActorSystem actorSystem = ActorSystem.create("ClientApplication",
                ConfigFactory.load().getConfig("WCMapReduceClientApp"));

        final ActorRef fileReadActor = actorSystem.actorOf(Props.create(FileReadActor.class));

        final ActorRef remoteActor = actorSystem.actorFor("akka://WCMapReduceApp@127.0.0.1:2552/user/WCMapReduceActor");

        ActorRef actorRef = actorSystem.actorOf(Props.create(new Creator() {
            @Override
            public Object create() throws Exception {
                return new ClientActor(remoteActor);
            }
        }));

        fileReadActor.tell(fileName, actorRef);

        remoteActor.tell("DISPLAY_LIST", ActorRef.noSender());

        actorSystem.terminate();
    }
}
