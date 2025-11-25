package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Producer {
    final static Set<Producer> producers = new HashSet<>();

    final String producerName;
    final Map<Product, Integer> availableProducts = new HashMap<>();

    public Producer(String producerName) {
        this.producerName = producerName;
        producers.add(this);
    }

    public void addProduct(Product product, int quantity) {
        availableProducts.put(product, quantity);
    }

    public String getProducerName() {
        return producerName;
    }

    public Map<Product, Integer> getAvailableProducts() {
        return availableProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Producer producer = (Producer) o;
        return Objects.equals(producerName, producer.producerName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(producerName);
    }
}
