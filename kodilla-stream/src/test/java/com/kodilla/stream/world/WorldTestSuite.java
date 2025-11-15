package com.kodilla.stream.world;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        // --- Europa ---
        List<Country> europeCountries = new ArrayList<>();
        europeCountries.add(new Country("Germany", new BigDecimal(83500000)));
        europeCountries.add(new Country("Poland", new BigDecimal(37380000)));
        europeCountries.add(new Country("France", new BigDecimal(65200000)));
        europeCountries.add(new Country("Spain", new BigDecimal(47500000)));
        europeCountries.add(new Country("Italy", new BigDecimal(59000000)));

        // --- Afryka ---
        List<Country> africaCountries = new ArrayList<>();
        africaCountries.add(new Country("Nigeria", new BigDecimal(223800000)));
        africaCountries.add(new Country("Ethiopia", new BigDecimal(126500000)));
        africaCountries.add(new Country("Egypt", new BigDecimal(112700000)));
        africaCountries.add(new Country("South Africa", new BigDecimal(60600000)));
        africaCountries.add(new Country("Kenya", new BigDecimal(54000000)));

        // --- Azja ---
        List<Country> asiaCountries = new ArrayList<>();
        asiaCountries.add(new Country("China", new BigDecimal(1412000000)));
        asiaCountries.add(new Country("India", new BigDecimal(1408000000)));
        asiaCountries.add(new Country("Japan", new BigDecimal(123200000)));
        asiaCountries.add(new Country("South Korea", new BigDecimal(51780000)));
        asiaCountries.add(new Country("Indonesia", new BigDecimal(277500000)));

        List<Continent> continents = new ArrayList<>();
        continents.add(new Continent("Europe", europeCountries));
        continents.add(new Continent("Africa", africaCountries));
        continents.add(new Continent("Asia", asiaCountries));

        World world = new World(continents);


        assertEquals(new BigDecimal("4142660000"), world.getPeopleQuantity());
    }
}
