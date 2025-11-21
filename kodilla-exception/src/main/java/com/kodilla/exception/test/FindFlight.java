package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FindFlight {

    Map<String, Boolean> flightsMap = new HashMap<>();

    public FindFlight() {
        flightsMap.put("Amsterdam", true);
        flightsMap.put("Berlin", true);
        flightsMap.put("Paris", false);
        flightsMap.put("Rome", true);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        if(flightsMap.containsKey(flight.arrivalAirport)){
            return flightsMap.get(flight.arrivalAirport);
        } else {
            throw new RouteNotFoundException();
        }
    }


}
