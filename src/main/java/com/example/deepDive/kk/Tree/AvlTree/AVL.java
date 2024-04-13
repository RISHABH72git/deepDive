package com.example.deepDive.kk.Tree.AvlTree;

public class AVL {

    private Node root;

    public AVL() {
    }

    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.insert();
        avl.display();
    }

    public void insert() {
        int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9,};
        for (int item : items) {
            root = insert(item, root);
        }
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }
        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void display() {
        display(root);
    }

    public void display(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getValue());
        display(node.left);
        display(node.right);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            if (height(node.right.left) - height(node.right.right) < 0) {
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                node.right = rightRotate(node.left);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node node) {
        Node p = node.right;
        Node t = p.left;
        p.left = node;
        node.right = t;
        p.height = Math.max(height(p.left), height(p.right) + 1);
        node.height = Math.max(height(node.left), height(node.right) + 1);
        return p;
    }

    private Node rightRotate(Node node) {
        Node c = node.left;
        Node t = c.right;
        c.right = node;
        node.left = t;
        node.height = Math.max(height(node.left), height(node.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }

    private class Node {

        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
