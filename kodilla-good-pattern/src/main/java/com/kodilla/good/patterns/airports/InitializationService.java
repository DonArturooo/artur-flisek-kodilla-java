package com.kodilla.good.patterns.airports;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface InitializationService {
    List<Airport> airports = new ArrayList<>();
    Random RAND = new Random();

    static void init() {
        createTestAirports();
        createTestFlights();
    }

    private static void createTestAirports() {
        airports.add(new Airport("Warsaw Chopin"));
        airports.add(new Airport("Warsaw Modlin"));
        airports.add(new Airport("Krakow Balice"));
        airports.add(new Airport("Gdansk Lech Walesa"));
        airports.add(new Airport("Katowice Pyrzowice"));
        airports.add(new Airport("Wroclaw Strachowice"));
        airports.add(new Airport("Poznan Lawica"));
        airports.add(new Airport("Rzeszow Jasionka"));
        airports.add(new Airport("Szczecin Goleniow"));
        airports.add(new Airport("Lodz Lublinek"));
        airports.add(new Airport("Bydgoszcz"));
        airports.add(new Airport("Zielona Gora Babimost"));
        airports.add(new Airport("Lublin Swidnik"));
        airports.add(new Airport("Olsztyn Mazury"));
        airports.add(new Airport("Radom Sadkow"));
    }

    private static void createTestFlights() {
        Airport warsaw = airports.getFirst();
        Airport random = airports.get(RAND.nextInt(1, airports.size() - 1));
        Airport radom = airports.getLast();

        for (int i = 0; i < 10; i++) {
            Airport arrival = getRandomAirport();
            Airport departure = getRandomAirport();
            while (true) {
                assert departure != null;
                if (!departure.equals(arrival)) break;
                arrival = getRandomAirport();
            }
            FlightService.registerFlight(departure, arrival);
        }

        if (warsaw.getFlights()
                  .isEmpty()) {
            FlightService.registerFlight(warsaw, getRandomAirport());
        }

        FlightService.registerFlight(warsaw, random);
        FlightService.registerFlight(random, radom);
        FlightService.registerFlight(random, radom);
    }

    private static Airport getRandomAirport() {
        if (airports.isEmpty()) {
            return null;
        }

        return airports.get(RAND.nextInt(0, airports.size()));
    }
}
