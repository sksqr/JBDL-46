package org.gfg.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class InputOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        //writeDataTofile();
        readDatafromfile();
    }

    public static void writeDataTofile() throws IOException {
        String data ="Hello शशिकांत";
        FileOutputStream fileOutputStream = new FileOutputStream("/tmp/textData46.txt");
        fileOutputStream.write(data.getBytes());
        fileOutputStream.close();
    }

    public  static void readDatafromfile()  {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("/tmp/textData46.txt");

            Scanner scanner = new Scanner(fileInputStream);
            String readData = scanner.nextLine();
            System.out.println(readData);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
