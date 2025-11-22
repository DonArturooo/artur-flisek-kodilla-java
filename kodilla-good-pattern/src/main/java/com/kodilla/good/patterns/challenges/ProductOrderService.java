package com.kodilla.good.patterns.challenges;

import java.util.List;

public class ProductOrderService {
    static int lastOrderId = 1;

    public Order orderProducts(List<Product> products){
        Order order = new Order(lastOrderId, products);

        lastOrderId++;

        return order;
    }
}
