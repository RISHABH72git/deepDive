package com.example.deepDive.cci;

import java.util.*;

public class GraphCCI {
    class NodeGraph {
        public String name;
        public List<NodeGraph> children;

        public NodeGraph(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }
    }

    private Map<String, NodeGraph> nodes;

    public GraphCCI() {
        this.nodes = new HashMap<>();
    }

    public void addNode(String name) {
        if (!nodes.containsKey(name)) {
            nodes.put(name, new NodeGraph(name));
        }
    }

    public void addEdge(String from, String to) {
        if (nodes.containsKey(from) && nodes.containsKey(to)) {
            nodes.get(from).children.add(nodes.get(to));
        }
    }

    public void printGraph() {
        for (NodeGraph node : nodes.values()) {
            System.out.print(node.name + " -> ");
            for (NodeGraph child : node.children) {
                System.out.print(child.name + " ");
            }
            System.out.println();
        }
    }

    public static int shortestPath(Map<String, NodeGraph> graph, String start, String end) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(start);
        HashSet<String> visited = new HashSet<>();
        visited.add(start);
        int level = 0;
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String node = queue.pop();
                if (node.equals(end)) return level;
                for (NodeGraph child : graph.get(node).children) {
                    if (visited.contains(child.name)) {
                        continue;
                    }
                    queue.add(child.name);
                    visited.add(child.name);
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] arg) {
        GraphCCI graphCCI = new GraphCCI();
        graphCCI.addNode("0");
        graphCCI.addNode("1");
        graphCCI.addNode("2");
        graphCCI.addNode("3");

        graphCCI.addEdge("0", "1");
        graphCCI.addEdge("0", "2");

        graphCCI.addEdge("1", "0");
        graphCCI.addEdge("1", "2");
        graphCCI.addEdge("1", "3");

        graphCCI.addEdge("2", "0");
        graphCCI.addEdge("2", "1");

        graphCCI.addEdge("3", "1");

        graphCCI.printGraph();
        int level = GraphCCI.shortestPath(graphCCI.nodes, "0", "3");
        System.out.println(level);
    }
}
