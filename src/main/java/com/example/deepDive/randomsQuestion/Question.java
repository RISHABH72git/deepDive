package com.example.deepDive.randomsQuestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Question {

    public Question() {
    }

    public static void main(String[] arg) {
        Question question = new Question();
        question.stackCreation();
        System.out.println(BestTimetoBuyandSellStock(new int[]{7, 1, 1, 0, 0, 6, 0}));
        System.out.println("-------------------------------------------------------");
        System.out.println(containsDuplicate(new int[]{7, 1, 1, 2, 3, 6, 0}));
        System.out.println(containsDuplicateBySort(new int[]{7, 1, 1, 2, 3, 6, 0}));
    }

    public void stackCreation() {
        Stack<Integer> integerStack = new Stack<Integer>();
        integerStack.push(2);
    }

    public static int BestTimetoBuyandSellStock(int[] arr) {
        int min = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            int profit = arr[i] - min;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return maxProfit;
    }

    public static boolean containsDuplicate(int[] arr) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!integers.add(arr[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicateBySort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
