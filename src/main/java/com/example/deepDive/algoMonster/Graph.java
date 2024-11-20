package com.example.deepDive.algoMonster;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class Graph {
    public static int vanillaShortestPathBetweenAandB(List<List<Integer>> graph, int root, int target) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(root);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(root);
        int level = 0;
        while (deque.size() > 0) {
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                int node = deque.pop();
                if (node == target) return level;
                System.out.println("s----------------------------"+node);
                for (Integer neighbour: graph.get(node)){
                    System.out.println(neighbour);
                    if (visited.contains(neighbour)) continue;
                    deque.add(neighbour);
                    visited.add(neighbour);
                }
                System.out.println("c----------------------------"+node);
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(List.of(1,2), List.of(0,2,3), List.of(0,1), List.of(1));
        System.out.println(vanillaShortestPathBetweenAandB(graph, 0, 3));
    }
}
