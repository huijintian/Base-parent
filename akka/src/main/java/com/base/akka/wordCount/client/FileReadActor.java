package com.base.akka.wordCount.client;

import akka.actor.AbstractActor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mengtian on 2017/11/10
 */
public class FileReadActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, m -> {
                    String fileName = m;
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(
                                    Thread.currentThread()
                                            .getContextClassLoader()
                                            .getResource(fileName)
                                            .openStream()))) {
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            sender().tell(line, self());
                        }
                        System.out.println("all lines send!");
                        sender().tell("EOF", self());
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }).build();
    }
}
