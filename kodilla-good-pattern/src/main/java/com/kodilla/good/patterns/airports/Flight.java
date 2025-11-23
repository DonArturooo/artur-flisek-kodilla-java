package com.kodilla.good.patterns.airports;

import java.util.Objects;

public class Flight {
    private final Airport arrival, departure;

    public Flight(Airport departure, Airport arrival) {
        this.arrival = arrival;
        this.departure = departure;
    }
    public Airport getArrival() {
        return arrival;
    }
    public Airport getDeparture() {
        return departure;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Flight flight = (Flight) o;
        return Objects.equals(arrival, flight.arrival) && Objects.equals(departure, flight.departure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrival, departure);
    }
}
