package com.nlp.hanlp.process;

import com.google.common.io.LineProcessor;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NotionalTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengtian on 2017/11/13
 */
public class SegmentLineProcess implements LineProcessor {

    private int count = 0;

    StringBuilder currentLine = new StringBuilder();

    List<String> lines = new ArrayList<>();

    @Override
    public boolean processLine(String line) throws IOException {
        System.out.println(line);
        boolean endLine = false;
        if (line.endsWith("\n")) {
            endLine = true;
        }
        List<Term> terms = NotionalTokenizer.segment(line);
        StringBuilder sb = new StringBuilder();
        for (Term term : terms) {
            sb.append(term.word).append(" ");
        }
        currentLine.append(sb.toString());
        if (endLine) {
            lines.add(currentLine.toString());
            currentLine.delete(0, currentLine.length());
        }
        count++;
        return true;
    }

    @Override
    public List<String> getResult() {
        System.out.println("总行数：" + count);
        return lines;
    }

    public static void main(String[] args) {
        System.out.println("adsadasdsa\n".endsWith("\n"));
        System.out.println("adsadasdsa".endsWith("\n"));
    }
}
