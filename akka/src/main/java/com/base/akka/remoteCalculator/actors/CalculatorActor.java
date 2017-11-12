package com.base.akka.remoteCalculator.actors;

import akka.actor.AbstractActor;
import com.base.akka.remoteCalculator.op.Op;

/**
 * Created by mengtian on 2017/11/12
 */
public class CalculatorActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Op.Add.class, add -> {
                    System.out.println("calculating " + add.getN1() + " + " + add.getN2());
                    Op.AddResult result = new Op.AddResult(add.getN1(), add.getN2(),
                            add.getN1() + add.getN2());
                    sender().tell(result, self());
                })
                .match(Op.Subtract.class, subtract -> {
                    System.out.println("calculating " + subtract.getN1() + " - " + subtract.getN2());
                    Op.SubtractResult result = new Op.SubtractResult(subtract.getN1(), subtract.getN2(),
                            subtract.getN1() - subtract.getN2());
                    sender().tell(result, self());
                })
                .match(Op.Multiply.class, multiply -> {
                    System.out.println("calculating " + multiply.getN1() + " * " + multiply.getN2());
                    Op.MultiplicationResult result = new Op.MultiplicationResult(multiply.getN1(), multiply.getN2(),
                            multiply.getN1() * multiply.getN2());
                    sender().tell(result, self());
                })
                .match(Op.Divide.class, divide -> {
                    System.out.println("calculating " + divide.getN1() + " / " + divide.getN2());
                    Op.DivisionResult result = new Op.DivisionResult(divide.getN1(), divide.getN2(),
                            divide.getN1() / divide.getN2());
                    sender().tell(result, self());
                })
                .build();
    }
}
