package com.base.akka.simple.actor;

import akka.actor.AbstractActor;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.Creator;
import com.base.akka.simple.msg.Msg;

/**
 * Created by mengtian on 2017/11/7
 */
public class EventActor extends AbstractActor {

    //用于初始化actor、同类的构造函数
    //https://my.oschina.net/xinxingegeya/blog/366447
    public static Props props() {
        return Props.create(new Creator<Actor>() {
            @Override
            public Actor create() throws Exception {
                return new EventActor();
            }
        });
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Msg.class, m -> {
                    System.out.println("receive msg");
                    ActorRef child = getContext().actorOf(Props.create(MsgHandlerActor.class).withDispatcher("my-thread-pool-dispatcher"));
//                    Patterns.ask(child, m, 0l);
                    child.tell(m, self());
                })
                .build();
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("start event");
    }
}
