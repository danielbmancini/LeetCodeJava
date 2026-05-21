import java.util.*;

class Graph {
    private final int n;
    private final int[][] adj;

    public Graph(int n, int[][] edges) {
        this.n = n;

        int[] degree = new int[n];

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        adj = new int[n][];

        for (int i = 0; i < n; i++) {
            adj[i] = new int[degree[i]];
        }

        int[] index = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u][index[u]++] = v;
            adj[v][index[v]++] = u;
        }
    }

    public int size() {
        return n;
    }

    public int[] neighbors(int node) {
        return adj[node];
    }

    public List<Integer> bfs(int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return order;
    }

    public List<Integer> dfs(int start) {
        boolean[] visited = new boolean[n];
        List<Integer> order = new ArrayList<>();

        dfsHelper(start, visited, order);

        return order;
    }

    private void dfsHelper(int node, boolean[] visited, List<Integer> order) {
        visited[node] = true;
        order.add(node);

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, order);
            }
        }
    }

    public List<Integer> bfs(int start, int destination) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            if (node == destination) {
                return order;
            }

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return order;
    }

    public List<Integer> dfs(int start, int destination) {
        boolean[] visited = new boolean[n];
        List<Integer> order = new ArrayList<>();

        dfsHelperWithDestination(start, destination, visited, order);

        return order;
    }

    private boolean dfsHelperWithDestination(int node, int destination, boolean[] visited, List<Integer> order) {
        visited[node] = true;
        order.add(node);

        if (node == destination) {
            return true;
        }

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if (dfsHelperWithDestination(neighbor, destination, visited, order)) {
                    return true;
                }
            }
        }

        return false;
    }
}