package com.example.deepDive.challenges100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MathematicalProblem {

    Map<Integer, String> digitAsText = Map.of(0, "ZERO", 1, "ONE", 2, "TWO", 3, "THREE", 4, "FOUR", 5, "FIVE", 6, "SIX", 7, "SEVEN", 8, "EIGHT", 9, "NINE");

    public MathematicalProblem() {
    }

    public static void main(String[] arg) {
        MathematicalProblem mathematicalProblem = new MathematicalProblem();
        System.out.println(mathematicalProblem.calcPerfectNumbers(30));
    }

    /*Basic Arithmetic operation
    Write method int calc(int, int) that multiplies two variables, m and n of type int,
    then divides the product by two, and outputs the remainder with respect to division by 7*/
    public int calc(int num1, int num2) {
        int multiply = num1 * num2;
        int divide = multiply / 2;
        return divide % 7;
    }

    /*Find the number as well as the sum of natural numbers, which are divisible by 2 or 7 up
    to a given maximum value (exclusive) and output it to the console. Write method void
    calcSumAndCountAllNumbersDivBy_2_Or_7(int). Extend it so that it returns the two
    values instead of performing the console output.*/
    public void calcSumAndCountAllNumbersDivBy_2_Or_7(int max) {
        int[] divisibleBy2 = new int[max + 1];
        int[] divisibleBy7 = new int[max + 1];
        for (int i = 1; i < max; i++) {
            if ((i % 2) == 0) {
                divisibleBy2[i] = i;
            }
            if ((i % 7) == 0) {
                divisibleBy7[i] = i;
            }
        }
        System.out.println("divisible by 2 :" + Arrays.toString(divisibleBy2));
        System.out.println("divisible by 7 :" + Arrays.toString(divisibleBy7));
        for (int i = 0; i < max; i++) {
            if (divisibleBy2[i] == divisibleBy7[i]) {
                divisibleBy7[i] = 0;
            }
        }
        long divisibleBy2Count = Arrays.stream(divisibleBy2).filter(value -> value > 0).count();
        long divisibleBy7Count = Arrays.stream(divisibleBy7).filter(value -> value > 0).count();
        System.out.println("result count : " + (divisibleBy2Count + divisibleBy7Count));
        long divisibleBy2Sum = Arrays.stream(divisibleBy2).sum();
        long divisibleBy7Sum = Arrays.stream(divisibleBy7).sum();
        System.out.println("result sum : " + (divisibleBy7Sum + divisibleBy2Sum));
    }

    public void calcSumAndCountAllNumbersDivBy_2_Or_7_Copy(int max) {
        int[] divisibleBy2 = new int[max + 1];
        int[] divisibleBy7 = new int[max + 1];
        for (int i = 1; i < max; i++) {
            if ((i % 2) == 0) {
                divisibleBy2[i] = i;
            }
            if ((i % 7) == 0) {
                divisibleBy7[i] = i;
            }
        }
        System.out.println("divisible by 2 :" + Arrays.toString(divisibleBy2));
        System.out.println("divisible by 7 :" + Arrays.toString(divisibleBy7));
        for (int i = 0; i < max; i++) {
            if (divisibleBy2[i] == divisibleBy7[i]) {
                divisibleBy7[i] = 0;
            }
        }
        long divisibleBy2Count = Arrays.stream(divisibleBy2).filter(value -> value > 0).count();
        long divisibleBy7Count = Arrays.stream(divisibleBy7).filter(value -> value > 0).count();
        System.out.println("result count : " + (divisibleBy2Count + divisibleBy7Count));
        long divisibleBy2Sum = Arrays.stream(divisibleBy2).sum();
        long divisibleBy7Sum = Arrays.stream(divisibleBy7).sum();
        System.out.println("result sum : " + (divisibleBy7Sum + divisibleBy2Sum));
        Map<ReturnCode, Long> returnCodeVMap = Map.of(ReturnCode.SUM, (divisibleBy7Sum + divisibleBy2Sum), ReturnCode.COUNT, (divisibleBy2Count + divisibleBy7Count));
        System.out.println(returnCodeVMap);
    }

    /*Create the methods boolean isEven(n) and boolean isOdd(n) that will check if the
    passed integer is even or odd, respectively.*/
    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    /*Write method String numberAsText(int) which, for a given positive number, converts
    the respective digits into corresponding text.*/
    public String numberAsText(int num) {
        String text = "";
        int remainingNum = num;
        while (remainingNum > 0) {
            text = digitAsText.get(remainingNum % 10) + " " + text;
            remainingNum /= 10;
        }
        return text;
    }

    /*Write method List<Integer> calcPerfectNumbers(int) that calculates the perfect
    numbers up to a maximum value, say 10,000.*/
    public List<Integer> calcPerfectNumbers(int max) {
        List<Integer> integerList = new ArrayList<>();
        int[] element = new int[max];
        int count = 0;
        for (int i = 1; i <= max; i++) {
            element[i - 1] = i;
            count += i;
            System.out.println(count);
            int counter = 0;
            for (int j = 0; j < i; j++) {
                if (count % element[j] == 0) {
                    counter+=1;
                }
                if (counter == i) {
                    integerList.add(count);
                }
            }
        }
        System.out.println(Arrays.toString(element));
        return integerList;
    }

    enum ReturnCode {SUM, COUNT}

}
