package com.example.deepDive.algoMonster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TernaryNode {
    private int val;
    private List<TernaryNode> children;

    public TernaryNode(int val, List<TernaryNode> children) {
        this.val = val;
        this.children = children;
    }

    public TernaryNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public static void traverse(TernaryNode node) {
        System.out.println(node.val);
        if (node.children.size() == 0) {
            return;
        }
        for (TernaryNode child : node.children) {
            traverse(child);
        }
    }

    public static void ternaryTreePathsRecursion(TernaryNode node, List<String> res, List<String> path) {
        if (node.children.size() == 0) {
            path.add(Integer.toString(node.val));
            res.add(String.join("->", path));
            return;
        }
        for (TernaryNode child : node.children) {
            ArrayList<String> pathCopy = new ArrayList<>(path);
            pathCopy.add(Integer.toString(node.val));
            ternaryTreePathsRecursion(child, res, pathCopy);
        }
    }

    public static List<String> ternaryTreePaths(TernaryNode node) {
        List<String> res = new ArrayList<>();
        if (node != null) {
            ternaryTreePathsRecursion(node, res, new ArrayList<>());
        }
        return res;
    }

    private static void combinatorialSearchProblemsRecursion(Integer n, List<String> res, int startIndex, List<Character> path){
        if(startIndex == n){
            res.add(path.stream().map(Object::toString).collect(Collectors.joining()));
            return;
        }
        for (char letter : new char[] {'a', 'b', 'c', 'd'}){
            path.add(letter);
            combinatorialSearchProblemsRecursion(n, res, startIndex +1, path);
            path.remove(startIndex);
        }
    }
    public static List<String> combinatorialSearchProblems(Integer n){
        List<String> res = new ArrayList<>();
        combinatorialSearchProblemsRecursion(n, res, 0 , new ArrayList<>());
        return res;
    }
    private static final Map<Character, char[]> KEYBOARD = Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray());

    private static void generateAllLetterCombinationsFromPhoneNumberRecursion(String digits, List<String> res, StringBuilder path, int startIndex){
        if (digits.length() == startIndex){
            res.add(path.toString());
            return;
        }
        char number = digits.charAt(startIndex);
        for (char alpha :  KEYBOARD.get(number)){
            path.append(alpha);
            generateAllLetterCombinationsFromPhoneNumberRecursion(digits, res, path, startIndex +1);
            path.deleteCharAt(path.length() -1);
        }
    }

    public static List<String> generateAllLetterCombinationsFromPhoneNumber(String digits){
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        generateAllLetterCombinationsFromPhoneNumberRecursion(digits, res, path, 0);
        return res;
    }

    public static void main(String[] args) {
        TernaryNode last = new TernaryNode(3);
        TernaryNode first = new TernaryNode(2, List.of(last));
        TernaryNode second = new TernaryNode(4);
        TernaryNode third = new TernaryNode(6);
        TernaryNode ternaryNode = new TernaryNode(1, List.of(first, second, third));
        traverse(ternaryNode);
        System.out.println(ternaryTreePaths(ternaryNode));
        System.out.println(combinatorialSearchProblems(2));
        System.out.println(generateAllLetterCombinationsFromPhoneNumber("5637"));
    }


}
