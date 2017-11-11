package com.base.akka.future.actors;

import akka.actor.AbstractActor;
import com.base.akka.future.message.Order;

/**
 * Created by mengtian on 2017/11/11
 */
public class OrderActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Integer.class, orderId -> {
                    Order order = new Order(orderId, Float.valueOf(345), Integer.valueOf(5));
                    getSender().tell(order, self());
                })
                .build();
    }
}
