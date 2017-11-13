package com.base.akka.remoteCalculator;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.base.akka.remoteCalculator.actors.CreationActor;
import com.base.akka.remoteCalculator.op.Op;
import com.typesafe.config.ConfigFactory;
import scala.concurrent.duration.Duration;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengtian on 2017/11/12
 */
public class CreationApplication {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals("CalculatorWorker")) {
            startRemoteWorkerSystem();
        }
        if (args.length == 0 || args[0].equals("Creation")) {
            startRemoteCreationSystem();
        }
    }

    private static void startRemoteWorkerSystem() {
        ActorSystem.create("Calculator",
                ConfigFactory.load("calculator"));
        System.out.println("started calculatorWorkerSystem");
    }

    private static void startRemoteCreationSystem() {
        final ActorSystem actorSystem = ActorSystem.create("CreationSystem",
                ConfigFactory.load("remotecreation"));

        final ActorRef actorRef = actorSystem.actorOf(Props.create(CreationActor.class),
                "creationActor");

        System.out.println("started CreationSystem");
        final Random random = new Random();
        actorSystem.scheduler().schedule(Duration.create(1, TimeUnit.SECONDS),
                Duration.create(1, TimeUnit.SECONDS),
                () -> {
                    if (random.nextInt(100) % 2 == 0) {
                        actorRef.tell(new Op.Multiply(random.nextInt(100), random.nextInt(100)),
                                null);
                    } else {
                        actorRef.tell(new Op.Divide(random.nextInt(10000), random.nextInt(99) + 1),
                                null);
                    }
                }, actorSystem.dispatcher());
    }
}
