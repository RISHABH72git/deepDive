package com.example.deepDive.algoMonster;

import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        //System.out.println(binarySearch.vanillaBinarySearch(List.of(1, 3, 6, 8, 9, 10), 8));
        //System.out.println(binarySearch.vanillaBinarySearch(List.of(1, 3, 6, 8, 9, 10), 11));
//        System.out.println(binarySearch.firstTrueInSortedArray(List.of(false, false, false, false, true, true)));
        System.out.println(binarySearch.firstElementNotSmallerThanTarget(List.of(1, 3, 3, 5, 8, 9), 2));
        System.out.println(binarySearch.findElementInSortedArrayWithDuplicates(List.of(1, 3, 3, 5, 8, 9), 3));
        System.out.println(binarySearch.squareRootEstimation(8));
        System.out.println(binarySearch.findMinimumInRotatedSortedArray(List.of(3, 5, 7, 11, 13, 17, 19, 2)));
        System.out.println(binarySearch.peakMountainArray(List.of(0, 10, 3, 2, 1, 0)));
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

    private int firstElementNotSmallerThanTarget(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int output = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                output = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return output;
    }

    private int findElementInSortedArrayWithDuplicates(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int output = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                output = mid;
                right = mid - 1;
            } else if (list.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return output;
    }

    private int squareRootEstimation(int num) {
        if (num == 0) return num;
        int left = 1;
        int right = num;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == num / mid) {
                return mid;
            } else if (mid > num / mid) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res - 1;
    }

    private int findMinimumInRotatedSortedArray(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        int output = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= list.get(list.size() - 1)) {
                output = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return output;
    }

    private int peakMountainArray(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        int output = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= list.get(mid + 1)) {
                output = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return output;
    }
}
