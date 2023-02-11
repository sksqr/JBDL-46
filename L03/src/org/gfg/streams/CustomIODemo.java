package org.gfg.streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomIODemo {

    public static void main(String[] args) throws IOException {
        writePersonListToFile();
    }


    public static void writePersonListToFile() throws IOException {
        Person p1 = new Person("Rohan",25);
        Person p2 = new Person("Ravi",34);
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        PersonList personList = new PersonList(list);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/tmp/objectfileCustom.txt"));
        objectOutputStream.writeObject(personList);
    }


    public static void readPersonfromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/tmp/objectfile.txt"));
        Person p2 = (Person) objectInputStream.readObject();
        System.out.println(p2);
    }


}
