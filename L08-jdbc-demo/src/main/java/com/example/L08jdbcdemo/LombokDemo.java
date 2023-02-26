package com.example.L08jdbcdemo;

public class LombokDemo {

    public static void main(String[] args) {
        Person person = new Person(1,"Ravi");
        Person person1 = new Person();

        person.setName("Ravi");
        System.out.println(person.getName());
    }
}
