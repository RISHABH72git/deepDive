package com.example.deepDive.algoMonster;

import java.util.Stack;

public class BinaryTree {

    public void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    public static int sumBinaryTreeValue(Node node) {
        if (node == null) {
            return 0;
        }
        return sumBinaryTreeValue(node.left) + node.val + sumBinaryTreeValue(node.right);
    }

    public static int sumBinaryTreeByStack(Node node) {
        if (node == null) {
            return 0;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        int sum = 0;
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            sum += current.val;
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return sum;
    }

    public static Node invertBinaryTree(Node root){
        if (root == null){
            return null;
        }
        return new Node(root.val, invertBinaryTree(root.right), invertBinaryTree(root.left));
    }

    public static void main(String[] arg) {
        Node left = new Node(4, new Node(3, null, null), new Node(8, null, null));
        Node right = new Node(6, null, null);
        Node node = new Node(5, left, right);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.inOrderTraversal(node);
        System.out.println("---------------------------------------");
        binaryTree.preOrderTraversal(node);
        System.out.println("---------------------------------------");
        binaryTree.postOrderTraversal(node);
        System.out.println("---------------------------------------");
        System.out.println(sumBinaryTreeValue(node));
        System.out.println("---------------------------------------");
        System.out.println(sumBinaryTreeByStack(node));
        System.out.println(invertBinaryTree(node));
    }
}
