package org.gfg.flightdemo;

import java.util.ArrayList;
import java.util.List;

public class IndigoFlightSearchService implements AirlineFlightSearchInterface{
    @Override
    public List<FlightData> getFlightsByScrDst(String src, String dest) {
        //

        List<FlightData> list = new ArrayList<>();
        list.add(new FlightData("Lucknow","Delhi",7000.00));
        list.add(new FlightData("Lucknow","Delhi",6000.00));
        return list;
    }
}
