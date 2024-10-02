package com.example.deepDive.algoMonster;

public class BinaryTree {

    public static class Node {
        public Integer val;
        public Node left;
        public Node right;

        public Node(Integer val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
    }
}
