package com.example.deepDive.cci;

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

    public static void main(String[] args) {
        System.out.println(stringHasAllUniqueCharacters("helo"));
        System.out.println(stringHasAllUniqueCharactersWithoutAnyDataStructure("helo"));
    }
}
