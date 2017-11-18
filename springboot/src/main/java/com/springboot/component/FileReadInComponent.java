package com.springboot.component;

import com.springboot.mapper.StopWordMapper;
import com.springboot.pojo.StopWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengtian on 2017/11/18
 */
@Component
public class FileReadInComponent {

    @Autowired
    private StopWordMapper stopWordMapper;

    public void batchInsertStopWord(List<String> words) {
        /*List<StopWord> wordList = new ArrayList<>();
        for (String word : words) {
            StopWord stopWord = new StopWord();
            stopWord.setStopWord(word);
            wordList.add(stopWord);
        }*/
        for (String word : words) {
            StopWord stopWord = new StopWord();
            stopWord.setStopWord(word);
            stopWordMapper.insertStopWord(stopWord);
        }
//        stopWordMapper.batchInsertStopWord(words);
    }
}
