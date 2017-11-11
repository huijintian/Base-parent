package com.base.akka.future.message;

/**
 * Created by mengtian on 2017/11/11
 */
public class OrderHistory {
    Order order;
    Address address;

    public OrderHistory(Order order, Address address) {
        this.order = order;
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "order=" + order +
                ", address=" + address +
                '}';
    }
}
