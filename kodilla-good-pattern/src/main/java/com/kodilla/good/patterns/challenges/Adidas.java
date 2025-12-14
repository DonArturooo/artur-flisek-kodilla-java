package com.kodilla.good.patterns.challenges;

import java.math.BigInteger;
import java.util.Map;


public class Adidas extends Producer implements ProducerService, ProductOrderService {
    static BigInteger lastOrderId = BigInteger.ZERO;

    @Override
    public Order orderProducts(Map<Product, Integer> orderProducts) {
        boolean available = isPossibleToOrder(orderProducts);

        if (!available) {
            NotificationService.notify("Zamówienie nie może zostać zrealizowane");
            return null;
        }

        lastOrderId = lastOrderId.add(BigInteger.ONE);
        return new Order(lastOrderId, orderProducts);
    }
}
