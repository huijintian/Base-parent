package com.base.akka.simple;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.base.akka.simple.actor.EventActor;
import com.base.akka.simple.msg.ChineseMsg;
import com.base.akka.simple.msg.EnglishMsg;
import com.base.akka.simple.msg.Message;
import com.base.akka.simple.msg.Msg;
import com.typesafe.config.ConfigFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengtian on 2017/11/7
 */
public class App {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("app", ConfigFactory.load());
        ActorRef actorRef = actorSystem.actorOf(Props.create(EventActor.class));

        actorSystem.eventStream().subscribe(actorRef, Msg.class);

        List<Msg> msgList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Msg msg = new ChineseMsg(Message.Chinases, "中文课" + i);
            msgList.add(msg);
        }

        for (int i = 0; i < 100; i++) {
            Msg msg = new EnglishMsg(Message.English, "英文" + i);
            msgList.add(msg);
        }
        for (Msg msg : msgList) {
            actorSystem.eventStream().publish(msg);
        }
//        actorSystem.terminate();
    }
}
