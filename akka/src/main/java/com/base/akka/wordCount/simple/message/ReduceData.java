package com.base.akka.wordCount.simple.message;

import java.util.HashMap;

/**
 * Created by mengtian on 2017/11/11
 */
public class ReduceData {
    private HashMap<String, Integer> reduceData;

    public ReduceData(HashMap<String, Integer> reduceData) {
        this.reduceData = reduceData;
    }

    public HashMap<String, Integer> getReduceData() {
        return reduceData;
    }
}
