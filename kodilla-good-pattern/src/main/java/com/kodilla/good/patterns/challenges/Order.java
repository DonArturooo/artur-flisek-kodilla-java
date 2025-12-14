package com.kodilla.good.patterns.challenges;

import java.math.BigInteger;
import java.util.Map;

public class Order {

    final BigInteger id;
    double price;
    Map<Product, Integer> products;

    public Order(BigInteger id, Map<Product, Integer> products) {
        this.id = id;
        this.products = products;
    }

    public double getTotalPrice() {
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            price += product.getKey()
                            .getPrice() * product.getValue();
        }

        return price;
    }
}
