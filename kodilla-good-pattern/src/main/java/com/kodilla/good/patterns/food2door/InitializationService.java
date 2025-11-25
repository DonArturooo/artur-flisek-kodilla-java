package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitializationService {
    static List<Producer> producers = new ArrayList<>();
    static List<Product> products = new ArrayList<>();

    public static void init(){
        //Producenci
        Producer extraFoodShop = new Producer("ExtraFoodShop");
        Producer healthyShop = new Producer("HealthyShop");
        Producer glutenFreeShop = new Producer("GlutenFreeShop");

        producers.add(extraFoodShop);
        producers.add(healthyShop);
        producers.add(glutenFreeShop);

        //Produkty
        Product rzepa = new Product("Rzepa", 15);
        Product marchew = new Product("Marchew", 10);
        Product pietruszka = new Product("Pietruszka", 12);
        Product seler = new Product("Seler", 14);
        Product ogorek = new Product("Ogórek", 18);
        Product pomidor = new Product("Pomidor", 22);
        Product papryka = new Product("Papryka", 25);
        Product jablko = new Product("Jabłko", 9);
        Product gruszka = new Product("Gruszka", 11);
        Product salata = new Product("Sałata", 7);
        Product rzodkiewka = new Product("Rzodkiewka", 8);
        Product burak = new Product("Burak", 13);
        Product kapusta = new Product("Kapusta", 16);
        Product brokul = new Product("Brokuł", 23);
        Product kalafior = new Product("Kalafior", 21);

        products.add(rzepa);
        products.add(marchew);
        products.add(pietruszka);
        products.add(seler);
        products.add(ogorek);
        products.add(pomidor);
        products.add(papryka);
        products.add(jablko);
        products.add(gruszka);
        products.add(salata);
        products.add(rzodkiewka);
        products.add(burak);
        products.add(kapusta);
        products.add(brokul);
        products.add(kalafior);

        //Dodanie listy dostępnych produktów u producentów
        for (Producer producer : producers) {
            Random random = new Random();

            for (int j = 0; j < 5; j++) {
                producer.addProduct(products.get(random.nextInt(0, products.size())), random.nextInt(0, 100));
            }
        }
    }

    public static Order makePossibleOrder(){
        Producer test = new Producer("Test");

        test.addProduct(products.get(0), 100);
        test.addProduct(products.get(1), 100);
        test.addProduct(products.get(2), 100);

        Order order = new Order(test);
        order.addProduct(products.get(0), 10);

        return order;
    }
}
