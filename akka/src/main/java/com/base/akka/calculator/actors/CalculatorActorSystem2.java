package com.base.akka.calculator.actors;

import akka.actor.*;
import akka.routing.BalancingPool;
import akka.routing.Broadcast;
import akka.routing.BroadcastPool;
import akka.routing.RouterConfig;
import com.base.akka.calculator.Calculator;
import com.base.akka.calculator.CalculatorInt;

import java.util.Arrays;

/**
 * Created by mengtian on 2017/11/12
 */
public class CalculatorActorSystem2 {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("TypedActor");
        CalculatorInt calculator = TypedActor.get(actorSystem).typedActorOf(
                new TypedProps<>(CalculatorInt.class, Calculator.class)
        );

        CalculatorInt calculator2 = TypedActor.get(actorSystem).typedActorOf(
                new TypedProps<>(CalculatorInt.class, Calculator.class)
        );

        System.out.println("--------");
        ActorRef actor1 = TypedActor.get(actorSystem).getActorRefFor(calculator);
        System.out.println("actor1");
        ActorRef actor2 = TypedActor.get(actorSystem).getActorRefFor(calculator2);
        System.out.println("actor2");
        Iterable<ActorRef> routes = Arrays.asList(actor1, actor2);
        //todo
    }
}
