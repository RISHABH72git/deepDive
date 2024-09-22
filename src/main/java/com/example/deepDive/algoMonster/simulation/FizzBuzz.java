package com.example.deepDive.algoMonster.simulation;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        for (int num = 1; num <= n; num++) {
            String current = "";

            if (num % 3 == 0) {
                current += "Fizz";
            }

            if (num % 5 == 0) {
                current += "Buzz";
            }

            if (current.isEmpty()) {
                current += Integer.toString(num);
            }
            answer.add(current);
        }
        return answer;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(100));
    }
}
