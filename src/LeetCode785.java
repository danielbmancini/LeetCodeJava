import java.util.HashMap;
import java.util.Objects;

public class LeetCode785 {

    /*
    Há um grafo não direcionado com n nós, onde cada nó é numerado entre 0 e n - 1. Dado um grafo bidimensional, onde graph[u] é um array de nós adjacentes a u. Mais formalmente, para cada v em graph[u], existe uma aresta não direcionada entre o nó u e o nó v. O grafo possui as seguintes propriedades:

Não existem arestas que se conectam a si mesmas (graph[u] não contém u).

Não existem arestas paralelas (graph[u] não contém valores duplicados).

Se v pertence a graph[u], então u pertence a graph[v] (o grafo é não direcionado).

O grafo pode não ser conexo, ou seja, pode haver dois nós u e v que não possuem caminho entre si.

Um grafo é bipartido se os nós puderem ser divididos em dois conjuntos independentes A e B, de forma que cada aresta no grafo conecte um nó do conjunto A a um nó do conjunto B.

Retorne verdadeiro se e somente se o grafo for bipartido. */
    public static boolean isBipartite(int[][] graph) {
        Graph thisGraph = new Graph(graph);


        HashMap<Integer, Integer> map = new HashMap<>(); //Partições: 0 e 1, função 'grupo oposto' = 1 - map.get()
        boolean[] visited = new boolean[graph.length];
        boolean bipartite = true;
        for (int n = 0; n < graph.length; n++) {
            if (!visited[n])
                map.put(n, 0);
            bipartite = thisGraph.dfsFrom(n, visited, node -> {
                for (int neighbor : thisGraph.neighbors(node)) {
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, 1 - map.get(node));
                    } else if (Objects.equals(map.get(neighbor), map.get(node))) //Condição de falsificação: nodo adjacente está na mesma partição
                        return false;

                }
                return true;
            });
            if (!bipartite)
                return false;
        }
        return bipartite;
    }

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
    }
}
