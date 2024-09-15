package com.example.deepDive.algoMonster;

import java.util.ArrayList;
import java.util.List;

public class StackIntro {
    public static void main(String[] args) {
        peek();
        push(1);
        push(2);
        peek();
        push(4);
        pop();
        pop();
        peek();
    }

    static List<Integer> stack = new ArrayList<>();

    private static void push(Integer integer) {
        stack.add(integer);
    }

    private static void pop() {
        if (!stack.isEmpty()) {
            stack.remove(stack.size() - 1);
        }
    }

    private static void peek() {
        if (!stack.isEmpty()) {
            Integer integer = stack.get(stack.size() - 1);
            System.out.println("peek is " + integer);
        }
    }
}
