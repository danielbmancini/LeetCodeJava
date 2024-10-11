import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class LeetCode45_4 { //solução com teoria dos grafos direcionados
    public static void main(String[] args) {
        LeetCode45_4 leetCode45_4 = new LeetCode45_4();
        List<Integer> ints = readCommaSeparatedInts("numeros");

        int[] ints2 = new int[ints.size()];
        int j = 0;
        for (Integer integer : ints){
            ints2[j++] = integer;
        }
        System.out.println(leetCode45_4.jump(ints2));
    }

    public int jump(int[] nums) {

        GraphHeuristic graph = new GraphHeuristic();
        graph.addEdge(nums.length - 1, nums.length -1,0);



        for (int i = 0; i < nums.length - 1; i++) {
            int j = i;
            while (j - i < Math.min(nums[i], nums.length - 1)) {
                try {
                    graph.addEdge(i, ++j,1 );
                } catch (NullPointerException e) {
                    break;
                }
            }
        }


      //  graph.printGraph();
        return graph.aStarShortestPath(0, nums.length - 1);
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


}

class GraphHeuristic {
    private Map<Integer, List<int[]>> adjList; // adjacency list storing (neighbor, weight) pairs

    // Constructor to initialize the graph
    public GraphHeuristic() {
        adjList = new HashMap<>();
    }

    // Method to add a directed edge with weight from source to destination
    public void addEdge(int src, int dest, int weight) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.get(src).add(new int[]{dest, weight});
    }

    // A* to find the shortest path length from start to target
    public int aStarShortestPath(int start, int target) {
        // Priority queue to store (node, f_score)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> gScore = new HashMap<>(); // Distance from start to node
        Set<Integer> visited = new HashSet<>(); // Track visited nodes

        pq.add(new int[]{start, 0}); // Start with the initial node
        gScore.put(start, 0);

        while (!pq.isEmpty()) {
            int[] nodeInfo = pq.poll();
            int currentNode = nodeInfo[0];

            // If we've reached the target node, return the gScore
            if (currentNode == target) {
                return gScore.get(currentNode);
            }

            // Skip already processed nodes
            if (visited.contains(currentNode)) {
                continue;
            }
            visited.add(currentNode);

            // Explore neighbors
            for (int[] neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                int neighborNode = neighbor[0];
                int edgeWeight = neighbor[1];

                // Calculate tentative gScore for this neighbor
                int tentativeGScore = gScore.get(currentNode) + edgeWeight;

                // If this path to the neighbor is shorter, update the gScore and priority queue
                if (tentativeGScore < gScore.getOrDefault(neighborNode, Integer.MAX_VALUE)) {
                    gScore.put(neighborNode, tentativeGScore);

                    // fScore = gScore + heuristic (distance to target)
                    int fScore = tentativeGScore + (target - neighborNode );
                    pq.add(new int[]{neighborNode, fScore});
                }
            }
        }

        // If there's no path (shouldn't happen since it's guaranteed)
        return -1; // Path not found
    }

    // Method to print the graph
    public void printGraph() {
        for (int node : adjList.keySet()) {
            System.out.print("Node " + node + " -> ");
            List<int[]> edges = adjList.get(node);

            if (edges != null && !edges.isEmpty()) {
                for (int[] edge : edges) {
                    System.out.print("(" + edge[0] + ", weight: " + edge[1] + ") ");
                }
            } else {
                System.out.print("No outgoing edges");
            }
            System.out.println(); // Move to the next line for the next node
        }
    }
}
