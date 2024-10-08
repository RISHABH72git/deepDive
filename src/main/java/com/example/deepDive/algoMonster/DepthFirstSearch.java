package com.example.deepDive.algoMonster;

public class DepthFirstSearch {
    public static Node dfs(Node root, int target) {
        if (root == null) {
            return null;
        }

        if (root.val == target) {
            return root;
        }

        Node left = dfs(root.left, target);
        if (left != null) {
            return left;
        }
        return dfs(root.right, target);
    }

    public static int treeMaxDepth(Node root) {
        if (root != null) {
            return dfsTreeMaxDepth(root) - 1;
        } else {
            return 0;
        }
    }

    private static int dfsTreeMaxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfsTreeMaxDepth(root.left), dfsTreeMaxDepth(root.right)) + 1;
    }

    private static int visibleTreeNodes(Node root, int max) {
        if (root == null) {
            return 0;
        }
        int total = 0;
        if (root.val >= max) {
            total++;
        }
        total += visibleTreeNodes(root.left, Math.max(max, root.val));
        total += visibleTreeNodes(root.right, Math.max(max, root.val));
        return total;
    }

    private static int balanceBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = balanceBinaryTree(root.left);
        int rightHeight = balanceBinaryTree(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Node left = new Node(4, new Node(3, null, null), new Node(8, null, null));
        Node right = new Node(6, null, null);
        Node node = new Node(5, left, right);
        System.out.println(dfs(node, 9));
        System.out.println(treeMaxDepth(node));
        System.out.println(visibleTreeNodes(node, Integer.MIN_VALUE));
        System.out.println(balanceBinaryTree(node) != -1);
    }
}
