package com.example.deepDive.algoMonster;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SortingBasic {

    public static void main(String[] args) {
        List<Integer> unsortedList = Arrays.asList(4, 7, 1, 3, 9, 2);
        List<Integer> insertionSorted = insertionSort(unsortedList);
        List<Integer> selectionSorted = selectionSort(unsortedList);
        System.out.println(selectionSorted);
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

    private static List<Integer> selectionSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
        return list;
    }

}
