package com.base.akka.future.message;

/**
 * Created by mengtian on 2017/11/11
 */
public class Address {
    Integer userId;
    String fullName;
    String address1;
    String address2;

    public Address(Integer userId, String fullName, String address1, String address2) {
        this.userId = userId;
        this.fullName = fullName;
        this.address1 = address1;
        this.address2 = address2;
    }

    @Override
    public String toString() {
        return "Address{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                '}';
    }
}
