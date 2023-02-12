package org.gfg.flightdemo;

import java.util.ArrayList;
import java.util.List;

public class GoAirFlightSearchService implements AirlineFlightSearchInterface{
    @Override
    public List<FlightData> getFlightsByScrDst(String src, String dest) {
        //
        List<FlightData> list = new ArrayList<>();
        list.add(new FlightData("Lucknow","Delhi",10000.00));
        list.add(new FlightData("Lucknow","Delhi",9000.00));
        return list;
    }
}
