package com.base.akka.future.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.dispatch.Futures;
import akka.dispatch.Mapper;
import akka.util.Timeout;
import com.base.akka.future.message.Address;
import com.base.akka.future.message.Order;
import com.base.akka.future.message.OrderHistory;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import static akka.pattern.Patterns.ask;
import static akka.pattern.Patterns.pipe;

/**
 * Created by mengtian on 2017/11/11
 */
public class ProcessOrderActor extends AbstractActor {

    final ExecutionContext ec = getContext().getSystem().dispatcher();

    final Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));
    ActorRef orderActor = getContext().actorOf(Props.create(OrderActor.class), "orderActor");
    ActorRef addressActor = getContext().actorOf(Props.create(AddressActor.class), "addressActor");
    ActorRef orderAggregateActor = getContext().actorOf(Props.create(OrderAggrerateActor.class), "orderAggregate");

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Integer.class, userId -> {
                    final ArrayList<Future<Object>> futures = new ArrayList<>();
                    futures.add(ask(orderActor, userId, timeout));
                    futures.add(ask(addressActor, userId, timeout));

                    final Future<Iterable<Object>> aggregate = Futures.sequence(futures, ec);
                    final Future<OrderHistory> aggResult = aggregate
                            .map(new Mapper<Iterable<Object>, OrderHistory>() {
                                @Override
                                public OrderHistory apply(Iterable<Object> parameter) {
                                    final Iterator<Object> iterable = parameter.iterator();
                                    final Order order = (Order) iterable.next();
                                    final Address address = (Address) iterable.next();
                                    return new OrderHistory(order, address);
                                }
                            }, ec);

                    pipe(aggResult, ec).to(orderAggregateActor);
                })
                .build();
    }
}
