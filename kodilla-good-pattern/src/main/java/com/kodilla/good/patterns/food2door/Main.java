package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InitializationService.init();

        Producer extraFoodShop = OrderService.getProducer("ExtraFoodShop");
        List<Product> products = new ArrayList<>();
        List<Integer> quantity = new ArrayList<>();

        products.add(InitializationService.products.get(0));
        products.add(InitializationService.products.get(1));
        products.add(InitializationService.products.get(2));

        quantity.add(12);
        quantity.add(33);
        quantity.add(11);

        try {
            Order order = OrderService.createOrder(extraFoodShop, products, quantity);
            System.out.println(OrderService.process(order));

            System.out.println(OrderService.process(InitializationService.makePossibleOrder()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
