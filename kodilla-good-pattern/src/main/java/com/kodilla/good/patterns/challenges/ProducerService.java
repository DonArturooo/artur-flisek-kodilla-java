package com.kodilla.good.patterns.challenges;

import java.util.Map;

public interface ProducerService {
    void addProduct(Product product, int quantity);

    boolean isPossibleToOrder(Map<Product, Integer> orderProducts);
}
