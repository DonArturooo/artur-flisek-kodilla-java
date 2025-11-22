package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
