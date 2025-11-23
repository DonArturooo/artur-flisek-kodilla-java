package com.kodilla.good.patterns.airports;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Airport {
    private final String name;
    private final Set<Flight> flights = new HashSet<>();

    public Airport(String name) {
        this.name = name;
    }

    public void registerFlight(Flight flight) {
        flights.add(flight);
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
