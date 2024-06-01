package com.example.deepDive.grokking.patternSlidingWindow;

public class SlidingWindow {

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        int value = slidingWindow.Maximum_Sum_Subarray_of_Size_K_Second(3, new int[]{2, 1, 5, 1, 3, 2});
        System.out.println(value);
    }

    /*
        Given an array of positive numbers and a positive number ‘k’,
        find the maximum sum of any contiguous subarray of size ‘k’.

        Example :-
        Input: [2, 1, 5, 1, 3, 2], k=3
        Output: 9
        Explanation: Subarray with maximum sum is [5, 1, 3].
    */
    //Time Complexity O(n*k)
    public int Maximum_Sum_Subarray_of_Size_K_First(int k, int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                count += arr[j];
            }
            result = Math.max(count, result);
        }
        return result;
    }

    //Time Complexity O(n)
    public int Maximum_Sum_Subarray_of_Size_K_Second(int k, int[] arr) {
        int sum = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                max = Math.max(max, sum);
                sum = sum - arr[index];
                index++;
            }
        }
        return max;
    }
}
