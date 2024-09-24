package com.example.deepDive.algoMonster.simulation;

public class TicTacToe {
    private int size;
    private int[][] moveCounters;

    public TicTacToe(int size) {
        this.size = size;
        this.moveCounters = new int[2][size * 2 + 2];
    }

    private int move(int row, int col, int player) {
        moveCounters[player - 1][row]++;
        moveCounters[player - 1][col + size]++;

        if (row == col) {
            moveCounters[player - 1][size * 2]++;
        }

        if (row + col == size - 1) {
            moveCounters[player - 1][size * 2 + 1]++;
        }
        if (moveCounters[player - 1][row] == size || moveCounters[player - 1][col + size] == size ||
                moveCounters[player - 1][size * 2] == size || moveCounters[player - 1][size * 2 + 1] == size) {
            return player;
        }
        return 0;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.println(ticTacToe.move(1, 1, 1));
        System.out.println(ticTacToe.move(2, 2, 2));
        System.out.println(ticTacToe.move(0, 2, 1));
        System.out.println(ticTacToe.move(2, 0, 2));
        System.out.println(ticTacToe.move(0, 0, 2));
        System.out.println(ticTacToe.move(2, 1, 2));
    }
}
