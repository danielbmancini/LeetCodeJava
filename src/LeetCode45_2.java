import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class LeetCode45_2 { // solução com teoria dos grafos direcionados
    public static void main(String[] args) throws IOException {
        LeetCode45_2 leetCode45_2 = new LeetCode45_2();
        List<Integer> ints = readCommaSeparatedInts("numeros");

        int[] ints2 = new int[ints.size()];
        int j = 0;
        for (Integer integer : ints) {
            ints2[j++] = integer;
        }

        System.out.println(leetCode45_2.jump(ints2));
    }

    public static List<Integer> readCommaSeparatedInts(String filePath) {
        try {
            // Read all lines from the file
            String content = Files.readString(Paths.get(filePath));
            // Split the string by commas and convert to integers
            return Stream.of(content.split(","))
                    .map(String::trim) // Trim any whitespace
                    .filter(s -> !s.isEmpty()) // Filter out empty strings
                    .map(Integer::parseInt) // Parse to Integer
                    .toList(); // Collect to a List
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer: " + e.getMessage());
        }
        return null; // Return null if there's an error
    }

    public int jump(int[] nums) {

        DirectedGraph graph = new DirectedGraph();

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

        // graph.printGraph();
        return graph.bfsShortestPath(0, nums.length - 1);
    }

}

class DirectedGraph {
    private Map<Integer, List<Integer>> adjList; // adjacency list

    // Constructor to initialize the graph
    public DirectedGraph() {
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

    // Breadth-First Search to find the shortest path length between two nodes
    public int bfsShortestPath(int start, int target) {
        // Edge case: if start and target are the same
        if (start == target) {
            return 0;
        }

        // Queue for BFS storing pairs of (node, current distance)
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { start, 0 });

        // Set to track visited nodes
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] nodeInfo = queue.poll();
            int currentNode = nodeInfo[0];
            int currentDistance = nodeInfo[1];

            // Explore all neighbors
            for (int neighbor : adjList.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    // If we find the target node, return the distance
                    if (neighbor == target) {
                        return currentDistance + 1;
                    }

                    // Mark the neighbor as visited and add it to the queue
                    visited.add(neighbor);
                    queue.add(new int[] { neighbor, currentDistance + 1 });
                }
            }
        }

        // If no path is found, return -1
        return -1;
    }
}