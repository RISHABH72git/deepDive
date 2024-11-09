package com.example.deepDive.algoMonster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private static Node invertBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        return new Node(root.val, invertBinaryTree(root.right), invertBinaryTree(root.left));
    }

    private static boolean subTreeOfAnotherTree(Node root, Node subTree) {
        if (root == null) {
            return false;
        }
        return checkTree(root, subTree) || subTreeOfAnotherTree(root.left, subTree) || subTreeOfAnotherTree(root.right, subTree);
    }

    private static boolean checkTree(Node root, Node subTree) {
        if (root == null && subTree == null) {
            return true;
        }
        if (root == null || subTree == null) {
            return false;
        }
        return root.val.equals(subTree.val) && checkTree(root.left, subTree.left) && checkTree(root.right, subTree.right);
    }

    public static boolean validBST(Node root) {
        return valid_BST_DFS(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean valid_BST_DFS(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (!(minValue < root.val && root.val > maxValue)) {
            return false;
        }
        return valid_BST_DFS(root.left, minValue, root.val) && valid_BST_DFS(root.right, root.val, maxValue);
    }

    public static Node insertBST(Node node, int val) {
        if (node == null) {
            return new Node(val, null, null);
        }
        if (node.val > val) {
            node.left = insertBST(node.left, val);
        } else {
            node.right = insertBST(node.right, val);
        }
        return node;
    }

    public static int lowestCommonAncestorBST(Node node, int p, int q) {
        if (p < node.val && q < node.val) {
            return lowestCommonAncestorBST(node.left, p, q);
        } else if (p > node.val && q > node.val) {
            return lowestCommonAncestorBST(node.right, p, q);
        } else {
            return node.val;
        }
    }

    public static List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesesRecursion(0, new ArrayList<>(), 0, 0, res, n);
        return res;
    }

    private static void generateParenthesesRecursion(int startIndex, List<Character> path, int open, int close, List<String> res, int n) {
        if (path.size() == 2 * n) {
            res.add(path.stream().map(Object::toString).collect(Collectors.joining()));
            return;
        }
        if (open < n) {
            path.add('(');
            generateParenthesesRecursion(startIndex, path, open + 1, close, res, n);
            path.remove(path.size() - 1);
        }
        if (close < open) {
            path.add(')');
            generateParenthesesRecursion(startIndex, path, open, close + 1, res, n);
            path.remove(path.size() - 1);
        }
    }

    private static List<String> generalAllPermutations(String letter) {
        List<String> res = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        char[] letterChar = letter.toCharArray();
        generalAllPermutationsRecursion(res, 0, new boolean[letterChar.length], path, letterChar);
        return res;
    }

    private static void generalAllPermutationsRecursion(List<String> res, int startIndex, boolean[] used, List<Character> path, char[] letterChar) {
        if (startIndex == used.length) {
            res.add(path.stream().map(Object::toString).collect(Collectors.joining()));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(letterChar[i]);
            used[i] = true;
            generalAllPermutationsRecursion(res, startIndex + 1, used, path, letterChar);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    private static int fibo(int num, int[] memo) {
        if (memo[num] != 0) {
            return memo[num];
        }
        if (num == 1 || num == 0) {
            return num;
        }
        int res = fibo(num - 1, memo) + fibo(num - 2, memo);
        memo[num] = res;
        return res;
    }

    public static boolean wordBreak(String s, List<String> words) {
        return wordBreakRecursion(0, new Boolean[s.length()], s, words);
    }

    private static boolean wordBreakRecursion(int startIndex, Boolean[] memo, String target, List<String> words) {
        if (startIndex == target.length()) {
            return true;
        }
        if (memo[startIndex] != null) {
            return memo[startIndex];
        }
        boolean ans = false;
        for (String word : words) {
            if (target.substring(startIndex).startsWith(word)) {
                ans = ans || wordBreakRecursion(startIndex + word.length(), memo, target, words);
            }
        }
        memo[startIndex] = ans;
        return ans;
    }

    private static int minimumNumberofCoinstoMakeUpaGivenValueRecursion(List<Integer> coins, int amount, int sum, int[] memo) {
        if (sum == amount) {
            return 0;
        }
        if (sum > amount) {
            return Integer.MAX_VALUE;
        }
        if (memo[sum] != -1) {
            return memo[sum];
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = minimumNumberofCoinstoMakeUpaGivenValueRecursion(coins, amount, sum + coin, memo);
            if (result == Integer.MAX_VALUE) {
                continue;
            }
            ans = Math.min(ans, result + 1);
        }
        return memo[sum] = ans;
    }

    private static int minimumNumberofCoinstoMakeUpaGivenValue(List<Integer> coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int result = minimumNumberofCoinstoMakeUpaGivenValueRecursion(coins, amount, 0, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        Node left = new Node(4, new Node(3, null, null), new Node(8, null, null));
        Node right = new Node(6, null, null);
        Node node = new Node(5, left, right);
        System.out.println(dfs(node, 9));
        System.out.println(treeMaxDepth(node));
        System.out.println(visibleTreeNodes(node, Integer.MIN_VALUE));
        System.out.println(balanceBinaryTree(node) != -1);
        Node inverted = invertBinaryTree(node);
        System.out.println(subTreeOfAnotherTree(node, left));
        System.out.println(validBST(node));
        System.out.println(insertBST(node, 10));
        System.out.println(lowestCommonAncestorBST(node, 3, 8));
        System.out.println(generateParentheses(3));
        System.out.println(generalAllPermutations("abcd"));
        System.out.println(fibo(6, new int[20]));
        System.out.println(wordBreak("algomonster", List.of("algo")));
        System.out.println(minimumNumberofCoinstoMakeUpaGivenValue(List.of(1,5,2), 11));
    }
}
