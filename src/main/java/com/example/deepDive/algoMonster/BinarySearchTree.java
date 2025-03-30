package com.example.deepDive.algoMonster;

import java.util.List;

public class BinarySearchTree {

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val, null, null);
        }
        if (root.val > val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public static void createBinarySearchTree(List<Integer> uniqueElements) {
        int mid = uniqueElements.size() / 2;
        Node root = new Node(uniqueElements.get(mid), null, null);
        for (int i = 0; i < mid; i++) {
            insert(root, uniqueElements.get(i));
        }
        for (int i = mid + 1; i < uniqueElements.size(); i++) {
            insert(root, uniqueElements.get(i));
        }
    }

    public static void main(String[] args) {
//        Node left = new Node(4, new Node(3, null, null), new Node(8, null, null));
//        Node right = new Node(6, null, null);
//        Node node = new Node(5, left, right);
//        inOrder(insert(node, 10));
        List<Integer> uniqueElementSortedOrder = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        createBinarySearchTree(uniqueElementSortedOrder);
    }
}
