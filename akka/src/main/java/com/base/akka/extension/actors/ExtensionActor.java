package com.base.akka.extension.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.base.akka.extension.setting.MySQLJDBCSettings;
import com.base.akka.extension.setting.MySQLJDBCSettingsImpl;
import com.typesafe.config.ConfigFactory;

/**
 * Created by mengtian on 2017/11/12
 */
public class ExtensionActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchAny(message -> {
                    MySQLJDBCSettingsImpl settings = MySQLJDBCSettings.settingProvider
                            .get(context().system());

                    System.out.println(settings.DB_USER_NAME);
                    System.out.println(settings.DB_USER_PASSWORD);
                })
                .build();
    }

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("extensionActor",
                ConfigFactory.load().getConfig("my-extension"));

        ActorRef actorRef = actorSystem.actorOf(Props.create(ExtensionActor.class));

        actorRef.tell("123", ActorRef.noSender());

        MySQLJDBCSettingsImpl settings = MySQLJDBCSettings.settingProvider
                .get(actorSystem);

        System.out.println(settings.DB_USER_NAME);
        System.out.println(settings.DB_USER_PASSWORD);

        actorSystem.terminate();
    }
}
