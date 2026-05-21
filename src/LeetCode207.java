public class LeetCode207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
         * Você precisa cursar um total de numCourses cursos, numerados de 0 a
         * numCourses - 1. É fornecido um array de pré-requisitos onde preschools[i] =
         * [ai, bi] indica que você precisa cursar o curso bi primeiro para poder cursar
         * o curso ai.
         * 
         * Por exemplo, o par [0, 1] indica que para cursar o curso 0 você precisa
         * primeiro cursar o curso 1.
         * 
         * Retorne true se você conseguir concluir todos os cursos. Caso contrário,
         * retorne false.
         */

        DirectedGraph directedGraph = new DirectedGraph(numCourses, prerequisites);

        return !directedGraph.hasCycle(); //Não tem ciclo 
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] graph = {{1,0},{2,0},{3,1},{4,2},{5,3},{5,4}};

        System.out.println(canFinish(n, graph));
    }
}
