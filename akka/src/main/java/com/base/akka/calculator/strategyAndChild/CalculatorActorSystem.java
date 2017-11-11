package com.base.akka.calculator.strategyAndChild;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.base.akka.calculator.CalculatorInt;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by mengtian on 2017/11/12
 */
public class CalculatorActorSystem {
    public static void main(String[] args) throws Exception {
        ActorSystem actorSystem = ActorSystem.create("TypedActorWithStrategy");

        CalculatorInt calculator = TypedActor.get(actorSystem).typedActorOf(
                new TypedProps<SupervisorActor>(CalculatorInt.class, SupervisorActor.class),
                "supervisorActor"
        );

        ActorRef calActor = TypedActor.get(actorSystem).getActorRefFor(calculator);
        calActor.tell("hi there", ActorRef.noSender());

        Thread.sleep(500l);
        Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));
        Future<Object> future = Patterns.ask(calActor, Integer.valueOf(10), timeout);
        Integer result = (Integer) Await.result(future, timeout.duration());
        System.out.println("result from child actor:" + result);
        Thread.sleep(500l);
        actorSystem.terminate();

    }
}
