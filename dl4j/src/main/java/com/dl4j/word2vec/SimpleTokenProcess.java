package com.dl4j.word2vec;

import org.apache.commons.lang.StringUtils;
import org.deeplearning4j.text.tokenization.tokenizer.TokenPreProcess;

/**
 * Created by mengtian on 2017/11/14
 */
public class SimpleTokenProcess implements TokenPreProcess {
    @Override
    public String preProcess(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return token;
    }
}
