package com.base.akka.dispatcher.Actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinPool;
import com.typesafe.config.ConfigFactory;

/**
 * Created by mengtian on 2017/11/12
 */
public class Dispatcher {
    public static void main(String[] args) throws InterruptedException {
//        dispatcher1();
        dispatcher2();
    }

    private static void dispatcher1() throws InterruptedException {
        ActorSystem actorSystem = ActorSystem.create("default-dispatcher",
                ConfigFactory.load().getConfig("MyDispatcherExample"));
        ActorRef actorRef = actorSystem.actorOf(Props.create(MsgEchoActor.class)
                .withDispatcher("defaultDispatcher").withRouter(new RoundRobinPool(5)));
        for (int i = 0; i < 25; i++) {
            actorRef.tell(i, ActorRef.noSender());
        }
        Thread.sleep(5000l);
        actorSystem.terminate();
    }

    private static void dispatcher2() throws InterruptedException {
        ActorSystem actorSystem = ActorSystem.create("default-dispatcher",
                ConfigFactory.load().getConfig("MyDispatcherExample"));

        ActorRef actorRef = actorSystem.actorOf(Props.create(MsgEchoActor.class)
                .withDispatcher("defaultDispatcher1").withRouter(new RoundRobinPool(5)));
        for (int i = 0; i < 25; i++) {
            actorRef.tell(i, ActorRef.noSender());
        }
        Thread.sleep(5000l);
        actorSystem.terminate();
    }
}
