public class LeetCode1971 {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        /*
         * Há um grafo bidirecional com n vértices, onde cada vértice é numerado de 0 a
         * n - 1 (inclusive). As arestas do grafo são representadas por um vetor
         * bidimensional de inteiros, onde cada aresta[i] = [ui, vi] denota uma aresta
         * bidirecional entre o vértice ui e o vértice vi. Cada par de vértices é
         * conectado por no máximo uma aresta, e nenhum vértice possui uma aresta para
         * si mesmo.
         * 
         * Deseja-se determinar se existe um caminho válido do vértice de origem ao
         * vértice de destino.
         * 
         * Dados os valores das arestas e os inteiros n, origem e destino, retorne
         * verdadeiro se houver um caminho válido de origem para destino, ou falso caso
         * contrário.
         */
        Graph graph = new Graph(n, edges);

        return graph.dfs(source, destination).contains(destination);

    }

    public static void main(String[] args) {
        System.out.println(validPath(6, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 } }, 0, 5));
    }
}
