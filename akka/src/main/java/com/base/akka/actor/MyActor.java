package com.base.akka.actor;


import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.Option;

/**
 * Created by mengtian on 2017/11/7
 */
public class MyActor extends UntypedAbstractActor {

    LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    final ActorRef child = getContext().actorOf(Props.empty(), "myActor-child");

    @Override
    public void preStart() throws Exception {
        System.out.println("have a child");
        getContext().watch(child);
    }


    @Override
    public void onReceive(Object message) throws Throwable {
        if (message.equals("kill")) {
            System.out.println("kill child");
            getContext().stop(child);
        } else if (message.equals("sendtoOther")) {
            ActorRef consume = getContext().actorOf(Props.create(ConsumeActor.class));
            consume.tell(message, getSelf());
        } else if (message instanceof String) {
            System.out.println("received message:" + message);
        } else if (message == null) {
            throw new NullPointerException("message is null");
        } else {
            System.out.println("unhandle");
            unhandled(message);
        }
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        log.error(reason, "error message" + message);
        super.preRestart(reason, message);
    }

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("system");
        ActorRef myActor = actorSystem.actorOf(Props.create(MyActor.class), "myActor");
        myActor.tell("sendtoOther", ActorRef.noSender());
        myActor.tell(null, ActorRef.noSender());
    }
}
