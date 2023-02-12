package org.gfg.flightdemo;

import java.util.List;

public interface AirlineFlightSearchInterface {
    List<FlightData> getFlightsByScrDst(String src, String dest);
}
