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

    public static void main(String[] arg) {
        System.out.println(uniquePath(5, 3));
        List<List<Integer>> grid = List.of(List.of(1, 3, 1), List.of(1, 5, 1), List.of(4, 2, 1));
        System.out.println(minimalPathSum(grid));
    }
}
