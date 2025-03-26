package com.example.deepDive.cci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static void main(String[] arg) {
        GraphCCI graphCCI = new GraphCCI();
        graphCCI.addNode("A");
        graphCCI.addNode("B");
        graphCCI.addNode("C");

        graphCCI.addEdge("A", "B");
        graphCCI.addEdge("A", "C");
        graphCCI.printGraph();
    }
}
