package org.gfg.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersistDemo {

    public static void main(String[] args) {
        List<String> data = new ArrayList();
        System.out.println(data);
        System.out.println("Enter data");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        data.add(str);
        System.out.println(data);

    }
}
