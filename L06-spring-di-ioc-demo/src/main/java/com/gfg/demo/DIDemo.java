package com.gfg.demo;

public class DIDemo {
    public static void main(String[] args) {

        Car car1 = new Car();
        car1.runCar();
        System.out.println(car1);


        Engine engine1 = new Engine("Mega power",1500);
        Car car2 = new Car();
        car2.setEngine(engine1);
        car2.runCar();
        System.out.println(car2);

        Car car3 = new Car("Nexon", engine1);
        car3.runCar();

    }
}
