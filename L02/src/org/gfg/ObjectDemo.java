package org.gfg;

public class ObjectDemo {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Shashi");

        Person person1 = new Person();
        person1.setName("Shashi");

//      Object

        System.out.println(Integer.toHexString(person.hashCode()));
        System.out.println(person);

        System.out.println(Integer.toHexString(person1.hashCode()));
        System.out.println(person1);

        System.out.println(person.equals(person1));

        System.out.println(person == person1);


    }
}
