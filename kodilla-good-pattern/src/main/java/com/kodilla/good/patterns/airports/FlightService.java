package com.kodilla.good.patterns.airports;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightService {
    static HashSet<Flight> flights = new HashSet<>();

    private Flight findFlight(Airport departure, Airport arrival) {
        Optional<Flight> possibleFlight = departure.getFlights()
                                                   .stream()
                                                   .filter(f -> f.getArrival()
                                                                 .equals(arrival))
                                                   .findAny();

        return possibleFlight.orElseGet(() -> departure.getFlights()
                                                       .stream()
                                                       .flatMap(flight -> flight.getArrival()
                                                                                .getFlights()
                                                                                .stream())
                                                       .filter(flight -> flight.getArrival()
                                                                               .equals(arrival))
                                                       .findAny()
                                                       .orElse(null));
    }

    public void findConnection(Airport departure, Airport arrival) {
        Flight flight = findFlight(departure, arrival);
        if (flight.getDeparture()
                  .equals(departure) && flight.getArrival()
                                              .equals(arrival)) {
            System.out.println("Znaleziono bezpośrednie połączenie");
        } else {
            System.out.println("Znaleziono połączenie przez lot do " + flight.getDeparture()
                                                                             .getName());
        }

    }

    static void registerFlight(Airport departure, Airport arrival) {
        Flight flight = new Flight(departure, arrival);
        departure.registerFlight(flight);
        flights.add(flight);
    }

    public void getAllArrivals(Airport arrival) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(flights.stream()
                                    .filter(flight -> flight.getArrival()
                                                            .equals(arrival))
                                    .map(flight -> flight.getDeparture()
                                                         .getName())
                                    .collect(Collectors.joining(", ")));

        if (stringBuilder.toString()
                         .isEmpty()) {
            System.out.println("Nie znaleziono żadnych lotów do tego lotniska");

        } else {
            System.out.println("Loty do tego lotniska to: " + stringBuilder);
        }
    }

    public void getAllDepartures(Airport departure) {
        if (departure.getFlights()
                     .isEmpty()) {
            System.out.println("Nie znaleziono żadnych lotów z tego lotniska");
        } else {
            System.out.println("Loty z lotniska to:" + departure.getFlights()
                                                                .stream()
                                                                .map(flight -> flight.getArrival()
                                                                                     .getName())
                                                                .collect(Collectors.joining(", ")));
        }
    }
}
