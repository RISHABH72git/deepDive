package com.example.deepDive.randomsQuestion;

import java.util.Stack;

public class Question {

    public Question() {
    }

    public static void main(String[] arg) {
        Question question = new Question();
        question.stackCreation();
        System.out.println(BestTimetoBuyandSellStock(new int[]{7, 6, 4, 3, 1}));
    }

    public void stackCreation() {
        Stack<Integer> integerStack = new Stack<Integer>();
        integerStack.push(2);
    }

    public static int BestTimetoBuyandSellStock(int[] arr) {
        int min = Integer.MIN_VALUE;
        int left = 0;
        for (int i = 1; i < arr.length; i++) {
            int res = arr[i] - arr[left];
            if (res < 0) {
                left++;
            }
            if (res > min) {
                min = res;
            }
        }
        return Math.max(min, 0);
    }
}
