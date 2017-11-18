package com.springboot.process;

import com.google.common.io.LineProcessor;
import com.springboot.component.FileReadInComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengtian on 2017/11/18
 */
public class FileReadInProcess implements LineProcessor {

    private int count = 0;

    private FileReadInComponent fileReadInComponent;

    public FileReadInProcess(FileReadInComponent fileReadInComponent) {
        this.fileReadInComponent = fileReadInComponent;
    }

    private List<String> stopWords = new ArrayList<>();

    @Override
    public boolean processLine(String line) throws IOException {
        if (count != 0 && count % 1000 == 0) {
            fileReadInComponent.batchInsertStopWord(stopWords);
            stopWords.clear();
        }
        stopWords.add(line.trim());
        count++;
        return true;
    }

    @Override
    public Object getResult() {
        return "总行数" + count;
    }
}
