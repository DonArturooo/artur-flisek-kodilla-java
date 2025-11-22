package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class Order {

    final int id;
    double price;
    List<Product> products = new ArrayList<>();

    public Order(int id) {
        this.id = id;
    }

    public Order(int id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        for (Product product : products) {
            price += product.getPrice();
        }

        return price;
    }
}
