package org.gfg;

public interface IndianGovtNormForCar {
     String getRC();

     String getInsurance();

//    default String getPUC(){
//        return "IndianGovtNormForCar PUC";
//    }

    public String getBrand();

//    public String getLocation();


    default String getLocation(){
        return "";
    }


}
