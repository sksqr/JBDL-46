package com.gfg;

public class EncapsulationDemo {

    public static void main(String[] args) {
        Lecture let1 = new Lecture("Lec-01","shashi","live");
        System.out.println(let1.getMentor());

        let1.setMentor("Ravi");
        System.out.println(let1.getMentor());

        System.out.println(let1.getCreated());

        Lecture let2 = new Lecture();


        System.out.println(let2.getCreated());

    }
}
