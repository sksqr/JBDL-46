package org.gfg.flightdemo;

import java.util.ArrayList;
import java.util.List;

public class MmtApiDemo {

    public static void main(String[] args) {

        List<AirlineFlightSearchInterface> list = new ArrayList<>();
        list.add(new IndigoFlightSearchService());
        list.add(new GoAirFlightSearchService());

        MmtSearchService mmtSearchService = new MmtSearchService(list);

        List<FlightData> data = mmtSearchService.getAllFightsBySrcDest("Lucknow","Delhi");

        System.out.println(data);
    }
}
