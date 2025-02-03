package com.example.deepDive.algoMonster;

import java.util.Arrays;

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

    public static void main(String[] arg) {
        System.out.println(uniquePath(5, 3));
    }
}
