package com.base.akka.remote.local.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by mengtian on 2017/11/12
 */
public class LocalActor extends AbstractActor {

    LoggingAdapter log = Logging.getLogger(context().system(), this);
    Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));

    ActorSelection remoteSelection;

    @Override
    public void preStart() throws Exception {
        remoteSelection = getContext().actorSelection("akka.tcp://RemoteNodeApp@127.0.0.1:2552/user/remoteActor");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchAny(message -> {
                    Future<Object> future = Patterns.ask(remoteSelection, message, timeout);
                    Object result = Await.result(future, timeout.duration());
                    log.info("message receive from Server -> {}", result.toString());
                })
                .build();
    }
}
