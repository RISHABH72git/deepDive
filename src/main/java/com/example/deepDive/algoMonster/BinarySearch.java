package com.example.deepDive.algoMonster;

import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.vanillaBinarySearch(List.of(1, 3, 6, 8, 9, 10), 8));
        System.out.println(binarySearch.vanillaBinarySearch(List.of(1, 3, 6, 8, 9, 10), 11));
    }

    private int vanillaBinarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == target) {
                return mid;
            }
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
