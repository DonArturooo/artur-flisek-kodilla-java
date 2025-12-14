package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.Map;

public class Producer implements ProducerService {
    Map<Product, Integer> products = new HashMap<>();


    @Override
    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    @Override
    public boolean isPossibleToOrder(Map<Product, Integer> orderProducts) {
        for (Map.Entry<Product, Integer> orderProduct : orderProducts.entrySet()) {
            boolean available = products.get(orderProduct.getKey()) != null && products.get(orderProduct.getKey()) >= orderProduct.getValue();

            if (!available) {
                return false;
            }
        }

        return true;
    }
}
