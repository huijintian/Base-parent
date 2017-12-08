package com.spark.ml.classify.svm;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.classification.SVMModel;
import org.apache.spark.mllib.classification.SVMWithSGD;
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.util.MLUtils;
import scala.Tuple2;

/**
 * Created by mengtian on 2017/12/7
 */
public class SVMWithSGDExample {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("SVMExample");
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);

        String path = "/Users/mengtian/Documents/code/stu/Base-parent/spark-ml-learning/src/main/resources/data/sample_libsvm_data.txt";
        JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(jsc.sc(), path).toJavaRDD();

        //将训练集切分为两部分 60%为训练集，40%为测试集
        //训练集
        JavaRDD<LabeledPoint> training = data.sample(false, 0.6, 11l);
        training.cache();
        //测试集
        JavaRDD<LabeledPoint> test = data.subtract(training);


        int numIterations = 100;
        SVMModel model = SVMWithSGD.train(training.rdd(), numIterations);
        //清除阀值
        model.clearThreshold();

        JavaRDD<Tuple2<Object, Object>> scoreAndLabels = test.map(p -> new Tuple2<>(model.predict(p.features()), p.label()));

        BinaryClassificationMetrics metrics = new BinaryClassificationMetrics(JavaRDD.toRDD(scoreAndLabels));

        double auRoc = metrics.areaUnderROC();

        System.out.println("area unrea roc = " + auRoc);



    }
}
