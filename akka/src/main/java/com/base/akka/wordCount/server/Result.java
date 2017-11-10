package com.base.akka.wordCount.server;

import java.io.Serializable;

/**
 * Created by mengtian on 2017/11/10
 */
public class Result implements Serializable{
    private String word;
    private int noOfInstances;

    public Result(String word, int noOfInstances) {
        this.word = word;
        this.noOfInstances = noOfInstances;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNoOfInstances() {
        return noOfInstances;
    }

    public void setNoOfInstances(int noOfInstances) {
        this.noOfInstances = noOfInstances;
    }
}
