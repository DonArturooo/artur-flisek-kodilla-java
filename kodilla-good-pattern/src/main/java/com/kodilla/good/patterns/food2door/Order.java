package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
    static int COUNTER = 0;

    final int id = COUNTER++;
    final Producer producer;
    final Map<Product, Integer> products = new HashMap<>();

    public Order(Producer producer) {
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public Producer getProducer() {
        return producer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id && Objects.equals(producer, order.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, producer);
    }
}
