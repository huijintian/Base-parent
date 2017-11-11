package com.base.akka.calculator.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.util.Timeout;
import com.base.akka.calculator.Calculator;
import com.base.akka.calculator.CalculatorInt;
import akka.japi.Option;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;


/**
 * Created by mengtian on 2017/11/11
 */
public class CalculatorActorSystem1 {
    public static void main(String[] args) throws Exception {
        ActorSystem actorSystem = ActorSystem.create("TypedActors");
        Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));

        CalculatorInt calculator = TypedActor.get(actorSystem).typedActorOf(
                new TypedProps<>(CalculatorInt.class, Calculator.class));

        calculator.incrementCount();

        Future<Integer> future = calculator.add(Integer.valueOf(14), Integer.valueOf(6));

        Integer result = Await.result(future, timeout.duration());

        System.out.println("result is :" + result);

        Option<Integer> counterResult = calculator.incrementAndReturn();
        System.out.println("result is :" + counterResult);

        counterResult = calculator.incrementAndReturn();
        System.out.println("result is :" + counterResult);

        //此时才会初始化actor
        ActorRef calActor = TypedActor.get(actorSystem).getActorRefFor(calculator);
        calActor.tell("hi there", ActorRef.noSender());

        actorSystem.terminate();

    }
}
