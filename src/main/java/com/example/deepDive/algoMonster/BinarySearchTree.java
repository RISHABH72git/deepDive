package com.example.deepDive.algoMonster;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

    public static Node createBinarySearchTree(List<Integer> uniqueElements, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node treeNode = new Node(uniqueElements.get(mid), null, null);
        treeNode.left = createBinarySearchTree(uniqueElements, start, mid - 1);
        treeNode.right = createBinarySearchTree(uniqueElements, mid + 1, end);
        return treeNode;
    }

    public static void printLevel(Node root) {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int n = deque.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node node = deque.pop();
                level.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            System.out.println(level);
        }
    }

    public static void listOfDepth(Node root) {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        List<LinkedListNode<Integer>> depthList = new ArrayList<>();
        while (!deque.isEmpty()) {
            int n = deque.size();
            LinkedListNode<Integer> level = null;
            for (int i = 0; i < n; i++) {
                Node node = deque.pop();
                if (level == null){
                    level = new LinkedListNode<>(node.val);
                }else {
                    level.next = new LinkedListNode<>(node.val);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
            }
            depthList.add(level);
        }
    }

    public static void main(String[] args) {
//        Node left = new Node(4, new Node(3, null, null), new Node(8, null, null));
//        Node right = new Node(6, null, null);
//        Node node = new Node(5, left, right);
//        inOrder(insert(node, 10));
        List<Integer> uniqueElementSortedOrder = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Node root = createBinarySearchTree(uniqueElementSortedOrder, 0, uniqueElementSortedOrder.size() - 1);
        printLevel(root);
        listOfDepth(root);
    }
}
