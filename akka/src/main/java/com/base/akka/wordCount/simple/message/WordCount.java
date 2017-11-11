package com.base.akka.wordCount.simple.message;

/**
 * Created by mengtian on 2017/11/11
 */
public class WordCount {
    private String word;
    private Integer count;

    public WordCount(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }
}
