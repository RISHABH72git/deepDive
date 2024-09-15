package com.example.deepDive.algoMonster;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SortingBasic {

    public static void main(String[] args) {
        List<Integer> unsortedList = Arrays.asList(4, 7, 1, 3, 9, 2);
        List<Integer> sorted = insertionSort(unsortedList);
        System.out.println(sorted);
    }

    private static List<Integer> insertionSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int current = i;
            while (current > 0 && list.get(current) < list.get(current - 1)) {
                int temp = list.get(current);
                list.set(current, list.get(current - 1));
                list.set(current - 1, temp);
                current--;
            }
        }
        return list;
    }

}
