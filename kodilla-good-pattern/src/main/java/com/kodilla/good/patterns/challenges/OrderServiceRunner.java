package com.kodilla.good.patterns.challenges;

public class OrderServiceRunner {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Product boots = new Product("Nike One", 500);
        Product phone = new Product("Samsung Galaxy S24", 3999);
        Product laptop = new Product("Dell XPS 15", 8500);
        Product headphones = new Product("Sony WH-1000XM5", 1699);
        Product tv = new Product("LG OLED C3", 7499);
        Product watch = new Product("Apple Watch Series 9", 2199);
        Product keyboard = new Product("Logitech MX Keys", 599);
        Product mouse = new Product("Razer DeathAdder V3", 329);
        Product backpack = new Product("Herschel Little America", 399);
        Product chair = new Product("DXRacer Formula", 1299);

        cart.addProduct(boots, 1);
        cart.addProduct(phone, 2);
        cart.addProduct(headphones, 3);
        cart.addProduct(mouse, 5);

        Order order = new Adidas().orderProducts(cart.getProducts());

        System.out.println(order.getTotalPrice());
    }
}
