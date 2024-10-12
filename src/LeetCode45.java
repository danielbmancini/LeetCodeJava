import java.util.*;

/*
 * Jump Game II
 * Fiz várias soluções pra esse, explorando teoria dos grafos, que percebi que se aplica à esse problemas.
 * Você recebe um array indexado em 0 de inteiros nums de comprimento n. Você é inicialmente posicionado em nums[0].

Cada elemento nums[i] representa o comprimento máximo de um salto para frente do índice i. Em outras palavras, se você estiver em nums[i], você pode pular para qualquer nums[i + j] onde:

0 <= j <= nums[i] e
i + j < n

Retorna o número mínimo de saltos para atingir nums[n - 1]. Os casos de teste são gerados de forma que você possa atingir nums[n - 1].
 */


public class LeetCode45 { //solução com teoria dos grafos
    public static void main(String[] args) {
        LeetCode45 leetCode45 = new LeetCode45();

        System.out.println(leetCode45.jump(new int[]{1, 2, 3}));
    }

    public int jump(int[] nums) {


        Graph graph = new Graph();

        for (int i = 0; i < nums.length; i++)
            graph.addNode(i);

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
        return graph.dfsShortestEdges(0, nums.length - 1);
    }


}

class Graph {
    private HashMap<Integer, ArrayList<Integer>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    // Add a node to the graph
    public void addNode(int node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    // Add an edge between two nodes (undirected)
    public void addEdge(int node1, int node2) {
        adjList.get(node1).add(node2);
        adjList.get(node2).add(node1);
    }

    // DFS to find the shortest number of edges between two nodes
    public int dfsShortestEdges(int start, int goal) {
        Set<Integer> visited = new HashSet<>();
        int length = 10000;
        return dfsHelper(start, goal, visited, 0, length);
    }

    // Helper method for DFS to count the shortest number of edges
    private int dfsHelper(int current, int goal, Set<Integer> visited, int currentDepth, int shortestDepth) {
        if (current == goal) {
            return Math.min(shortestDepth, currentDepth);
        }

        visited.add(current);

        for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                int result = dfsHelper(neighbor, goal, visited, currentDepth + 1, shortestDepth);
                shortestDepth = Math.min(shortestDepth, result);
            }
        }

        visited.remove(current); // Backtrack
        return shortestDepth;
    }

    public void printGraph() {
        System.out.println("GraphHeuristic Representation:");
        for (int node : adjList.keySet()) {
            System.out.print(node + " --> ");
            List<Integer> edges = adjList.get(node);
            System.out.println(edges);
        }
    }
}
