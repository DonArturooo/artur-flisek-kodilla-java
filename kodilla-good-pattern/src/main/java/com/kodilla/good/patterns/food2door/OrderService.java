package com.kodilla.good.patterns.food2door;

import java.util.List;
import java.util.Map;

public class OrderService {
    public static Producer getProducer(String producerName) {
        return Producer.producers.stream()
                                 .filter(producer -> producer.getProducerName()
                                                             .equals(producerName))
                                 .findFirst()
                                 .orElse(null);
    }

    public static Map<Product, Integer> getListOfProducts(Producer producer) {
        return producer.getAvailableProducts();
    }

    public static Order createOrder(Producer producer, List<Product> products, List<Integer> quantity) throws Exception {
        if (products.size() != quantity.size()) {
            throw new Exception("Listy nie są sobie równe");
        }

        Order order = new Order(producer);

        for (int i = 0; i < products.size(); i++) {
            order.addProduct(products.get(i), quantity.get(i));
        }

        return order;
    }

    public static boolean process(Order order) {
        Map<Product, Integer> listOfAvailableProducts = getListOfProducts(order.getProducer());
        Map<Product, Integer> listOfOrderProducts = order.getProducts();

        for (Map.Entry<Product, Integer> entry : listOfOrderProducts.entrySet()) {
            if (!listOfAvailableProducts.containsKey(entry.getKey())) {
                return false;
            }
            if (listOfAvailableProducts.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }
}
