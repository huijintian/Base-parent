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
        String filePath = new ClassPathResource("三国演义白话文.txt").getFile().getAbsolutePath();
        SentenceIterator iterator = new BasicLineIterator(filePath);
        TokenizerFactory tokenizerFactory = new DefaultTokenizerFactory();

        tokenizerFactory.setTokenPreProcessor(new SimpleTokenProcess());

        Word2Vec vec = new Word2Vec.Builder()
                //minWordFrequency是一个词在语料中必须出现的最少次数。
                // 本例中出现不到五次的词都不予学习。词语必须在多种上下文中出现，
                // 才能让模型学习到有用的特征。对于规模很大的语料库，理应提高出现次数的下限。
                .minWordFrequency(8)
                //iterations是网络在处理一批数据时允许更新系数的次数。迭代次数太少，网络可能来不及学习所有能学到的信息；迭代次数太多则会导致网络定型时间变长。
                .iterations(3)
                //learningRate是每一次更新系数并调整词在特征空间中的位置时的步幅。
                //.learningRate(0.01)
                //minLearningRate是学习速率的下限。学习速率会随着定型词数的减少而衰减。
                // 如果学习速率下降过多，网络学习将会缺乏效率。这会使系数不断变化。
                .minLearningRate(0.01)
                //layerSize指定词向量中的特征数量，与特征空间的维度数量相等。以500个特征值表示的词会成为一个500维空间中的点。
                .layerSize(100)
                .seed(42)
                .windowSize(5)
                //iterate告知网络当前定型的是哪一批数据集。
                .iterate(iterator)
                //tokenizer将当前一批的词输入网络。
                .tokenizerFactory(tokenizerFactory)
                .build();
        //vec.fit()让已配置好的网络开始定型。
        vec.fit();

        System.out.println(vec.similarity("诸葛亮", "孔明"));
        System.out.println(vec.similarity("赵名云", "子龙"));
        Collection<String> res = vec.wordsNearest("刘备", 3);
        System.out.println(res);
    }
}
