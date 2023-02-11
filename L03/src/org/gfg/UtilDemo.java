package org.gfg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilDemo {
    public static void main(String[] args) {
        Integer[] array = new Integer[5];
        array[0]=10;
        array[1]=1;
        array[2]=20;
        array[3]=6;
        array[4]=10;

//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
