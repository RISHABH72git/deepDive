package com.example.deepDive.algoMonster;

import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        //System.out.println(binarySearch.vanillaBinarySearch(List.of(1, 3, 6, 8, 9, 10), 8));
        //System.out.println(binarySearch.vanillaBinarySearch(List.of(1, 3, 6, 8, 9, 10), 11));
        System.out.println(binarySearch.firstTrueInSortedArray(List.of(false, false, false, false, true, true)));
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

    private int firstTrueInSortedArray(List<Boolean> sorted) {
        int left = 0;
        int right = sorted.size() - 1;
        int firstEle = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted.get(mid)) {
                firstEle = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return firstEle;
    }
}
