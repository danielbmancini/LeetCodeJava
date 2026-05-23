
public class LeetCode1791 {
    /*
    Há um grafo estrela não direcionado com n nós numerados de 1 a n. Um grafo estrela é um grafo com um nó central e exatamente n - 1 arestas que conectam o nó central a todos os outros nós.

Dado um vetor bidimensional de inteiros `edges`, onde cada `edges[i] = [ui, vi]` indica que existe uma aresta entre os nós `ui` e `vi`, retorne o centro do grafo estrela.
    */
    public static int findCenter(int[][] edges) { //começando de qualquer nodo, é garantido que o nodo central estará conectado a ele, limitando a pesquisa ao numero de vizinhos de vizinhos do nodo inicial.
        int n = 2 * edges.length;
        System.out.println("n = " + n);
        Graph2 graph = new Graph2(n,edges);

        int start = edges[0][0];
        int[] neighbors = graph.neighbors(start);
        if (neighbors.length == edges.length)
            return start;

        for (int neighbor : neighbors){
            System.out.println(neighbor);
            if (graph.neighbors(neighbor).length == edges.length){
                return neighbor;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{4,2}};
        System.out.println(findCenter(edges));
    }
}
