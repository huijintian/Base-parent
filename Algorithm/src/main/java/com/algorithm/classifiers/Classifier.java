package com.algorithm.classifiers;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;

/**
 * Created by mengtian on 2017/11/28
 */
public interface Classifier extends Cloneable, Serializable {

    CategoricalResults classify(DataPoint data);

    void trainC(ClassificationDataSet dataSet, ExecutorService threadPool);

    void trainC(ClassificationDataSet dataSet);

    boolean supportsWeightedData();

    Classifier clone();
}
