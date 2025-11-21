package com.kodilla.exception.test;

public class FlightRunners {
    public static void main(String[] args) {
        Flight flight = new Flight("Warsaw", "Madrid");
        FindFlight findFlight = new FindFlight();

        try {
            if(findFlight.findFlight(flight)) {
                System.out.println("Flight to " + flight.arrivalAirport + " found");
            }else{
                System.out.println("Flight to " + flight.arrivalAirport + " not found");
            }

        } catch (RouteNotFoundException e) {
            System.out.println("Cannot find airport");
        }
    }
}
