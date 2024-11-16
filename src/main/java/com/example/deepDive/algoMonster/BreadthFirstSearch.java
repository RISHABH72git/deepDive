package com.example.deepDive.algoMonster;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreadthFirstSearch {

    private static List<List<Integer>> binaryTreeLevelOrderTraversal(Node root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0){
            int n = queue.size();
            List<Integer> newlevel = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node node = queue.pop();
                newlevel.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(newlevel);
        }
        return res;
    }

    public static List<List<Integer>> binaryTreeZigZagLevelOrderTraversal(Node root){
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leftToRight = true;
        while (queue.size() > 0){
            int n = queue.size();
            ArrayDeque<Integer> newLevel = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                Node node = queue.pop();
                if (leftToRight){
                    newLevel.add(node.val);
                }else {
                    newLevel.addFirst(node.val);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(Arrays.asList(newLevel.toArray(new Integer[0])));
            leftToRight = !leftToRight;
        }
        return res;
    }

    public static void main(String[] args){
        Node left = new Node(4, new Node(3, null, null), new Node(8, null, null));
        Node right = new Node(6, null, null);
        Node node = new Node(5, left, right);
        System.out.println(binaryTreeLevelOrderTraversal(node));
        System.out.println(binaryTreeZigZagLevelOrderTraversal(node));
    }
}
