package org.gfg.streams;

import java.io.*;

public class ObjectIOStreamsDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        writePersonToFile();
        readPersonfromFile();
    }

    public static void writePersonToFile() throws IOException {
        Person p1 = new Person("Rohan",25);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/tmp/objectfile.txt"));
        objectOutputStream.writeObject(p1);
    }


    public static void readPersonfromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/tmp/objectfile.txt"));
        Person p2 = (Person) objectInputStream.readObject();
        System.out.println(p2);
    }



}
