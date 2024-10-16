package com.example.deepDive.algoMonster;

import java.util.ArrayList;
import java.util.List;
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

    public static void main(String[] args) {
        TernaryNode last = new TernaryNode(3);
        TernaryNode first = new TernaryNode(2, List.of(last));
        TernaryNode second = new TernaryNode(4);
        TernaryNode third = new TernaryNode(6);
        TernaryNode ternaryNode = new TernaryNode(1, List.of(first, second, third));
        traverse(ternaryNode);
        System.out.println(ternaryTreePaths(ternaryNode));
        System.out.println(combinatorialSearchProblems(2));
    }


}
