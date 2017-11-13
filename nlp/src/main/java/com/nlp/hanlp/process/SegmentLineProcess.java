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

    List<String> lines = new ArrayList<>();

    @Override
    public boolean processLine(String line) throws IOException {
        List<Term> terms = NotionalTokenizer.segment(line);
        StringBuilder sb = new StringBuilder();
        for (Term term : terms) {
            sb.append(term.word).append(" ");
        }
        lines.add(sb.toString());
        return true;
    }

    @Override
    public List<String> getResult() {
        return lines;
    }
}
