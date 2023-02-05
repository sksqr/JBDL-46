package org.gfg;

import sun.awt.X11.XSystemTrayPeer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbstractionDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(5);
        Collections.sort(list);
        System.out.println(list);

        /*
         size < 10 bubleSort
         else merge
         */

        SortingService sortingService = new SortingService();
        sortingService.sortList(list);
    }
}
