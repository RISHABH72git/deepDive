package com.example.deepDive.algoMonster;

import java.util.ArrayList;
import java.util.List;

public class TwoPointers {
    public static int removeDuplicates(List<Integer> arr) {
        int pointer = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).equals(arr.get(pointer))) {
                pointer++;
                arr.set(pointer, arr.get(i));
            }
        }
        return pointer + 1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        System.out.println(removeDuplicates(list));
    }
}