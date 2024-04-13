package com.example.deepDive.randomsQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Question {

    public Question() {
    }

    public static void main(String[] arg) {
        Question question = new Question();
        question.stackCreation();
    }

    public void stackCreation() {
        Stack<Integer> integerStack = new Stack<Integer>();
        integerStack.push(2);
    }
}
