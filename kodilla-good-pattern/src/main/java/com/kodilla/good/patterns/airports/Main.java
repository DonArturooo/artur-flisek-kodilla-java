package com.kodilla.good.patterns.airports;

public class Main {
    public static void main(String[] args) {
        InitializationService.init();

        FlightService flightService = new FlightService();

        Airport warsaw = InitializationService.airports.getFirst();
        Airport radom = InitializationService.airports.getLast();

        flightService.getAllDepartures(warsaw);
        flightService.getAllArrivals(warsaw);
        flightService.findConnection(warsaw, radom);
    }
}
