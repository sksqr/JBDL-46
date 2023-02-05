package org.gfg;

public abstract class HondaCar implements IndianGovtNormForCar, EnvNormsForCar{
    @Override
    public final String getBrand() {
        return "honda";
    }

//    @Override
//    public String getLocation() {
//        return "";
//    }

    abstract public String cruzeControl();

}
