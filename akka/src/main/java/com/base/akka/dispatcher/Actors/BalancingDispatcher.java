package com.base.akka.dispatcher.Actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.BalancingPool;
import com.typesafe.config.ConfigFactory;

/**
 * Created by mengtian on 2017/11/12
 */
public class BalancingDispatcher {
    public static void main(String[] args) throws InterruptedException {
        dispatcher1();
        dispatcher2();
    }

    public static void dispatcher1() throws InterruptedException {
        ActorSystem actorSystem = ActorSystem.create("balancing-dispatcher",
                ConfigFactory.load().getConfig("MyDispatcherExample"));
        ActorRef actorRef = actorSystem.actorOf(Props.create(MsgEchoActor.class)
                .withDispatcher("balancingDispatcher")
                .withRouter(new BalancingPool(5)));

        for (int i = 0; i < 25; i++) {
            actorRef.tell(i, ActorRef.noSender());
        }
        Thread.sleep(10000l);
        actorSystem.terminate();
    }

    public static void dispatcher2() {
    }
}
