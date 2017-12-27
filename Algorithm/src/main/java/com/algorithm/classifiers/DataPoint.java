package com.algorithm.classifiers;

import java.io.Serializable;

/**
 * Created by mengtian on 2017/11/28
 */
public class DataPoint implements Cloneable, Serializable {

    private double weight;
    protected Vec numericalValues;
    protected int[] categoricalValues;
    protected CategoricalData[] categoricalData;
    private static final int[] emptyInt = new int[0];
    private static final CategoricalData[] emptyData = new CategoricalData[0];

    public DataPoint(Vec numericalValues, int[] categoricalValues, CategoricalData[] categoricalData) {
        this(numericalValues, categoricalValues, categoricalData, 1);
    }

    public DataPoint(Vec numericalValues, int[] categoricalValues, CategoricalData[] categoricalData, double weight) {
        this.weight = weight;
        this.numericalValues = numericalValues;
        this.categoricalValues = categoricalValues;
        this.categoricalData = categoricalData;
    }

    public DataPoint(Vec numericalValues, double weight) {
        this(numericalValues, emptyInt, emptyData, weight);
    }

    public DataPoint(Vec numericalValues) {
        this(numericalValues, emptyInt, emptyData);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (Double.isNaN(weight) || Double.isInfinite(weight) || weight <= 0)
            throw new ArithmeticException("Invalid weight assignment of " + weight);
        this.weight = weight;
    }


}
