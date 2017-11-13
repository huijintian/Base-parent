package com.base.akka.remoteCalculator;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.base.akka.remoteCalculator.actors.CalculatorActor;
import com.base.akka.remoteCalculator.actors.LookupActor;
import com.base.akka.remoteCalculator.op.Op;
import com.typesafe.config.ConfigFactory;
import scala.concurrent.duration.Duration;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengtian on 2017/11/13
 */
public class LookupApplication {

    public static void main(String[] args) {
        startRemoteLookupSystem();

        /*if (args.length == 0 || args[0].equals("Calculator")) {
            startRemoteCalculatorSystem();
        } else {
            startRemoteLookupSystem();
        }*/
    }

    private static void startRemoteCalculatorSystem() {
        final ActorSystem actorSystem = ActorSystem.create("CalculatorSystem",
                ConfigFactory.load("calculator"));
        actorSystem.actorOf(Props.create(CalculatorActor.class), "calculator");
        System.out.println("started CalculatorSystem");
    }

    private static void startRemoteLookupSystem() {
        final ActorSystem actorSystem = ActorSystem.create("LookupSystem",
                ConfigFactory.load("remotelookup"));
        final String path = "akka.tcp://CalculatorSystem@127.0.0.1:2552/user/calculator";
        final ActorRef actor = actorSystem.actorOf(Props.create(LookupActor.class, path),
                "lookupActor");
        System.out.println("started lookupSystem");
        final Random random = new Random();
        actorSystem.scheduler().schedule(Duration.create(1, TimeUnit.SECONDS),
                Duration.create(1, TimeUnit.SECONDS), () -> {
                    if (random.nextInt(100) % 2 == 0) {
                        actor.tell(new Op.Add(random.nextInt(100), random.nextInt(100)),
                                null);
                    } else {
                        actor.tell(new Op.Subtract(random.nextInt(100), random.nextInt(100)),
                                null);
                    }
                }, actorSystem.dispatcher());
    }
}
