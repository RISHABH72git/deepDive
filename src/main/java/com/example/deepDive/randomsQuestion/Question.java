package com.example.deepDive.randomsQuestion;

import java.util.Stack;

public class Question {

    public Question() {
    }

    public static void main(String[] arg) {
        Question question = new Question();
        question.stackCreation();
        System.out.println(BestTimetoBuyandSellStock(new int[]{7, 1, 1, 0, 0, 6, 0}));
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
}
