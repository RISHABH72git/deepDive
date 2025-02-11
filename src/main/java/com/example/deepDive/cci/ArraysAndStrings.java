package com.example.deepDive.cci;

import java.util.Arrays;
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

    public static void main(String[] args) {
        System.out.println(stringHasAllUniqueCharacters("helo"));
        System.out.println(stringHasAllUniqueCharactersWithoutAnyDataStructure("helo"));
        System.out.println(checkPermutationGivenTwoStrings("abc", "abc"));
        System.out.println(checkPermutationGivenTwoStringsWithoutSort("abcd", "dabc"));
        System.out.println(urlifyTheString("my name si h h  rish"));
    }
}
