package org.gfg;

import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {

    public static void main(String[] args) {
        Integer intArray[] = new Integer[3];
        intArray[0]= 11;
        intArray[1]= 1;
        intArray[2]= 13;
        System.out.println(intArray[2]);
        Integer temp[] = new Integer[4];
        for(int i=0; i<intArray.length; i++){
            temp[i] = intArray[i];
        }
        intArray = temp;
        intArray[3] = 14;
        System.out.println(intArray[3]);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);



    }
}
