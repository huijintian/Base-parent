package com.base.akka.calculator;

import akka.japi.Option;
import scala.concurrent.Future;


/**
 * Created by mengtian on 2017/11/11
 */
public interface CalculatorInt {
    scala.concurrent.Future<Integer> add(Integer first, Integer second);

    Future<Integer> subtract(Integer first, Integer second);

    void incrementCount();

    Option<Integer> incrementAndReturn();
}
