import java.util.*;

public class DirectedGraph {
    private final int n;
    private final List<List<Integer>> adj;

    public DirectedGraph(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of nodes cannot be negative");
        }

        this.n = n;
        this.adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public DirectedGraph(int n, int[][] edges) {
        this.n = n;;
        this.adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            if (edge.length != 2) {
                throw new IllegalArgumentException("Each edge must have exactly two values");
            }

            addEdge(edge[0], edge[1]);
        }
    }

    public int size() {
        return n;
    }

    public void addEdge(int from, int to) {
        validateNode(from);
        validateNode(to);

        adj.get(from).add(to);
    }

    public void removeEdge(int from, int to) {
        validateNode(from);
        validateNode(to);

        adj.get(from).remove(Integer.valueOf(to));
    }

    public boolean hasEdge(int from, int to) {
        validateNode(from);
        validateNode(to);

        return adj.get(from).contains(to);
    }

    public List<Integer> getNeighbors(int node) {
        validateNode(node);

        return new ArrayList<>(adj.get(node));
    }

    public int outDegree(int node) {
        validateNode(node);

        return adj.get(node).size();
    }

    public int inDegree(int node) {
        validateNode(node);

        int count = 0;

        for (int from = 0; from < n; from++) {
            for (int to : adj.get(from)) {
                if (to == node) {
                    count++;
                }
            }
        }

        return count;
    }

    public List<Integer> bfs(int start) {
        validateNode(start);

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }

    public List<Integer> dfs(int start) {
        validateNode(start);

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];

        dfsHelper(start, visited, result);

        return result;
    }

    private void dfsHelper(int node, boolean[] visited, List<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, result);
            }
        }
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                if (hasCycleHelper(node, visited, inStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasCycleHelper(int node, boolean[] visited, boolean[] inStack) {
        visited[node] = true;
        inStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycleHelper(neighbor, visited, inStack)) {
                    return true;
                }
            } else if (inStack[neighbor]) {
                return true;
            }
        }

        inStack[node] = false;
        return false;
    }

    public List<Integer> topologicalSort() {
        if (hasCycle()) {
            throw new IllegalStateException("Graph contains a cycle; topological sort is not possible");
        }

        int[] indegree = new int[n];

        for (int from = 0; from < n; from++) {
            for (int to : adj.get(from)) {
                indegree[to]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int node = 0; node < n; node++) {
            if (indegree[node] == 0) {
                queue.offer(node);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }

    public int[][] toEdgeList() {
        List<int[]> edges = new ArrayList<>();

        for (int from = 0; from < n; from++) {
            for (int to : adj.get(from)) {
                edges.add(new int[]{from, to});
            }
        }

        return edges.toArray(new int[edges.size()][]);
    }

    public void printGraph() {
        for (int node = 0; node < n; node++) {
            System.out.println(node + " -> " + adj.get(node));
        }
    }

    private void validateNode(int node) {
        if (node < 0 || node >= n) {
            throw new IllegalArgumentException("Invalid node: " + node);
        }
    }
}
