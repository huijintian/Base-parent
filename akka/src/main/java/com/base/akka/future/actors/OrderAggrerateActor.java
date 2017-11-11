package com.base.akka.future.actors;

import akka.actor.AbstractActor;
import com.base.akka.future.message.OrderHistory;

/**
 * Created by mengtian on 2017/11/11
 */
public class OrderAggrerateActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(OrderHistory.class, orderHistory -> {
                    System.out.println(orderHistory);
                }).build();
    }
}
