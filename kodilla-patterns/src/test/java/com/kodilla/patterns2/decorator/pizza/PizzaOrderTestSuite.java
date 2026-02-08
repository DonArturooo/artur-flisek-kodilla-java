package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTestSuite {
    PizzaOrder pizzaOrder;

    @BeforeEach
    void beforeEach() {
        pizzaOrder = new BasicPizza();
    }

    @Test
    void getCost() {
        assertAll(() -> assertEquals(new BigDecimal(15), pizzaOrder.getCost()));
        assertAll(() -> assertEquals(new BigDecimal(15), pizzaOrder.getCost()), () -> {
            pizzaOrder = new HamIngredient(pizzaOrder);
            assertEquals(new BigDecimal(16), pizzaOrder.getCost());
        }, () -> {
            pizzaOrder = new PineappleIngredient(pizzaOrder);
            assertEquals(new BigDecimal(19), pizzaOrder.getCost());
        });
    }

    @Test
    void getDescription() {
        assertAll(() -> assertEquals("Pizza with ingredients: cheese, sauce", pizzaOrder.getDescription()), () -> {
            pizzaOrder = new HamIngredient(pizzaOrder);
            assertEquals("Pizza with ingredients: cheese, sauce, ham", pizzaOrder.getDescription());
        }, () -> {
            pizzaOrder = new PineappleIngredient(pizzaOrder);
            assertEquals("Pizza with ingredients: cheese, sauce, ham, pineapple", pizzaOrder.getDescription());
        });
    }
}
