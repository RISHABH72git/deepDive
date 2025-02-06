package com.example.deepDive.algoMonster;

import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {

    private static int uniquePath(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[n - 1][m - 1];
    }

    private static int minimalPathSum(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dp = new int[m][n];
        System.out.println(Arrays.deepToString(dp));
        dp[0][0] = grid.get(0).get(0);
        for (int c = 1; c < n; c++) {
            dp[0][c] = dp[0][c - 1] + grid.get(0).get(c);
        }

        for (int r = 1; r < m; r++) {
            dp[r][0] = dp[r - 1][0] + grid.get(r).get(0);
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = Math.min(dp[r][c - 1], dp[r - 1][c]) + grid.get(r).get(c);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m - 1][n - 1];
    }

    private static int triangleMinPathSumRecursion(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }
        int leftSum = triangleMinPathSumRecursion(triangle, row + 1, col);
        int rightSum = triangleMinPathSumRecursion(triangle, row + 1, col + 1);
        System.out.println(triangle.get(row).get(col) + "  +   Min of "+ leftSum +" " + rightSum);
        return triangle.get(row).get(col) + Math.min(leftSum, rightSum);
    }

    private static int triangleMinPathSum(List<List<Integer>> triangle) {
        return triangleMinPathSumRecursion(triangle, 0, 0);
    }


    public static void main(String[] arg) {
        System.out.println(uniquePath(5, 3));
        List<List<Integer>> grid = List.of(List.of(1, 3, 1), List.of(1, 5, 1), List.of(4, 2, 1));
        System.out.println(minimalPathSum(grid));
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
        System.out.println(triangleMinPathSum(triangle));
    }
}
