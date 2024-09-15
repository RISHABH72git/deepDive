package com.example.deepDive.grokking.patternSlidingWindow;

public class SlidingWindow {

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        int value = slidingWindow.Smallest_Subarray_with_a_given_sum_3(7, new int[]{2, 1, 5, 2, 3, 2});
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
    public int Maximum_Sum_Subarray_of_Size_K_1(int k, int[] arr) {
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
    public int Maximum_Sum_Subarray_of_Size_K_2(int k, int[] arr) {
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

    /*
    Given an array of positive numbers and a positive number ‘S’,
    find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
    Example:
    Input: [2, 1, 5, 2, 3, 2], S=7
    Output: 2
    Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
    */
    //Time Complexity O(n*n*n)
    public int Smallest_Subarray_with_a_given_sum_1(int s, int[] arr) {
        int subarray = Integer.MAX_VALUE;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int count = 0;
                int sub = 0;
                int limit = Math.min(j + i, arr.length);
                for (int k = j; k < limit; k++) {
                    count += arr[k];
                    sub++;
                }
                if (s <= count) {
                    subarray = Math.min(subarray, sub);
                }
            }
        }
        return subarray == Integer.MAX_VALUE ? 0 : subarray;
    }

    //Time Complexity O(n*n)
    public int Smallest_Subarray_with_a_given_sum_2(int s, int[] arr) {
        int subArray = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int count = arr[i];
            int sub = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (count >= s) {
                    break;
                }
                sub++;
                count += arr[j];
            }
            if (count >= s) {
                subArray = Math.min(subArray, sub + 1);
            }
        }
        return subArray == Integer.MAX_VALUE ? 0 : subArray;
    }

    //Time Complexity O(n)
    public int Smallest_Subarray_with_a_given_sum_3(int s, int[] arr) {
        int sum = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= s) {
                min = Math.min(min, i - start + 1);
                sum -= arr[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int Longest_Substring_with_K_Distinct_Characters(String element, int k) {
        return 0;
    }
}
