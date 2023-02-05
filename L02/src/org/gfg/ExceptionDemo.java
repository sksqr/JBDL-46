package org.gfg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println("Starting");
      //   System.out.println(list.get(3));
//        String name = "Hitesh";
//        System.out.println(name.charAt(1));
        System.out.println(readFromFile());
        System.out.println("Done");

        try {
            System.out.println(readFromFile2());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(readFromFile3());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  static int readFromFile()  {
        String connection = "Database connection";
        try {
            FileReader fileReader = new FileReader("/tmp/test22344332");
            System.out.println("Method executed");
            System.out.println(connection+" closed");
            return fileReader.read();
        }
        catch (FileNotFoundException  e) {
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println(e);
        }
        finally {
            System.out.println("Method executed");
            System.out.println(connection+" closed");
        }
        return 0;
    }
    public  static int readFromFile2() throws FileNotFoundException {
            FileReader fileReader = new FileReader("");
        return 0;
    }


    public  static int readFromFile3() throws IOException {
        try {
            FileReader fileReader = new FileReader("");
            return fileReader.read();
        } catch (IOException e) {
            throw new IOException("Error");
        }
    }
}
