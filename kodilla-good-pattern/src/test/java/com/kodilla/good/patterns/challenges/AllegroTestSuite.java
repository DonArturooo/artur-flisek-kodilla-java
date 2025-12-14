package com.kodilla.good.patterns.challenges;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AllegroTestSuite {

    static Adidas adidas = new Adidas();
    static XKOM xkom = new XKOM();

    static Product boots = new Product("Nike One", 500);
    static Product phone = new Product("Samsung Galaxy S24", 3999);
    static Product laptop = new Product("Dell XPS 15", 8500);
    static Product headphones = new Product("Sony WH-1000XM5", 1699);
    static Product tv = new Product("LG OLED C3", 7499);
    static Product watch = new Product("Apple Watch Series 9", 2199);
    static Product keyboard = new Product("Logitech MX Keys", 599);
    static Product mouse = new Product("Razer DeathAdder V3", 329);
    static Product backpack = new Product("Herschel Little America", 399);
    static Product chair = new Product("DXRacer Formula", 1299);

    @BeforeAll
    static void beforeAll(){
        adidas.addProduct(boots, 60);
        adidas.addProduct(backpack, 30);
        adidas.addProduct(watch, 15);

        xkom.addProduct(headphones, 30);
        xkom.addProduct(tv, 2);
        xkom.addProduct(mouse, 100);
    }


    @Test
    void orderIsPossibleToRealizeInAdidas() {
        Cart cart = new Cart();

        cart.addProduct(boots, 2);
        cart.addProduct(backpack, 1);

        Order order = adidas.orderProducts(cart.getProducts());

        assertAll(
                () -> assertEquals(2, cart.getProducts().size()),
                () -> assertNotNull(order),
                () -> assertEquals(1399, order.getTotalPrice())
        );
    }

    @Test
    void orderIsNotPossibleToRealize() {

        Cart cart = new Cart();

        cart.addProduct(boots, 2);
        cart.addProduct(backpack, 1);
        cart.addProduct(laptop, 15);

        Order order = adidas.orderProducts(cart.getProducts());

        assertAll(
                () -> assertEquals(3, cart.getProducts().size()),
                () -> assertNull(order)
        );
    }

    @Test
    void orderIsPossibleToRealizeInXkom() {
        Cart cart = new Cart();

        cart.addProduct(tv, 1);

        Order order = xkom.orderProducts(cart.getProducts());

        assertAll(
                () -> assertEquals(1, cart.getProducts().size()),
                () -> assertNotNull(order),
                () -> assertEquals(7499, order.getTotalPrice())
        );
    }
}
