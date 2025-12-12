package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private final List<String> ingredients = new ArrayList<>();

        public BigmacBuilder selectBurgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder selectSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder addIngredient(String ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public BigmacBuilder selectBun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public Bigmac build() throws IllegalArgumentException {
            if (this.bun == null || this.sauce == null || this.ingredients.isEmpty() || this.burgers < 0) {
                throw new IllegalArgumentException("Nie są zdefiniowane wszystkie składniki burgera");
            }
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    private Bigmac(Bun bun, int burgers, Sauce sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
