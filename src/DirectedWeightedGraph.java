import java.util.*;

public class DirectedWeightedGraph {
    // Adjacency list to store edges (from -> list of (to, weight))
    private Map<Integer, List<Edge>> adjList;

    // Constructor to initialize the graph
    public DirectedWeightedGraph() {
        adjList = new HashMap<>();
    }

    // Edge class to store the destination node and the edge weight
    private static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + destination + ", " + weight + ")";
        }
    }

    // Add a directed, weighted edge from 'from' node to 'to' node
    public void addEdge(int from, int to, int weight) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.get(from).add(new Edge(to, weight));
    }

    // Get neighbors of a node
    public List<Edge> getNeighbors(int node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }

    // Display the graph
    public void printGraph() {
        for (int node : adjList.keySet()) {
            System.out.print("Node " + node + ": ");
            for (Edge edge : adjList.get(node)) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    // Get all nodes in the graph
    public Set<Integer> getNodes() {
        return adjList.keySet();
    }

    public int size(){
        return adjList.keySet().size();
    }

}