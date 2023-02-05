package org.gfg;

import java.util.ArrayList;
import java.util.List;

public class InterfaceDemo {

    public static void main(String[] args) {
        //TataCar tataCar = new TataSafari();

        HondaCar hondaCar = new HondaCity();
        Object car = new Object();
        List<Object> carList = new ArrayList<>();
        carList.add(hondaCar);
        carList.add(car);

        // Check Post
        if(hondaCar instanceof  IndianGovtNormForCar){
            System.out.println("Pass");
        }


    }
}
