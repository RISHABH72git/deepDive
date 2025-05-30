package com.example.deepDive.algoMonster;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
                if (level == null) {
                    level = new LinkedListNode<>(node.val);
                } else {
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

    public static int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean balancedTree(Node root) {
        return treeHeight(root) != -1;
    }

    public static boolean validBinarySearchTree(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (!(min < root.val && root.val < max)) {
            return false;
        }
        return validBinarySearchTree(root.left, min, root.val) && validBinarySearchTree(root.right, root.val, max);
    }

    public static Node inOrderSuccessor(Node root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            return leftMostChild(root.right);
        }
        return root;
    }

    private static Node leftMostChild(Node right) {
        if (right == null) {
            return null;
        }
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }

    public static List<Integer> bstSequenceLeft(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        bstSequenceLeft(root.left, list);
        bstSequenceLeft(root.right, list);
        return list;
    }

    public static List<Integer> bstSequenceRight(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        bstSequenceRight(root.right, list);
        bstSequenceRight(root.left, list);
        return list;
    }

    public static void main(String[] args) {
//        Node left = new Node(4, new Node(3, null, null), new Node(8, null, null));
//        Node right = new Node(6, null, null);
//        Node node = new Node(5, left, right);
//        inOrder(insert(node, 10));
        List<Integer> uniqueElementSortedOrder = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Node root = createBinarySearchTree(uniqueElementSortedOrder, 0, uniqueElementSortedOrder.size() - 1);
        printLevel(root);
        System.out.println(balancedTree(root));
        System.out.println(validBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
//        Node successor = inOrderSuccessor(root);
//        System.out.println(successor.val);
        System.out.println("---------------------------------");
        List<Integer> leftSequence = bstSequenceLeft(root, new ArrayList<>());
        List<Integer> rightSequence = bstSequenceRight(root, new ArrayList<>());
        System.out.println(leftSequence);
        System.out.println(rightSequence);
    }
}
