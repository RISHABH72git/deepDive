package com.example.deepDive.algoMonster.simulation;

public class RobotReturnToOrigin {

    public boolean jungleCircle(String moves) {
        int x = 0, y = 0;

        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);

            if (move == 'R') {
                x++;
            } else if (move == 'L') {
                x--;
            } else if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            }

        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        RobotReturnToOrigin robotReturnToOrigin = new RobotReturnToOrigin();
        System.out.println(robotReturnToOrigin.jungleCircle("URDL"));
    }
}
