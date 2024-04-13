package com.example.deepDive.kk.Sorting;

import java.util.Arrays;
import java.util.Collections;

public class Sort {

    public Sort() {
    }

    public static void main(String[] arr) {
        int[] list = {-98, 635, 1, 0, 383, 3, 8, 5, 2};
        Sort sort = new Sort();
        sort.quick_sort(list, 0, list.length - 1);
        System.out.println(Arrays.toString(list));
    }

    public void bubble_sort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    int tem = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tem;
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }

    public void selection_sort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int lastIndex = list.length - i - 1;
            int largest = 0;
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[largest] < list[j + 1]) {
                    largest = j + 1;
                }
            }
            int tem = list[largest];
            list[largest] = list[lastIndex];
            list[lastIndex] = tem;
        }
        System.out.println(Arrays.toString(list));
    }

    public int[] merge_sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = merge_sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = merge_sort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        return mix;
    }

    public void quick_sort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }
        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];
        while (s <= e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        quick_sort(nums, low, e);
        quick_sort(nums, s, hi);
    }
}
