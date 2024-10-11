import java.util.*;

public class LeetCode45_3 { //solução com teoria dos grafos direcionados
    public static void main(String[] args) {
        LeetCode45_3 leetCode45_3 = new LeetCode45_3();

        System.out.println(leetCode45_3.jump(new int[]{2,3,1,1,4}));
    }

    public int jump(int[] nums) {


        DirectedGraph2 graph = new DirectedGraph2();

        for (int i = 0; i < nums.length; i++)
            graph.addVertex(i);

        for (int i = 0; i < nums.length - 1; i++) {
            int j = i;
            while (j - i < Math.min(nums[i], nums.length - 1)) {
                try {
                    graph.addEdge(i, ++j);
                } catch (NullPointerException e) {
                    break;
                }
            }
        }


        graph.printGraph();
        return graph.dfsShortestPath(0, nums.length - 1);
    }


}

class DirectedGraph2 {
    private Map<Integer, List<Integer>> adjList; // adjacency list

    // Constructor to initialize the graph
    public DirectedGraph2() {
        adjList = new HashMap<>();
    }

    // Method to add a new vertex to the graph
    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    // Method to add a directed edge from source to destination
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
    }

    // Method to remove a directed edge from source to destination
    public void removeEdge(int src, int dest) {
        List<Integer> edges = adjList.get(src);
        if (edges != null) {
            edges.remove(Integer.valueOf(dest));
        }
    }

    // Method to print the graph
    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            List<Integer> edges = adjList.get(vertex);
            if (edges != null) {
                for (int edge : edges) {
                    System.out.print(edge + " ");
                }
            }
            System.out.println();
        }
    }

    // Depth-First Search to find the shortest path length between two nodes
    public int dfsShortestPath(int start, int target) {
        Set<Integer> visited = new HashSet<>(); // To track visited nodes
        return dfsHelper(start, target, visited, 0, Integer.MAX_VALUE);
    }

    // Helper function for DFS traversal
    private int dfsHelper(int current, int target, Set<Integer> visited, int pathLength, int minPath) {
        // If the current node is the target, return the path length
        if (current == target) {
            return Math.min(pathLength, minPath);
        }

        visited.add(current); // Mark the current node as visited

        // Explore all adjacent nodes
        for (int neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                // Recursively call DFS on the neighbor
                minPath = dfsHelper(neighbor, target, visited, pathLength + 1, minPath);
            }
        }

        visited.remove(current); // Backtrack
        return minPath;
    }}
