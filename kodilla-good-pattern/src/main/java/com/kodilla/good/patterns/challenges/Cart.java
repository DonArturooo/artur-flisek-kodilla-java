package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
