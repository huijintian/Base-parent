package com.spark.ml.classify.dt;

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
public class RandomForestRegreesionExample {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("randomForestRegress");
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);
        String dataPath = "/Users/mengtian/Documents/code/stu/Base-parent/spark-ml-learning/src/main/resources/data/sample_libsvm_data.txt";

        JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(jsc.sc(), dataPath).toJavaRDD();
        JavaRDD<LabeledPoint>[] splits = data.randomSplit(new double[]{0.7, 0.3});
        JavaRDD<LabeledPoint> trainingData = splits[0];
        JavaRDD<LabeledPoint> testData = splits[1];

        Map<Integer, Integer> categoricalFeaturesInfo = new HashMap<>();
        int numTrees = 3;
        String featureSubsetStrategy = "auto";
        String impurity = "variance";
        int maxDepth = 3;
        int maxBins = 32;
        int seed = 12345;

        for (LabeledPoint labeledPoint : trainingData.collect()) {
            System.out.println(labeledPoint);
        }

        RandomForestModel model = RandomForest.trainRegressor(trainingData, categoricalFeaturesInfo, numTrees,
                featureSubsetStrategy, impurity, maxDepth, maxBins, seed);

        JavaPairRDD<Double, Double> predictionAndLabel = testData.mapToPair(
                p -> new Tuple2<>(model.predict(p.features()), p.label()));

        double testMSE = predictionAndLabel.mapToDouble(p1 -> {
            double diff = p1._1() - p1._2();
            return diff * diff;
        }).mean();

        System.out.println("test mean squared error:" + testMSE);
        System.out.println("learned regression forest model:\n" + model.toDebugString());

    }
}
