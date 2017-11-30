package com.spark.ml;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.tree.RandomForest;
import org.apache.spark.mllib.tree.model.RandomForestModel;
import org.apache.spark.mllib.util.MLUtils;
import scala.Tuple2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengtian on 2017/11/29
 */
public class RandomForestExample {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("randonForestClassifier");
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);
        String dataPath = "/Users/mengtian/Documents/code/stu/Base-parent/spark-ml-learning/src/main/resources/data/sample_libsvm_data.txt";
        JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(jsc.sc(), dataPath).toJavaRDD();
        //按比例切分数据集
        JavaRDD<LabeledPoint>[] splits = data.randomSplit(new double[]{0.7, 0.3});
        JavaRDD<LabeledPoint> trainingData = splits[0];
        JavaRDD<LabeledPoint> testData = splits[1];

        Integer numClasses = 2;
        Map<Integer, Integer> categoricalFeaturesInfo = new HashMap<>();
        Integer numTrees = 5;
        String featureSubsetStrategy = "auto";
        String impurity = "gini";
        Integer maxDepth = 7;
        Integer maxBins = 32;
        Integer seed = 12345;

        System.out.println("training data:" + trainingData.toString());

        for (LabeledPoint labeledPoint : trainingData.collect()) {
            System.out.println(labeledPoint);
        }

        RandomForestModel model = RandomForest.trainClassifier(trainingData, numClasses,
                categoricalFeaturesInfo, numTrees, featureSubsetStrategy,
                impurity, maxDepth, maxBins, seed);

        JavaPairRDD<Double, Double> predictionAndLabel = testData.mapToPair(
                p -> new Tuple2<>(model.predict(p.features()), p.label()));

        double testErr = predictionAndLabel.filter(p1 -> p1._1().equals(p1._2())).count() / (double) testData.count();

        System.out.println("test error :" + testErr);
        System.out.println("learned classification forest model:\n" + model.toDebugString());

    }
}
