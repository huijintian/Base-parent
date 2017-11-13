package com.dl4j.word2vec;

import org.datavec.api.util.ClassPathResource;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

import java.io.FileNotFoundException;
import java.util.Collection;

/**
 * Created by mengtian on 2017/11/13
 */
public class NovelWord2Vec {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = new ClassPathResource("sanguo.txt").getFile().getAbsolutePath();
        SentenceIterator iterator = new BasicLineIterator(filePath);
        TokenizerFactory factory = new DefaultTokenizerFactory();

        factory.setTokenPreProcessor(new SimpleTokenProcess());

        Word2Vec vec = new Word2Vec.Builder()
                .minWordFrequency(5)
                .iterations(3)
                .learningRate(0.01)
                .layerSize(250)
                .seed(42)
                .windowSize(5)
                .iterate(iterator)
                .tokenizerFactory(factory)
                .build();

        vec.fit();

        System.out.println(vec.similarity("诸葛亮", "孔明"));
        System.out.println(vec.similarity("赵云", "子龙"));
        Collection<String> res = vec.wordsNearest("刘备", 3);
        System.out.println(res);
    }
}
