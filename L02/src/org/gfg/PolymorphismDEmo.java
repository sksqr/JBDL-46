package org.gfg;

import java.util.Scanner;

public class PolymorphismDEmo {

    public static void main(String[] args) {

        //static
        AreaCAlculator areaCAlculator = new AreaCAlculator();
        System.out.println(areaCAlculator.area(2.2));
        System.out.println(areaCAlculator.area(2.0,1.0));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter object name");
        String input = scanner.next();
        Person person = null;
        if(input.equals("S")){
            person = new Student();
            person.setName("Rahul");
        }
        else{
            person = new Teacher("Ravi",23);
        }
        person.walk();

    }
}
