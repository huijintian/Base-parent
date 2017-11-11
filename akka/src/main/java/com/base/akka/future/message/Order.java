package com.base.akka.future.message;

/**
 * Created by mengtian on 2017/11/11
 */
public class Order {
    Integer userId;
    Integer orderNo;
    Float amount;
    Integer noIfItems;

    public Order(Integer orderNo, Float amount, Integer noIfItems) {
        this.orderNo = orderNo;
        this.amount = amount;
        this.noIfItems = noIfItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", orderNo=" + orderNo +
                ", amount=" + amount +
                ", noIfItems=" + noIfItems +
                '}';
    }
}
