package com.base.akka.wordCount.simple.message;

import java.util.List;

/**
 * Created by mengtian on 2017/11/11
 */
public class MapData {
    private List<WordCount> wordCounts;

    public MapData(List<WordCount> wordCounts) {
        this.wordCounts = wordCounts;
    }

    public List<WordCount> getWordCounts() {
        return wordCounts;
    }
}
