package com.example.deepDive.algoMonster.simulation;

import java.util.Arrays;

public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    public static void main(String[] args){
        TransposeMatrix transposeMatrix = new TransposeMatrix();
        int [][] matrix = {{1,3,4}, {2,4,6}, {9,5,4}};
        System.out.println(Arrays.deepToString(transposeMatrix.transpose(matrix)));
    }
}
