package org.gfg.flightdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MmtSearchService {
    private List<AirlineFlightSearchInterface> airlineFlightSearchInterfaceList;

    private ExecutorService executorService;

    public MmtSearchService(List<AirlineFlightSearchInterface> airlineFlightSearchInterfaceList) {
        this.airlineFlightSearchInterfaceList = airlineFlightSearchInterfaceList;
        this.executorService = Executors.newFixedThreadPool(airlineFlightSearchInterfaceList.size());
    }

    public List<FlightData> getAllFightsBySrcDest(String src, String dest){

        List<Callable<List<FlightData>>> callableList = new ArrayList<>();
        for (AirlineFlightSearchInterface impl : airlineFlightSearchInterfaceList){
            callableList.add(new Callable<List<FlightData>>() {
                @Override
                public List<FlightData> call() throws Exception {
                    return impl.getFlightsByScrDst(src,dest);
                }
            });
        }
        List<Future<List<FlightData>>> futureList = new ArrayList<>();
        for (Callable<List<FlightData>> callable : callableList){
            Future<List<FlightData>> flightDataFuture=  executorService.submit(callable);
            futureList.add(flightDataFuture);
        }
        List<FlightData> result = new ArrayList<>();
        for(Future<List<FlightData>> data : futureList){
            try {
                result.addAll(data.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return result;

    }
}
