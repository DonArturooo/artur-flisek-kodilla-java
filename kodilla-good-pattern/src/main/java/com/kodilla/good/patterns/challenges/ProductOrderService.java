package com.kodilla.good.patterns.challenges;

import java.util.Map;

public interface ProductOrderService {
    Order orderProducts(Map<Product, Integer> products);
}
