package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {
    @Test
    public void testBigmac() {
        Bigmac bigmac = new Bigmac.BigmacBuilder().selectBun(Bun.WITHOUT_SESAME)
                                                  .selectSauce(Sauce.BBQ)
                                                  .selectBurgers(3)
                                                  .addIngredient("sałata")
                                                  .build();

        assertAll(
                () -> assertEquals(Bun.WITHOUT_SESAME, bigmac.getBun()),
                () -> assertEquals(Sauce.BBQ, bigmac.getSauce()),
                () -> assertEquals(3, bigmac.getBurgers()),
                () -> assertEquals(1, bigmac.getIngredients().size()),
                () -> assertEquals("sałata", bigmac.getIngredients().getFirst())
        );
    }

    @Test
    public void testBigmacErrors() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Bigmac.BigmacBuilder().build(), "Nie są zdefiniowane wszystkie składniki burgera"),
                () -> assertThrows(IllegalArgumentException.class, () -> new Bigmac.BigmacBuilder().selectBun(Bun.WITH_SESAME).build(), "Nie są zdefiniowane wszystkie składniki burgera"),
                () -> assertThrows(IllegalArgumentException.class, () -> new Bigmac.BigmacBuilder().selectBun(Bun.WITH_SESAME).selectSauce(Sauce.STANDARD).build(), "Nie są zdefiniowane wszystkie składniki burgera"),
                () -> assertDoesNotThrow(() -> new Bigmac.BigmacBuilder().selectBun(Bun.WITH_SESAME).selectSauce(Sauce.STANDARD).addIngredient("pomidor").build()),
                () -> assertThrows(IllegalArgumentException.class, () -> new Bigmac.BigmacBuilder().selectBun(Bun.WITH_SESAME).selectSauce(Sauce.STANDARD).addIngredient("pomidor").selectBurgers(-1).build(), "Nie są zdefiniowane wszystkie składniki burgera"),
                () -> assertDoesNotThrow(() -> new Bigmac.BigmacBuilder().selectBun(Bun.WITH_SESAME).selectSauce(Sauce.STANDARD).addIngredient("pomidor").selectBurgers(1).build())
        );
    }
}
