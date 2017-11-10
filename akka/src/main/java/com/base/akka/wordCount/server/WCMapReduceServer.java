package com.base.akka.wordCount.server;

import akka.actor.*;
import akka.dispatch.PriorityGenerator;
import akka.dispatch.UnboundedPriorityMailbox;
import akka.japi.Creator;
import akka.kernel.Bootable;
import akka.routing.RoundRobinPool;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Created by mengtian on 2017/11/10
 */
public class WCMapReduceServer implements Bootable {
    @Override
    public void startup() {

    }

    @Override
    public void shutdown() {

    }

    private ActorRef mapRouter;
    private ActorRef reduceRouter;
    private ActorRef aggregateActor;
    private ActorSystem actorSystem;
    private ActorRef wcMapReduceActor;

    public WCMapReduceServer(int no_of_reduce_workers, int no_of_map_workers) {
        actorSystem = ActorSystem.create("WCMapReduceApp", ConfigFactory.load().getConfig("WCMapReduceApp"));
        aggregateActor = actorSystem.actorOf(Props.create(AggregateActor.class));
        reduceRouter = actorSystem.actorOf(Props.create(new Creator<AbstractActor>() {
            @Override
            public AbstractActor create() throws Exception {
                return new ReduceActor(aggregateActor);
            }
        }).withRouter(new RoundRobinPool(no_of_reduce_workers)));

        mapRouter = actorSystem.actorOf(Props.create(new Creator() {
            @Override
            public Object create() throws Exception {
                return new MapActor(reduceRouter);
            }
        }).withRouter(new RoundRobinPool(no_of_map_workers)));

        wcMapReduceActor = actorSystem.actorOf(Props.create(new Creator<Actor>() {
            @Override
            public Actor create() throws Exception {
                return new WCMapReduceActor(aggregateActor, mapRouter);
            }
        }).withDispatcher("priorityMailBox-dispatcher"), "WCMapReduceActor");
    }

    public static void main(String[] args) {
        new WCMapReduceServer(5, 5);
    }

    public static class MypriorityMailBox extends UnboundedPriorityMailbox {
        public MypriorityMailBox(ActorSystem.Settings settings, Config config) {
            super(new PriorityGenerator() {
                @Override
                public int gen(Object message) {
                    if (message.equals("DISPLAY_LIST")) {
                        return 2;
                    } else if (message.equals(PoisonPill.getInstance())) {
                        return 3;
                    }
                    return 0;
                }
            });
        }
    }
}
