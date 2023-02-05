package org.gfg;

import java.util.List;

public class SortingService {
    List<Integer> sortList(List<Integer> list){
        SortingInterface sortingInterface = null;
        if(list.size() <= 10){
            sortingInterface = new BubleSort();
        }
        else{
            sortingInterface = new MergeSort();
        }
        return sortingInterface.sort(list);
    }
}
