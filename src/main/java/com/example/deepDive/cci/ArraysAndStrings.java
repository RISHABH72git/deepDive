package com.example.deepDive.cci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArraysAndStrings {
    public static boolean stringHasAllUniqueCharacters(String str) {
        Set<Character> unique = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!unique.add(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean stringHasAllUniqueCharactersWithoutAnyDataStructure(String str) {
        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            if (rem.contains(String.valueOf(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPermutationGivenTwoStrings(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        if (char1.length != char2.length) {
            return false;
        }
        Arrays.sort(char1);
        Arrays.sort(char2);
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPermutationGivenTwoStringsWithoutSort(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        if (char1.length != char2.length) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < char1.length; i++) {
            count[char1[i] - 'a']++;
            count[char2[i] - 'a']--;
        }

        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static String urlifyTheString(String raw) {
        StringBuilder newCharString = new StringBuilder();
        int pointer = 0;
        for (int i = 0; i < raw.toCharArray().length; i++) {
            if (!String.valueOf(raw.charAt(i)).equals(" ")) {
                pointer = i;
                newCharString.append(raw.charAt(i));
            } else {
                if (pointer + 1 == i || pointer == 0) {
                    newCharString.append("%20");
                }
            }
        }
        return newCharString.toString();
    }

    public static boolean oneAway(String str1, String str2) {
        int char1 = str1.length();
        int char2 = str2.length();
        if (Math.abs(char1 - char2) > 1) {
            return false;
        }
        if (char1 == char2) {
            boolean foundDifference = false;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    if (foundDifference) {
                        return false;
                    }
                    foundDifference = true;
                }
            }
            return true;
        }

        if (char1 > char2) {
            return oneInsertEdit(str2, str1);
        } else {
            return oneInsertEdit(str1, str2);
        }
    }

    public static boolean oneInsertEdit(String shorter, String longer) {
        int index1 = 0, index2 = 0;
        boolean foundDifference = false;

        while (index1 < shorter.length() && index2 < longer.length()) {
            if (shorter.charAt(index1) != longer.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return foundDifference;
    }

    public static String basicStringCompression(String str) {
        StringBuilder sb = new StringBuilder();
        int lastPointer = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(lastPointer) == str.charAt(i)) {
                count++;
            } else {
                sb.append(str.charAt(i - 1));
                sb.append(count);
                count = 1;
                lastPointer = i;
            }
        }
        sb.append(str.charAt(str.length() - 1)).append(count);
        return sb.toString();
    }

    public static int[][] rotateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = i; j < matrix.length; j++) {
                System.out.println(i + "" + j + "==" + matrix[i][j]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
        return matrix;
    }

    public static int[][] zerosMatrix(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < column.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                for (int j = 0; j < column.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < column.length; i++) {
            if (column[i]) {
                for (int j = 0; j < row.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(stringHasAllUniqueCharacters("helo"));
        System.out.println(stringHasAllUniqueCharactersWithoutAnyDataStructure("helo"));
        System.out.println(checkPermutationGivenTwoStrings("abc", "abc"));
        System.out.println(checkPermutationGivenTwoStringsWithoutSort("abcd", "dabc"));
        System.out.println(urlifyTheString("my name si h h  rish"));
        System.out.println(oneAway("pale", "ple"));  // true (remove 'a')
        System.out.println(oneAway("pales", "pale")); // true (remove 's')
        System.out.println(oneAway("pale", "bale"));  // true (replace 'p' with 'b')
        System.out.println(oneAway("pale", "bake"));
        System.out.println(basicStringCompression("aaaaabbbcccddde"));
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(rotateMatrix(matrix)));
        int[][] setZerosMatrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(zerosMatrix(setZerosMatrix)));
    }
}
