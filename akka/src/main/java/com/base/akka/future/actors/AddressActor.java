package com.base.akka.future.actors;

import akka.actor.AbstractActor;
import com.base.akka.future.message.Address;

/**
 * Created by mengtian on 2017/11/11
 */
public class AddressActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Integer.class, userId -> {
                    Address address = new Address(userId, "mengtian",
                            "shenzhen china", "sanmin fujian");
                    getSender().tell(address, self());
                })
                .build();
    }
}
