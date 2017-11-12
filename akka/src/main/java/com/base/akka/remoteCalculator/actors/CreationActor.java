package com.base.akka.remoteCalculator.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.base.akka.remoteCalculator.op.Op;

/**
 * Created by mengtian on 2017/11/12
 */
public class CreationActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Op.MathOp.class, message -> {
                    ActorRef calculator = getContext().actorOf(
                            Props.create(CalculatorActor.class));
                    calculator.tell(message, self());
                })
                .match(Op.MultiplicationResult.class, result -> {
                    System.out.println(String.format("mul result: %d * %d = %d",
                            result.getN1(),
                            result.getN2(),
                            result.getResult()));
                    getContext().stop(sender());
                })
                .match(Op.DivisionResult.class, result -> {
                    System.out.println(String.format("div result: %.0f / %d = %.2f",
                            result.getN1(),
                            result.getN2(),
                            result.getResult()));
                    getContext().stop(sender());
                })
                .build();
    }
}
