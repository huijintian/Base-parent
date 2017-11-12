package com.base.akka.dispatcher.Actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinPool;
import com.typesafe.config.ConfigFactory;

/**
 * Created by mengtian on 2017/11/12
 */
public class PinnedDispatcher {

    public static void main(String[] args) throws InterruptedException {
        ActorSystem actorSystem = ActorSystem.create("pinnedDispatcher",
                ConfigFactory.load().getConfig("MyDispatcherExample"));

        ActorRef actorRef = actorSystem.actorOf(Props.create(MsgEchoActor.class)
                .withDispatcher("pinnedDispatcher").withRouter(new RoundRobinPool(5)));

        for (int i = 0; i < 25; i++) {
            actorRef.tell(i, ActorRef.noSender());
        }
        Thread.sleep(5000);
        actorSystem.terminate();
    }

}
