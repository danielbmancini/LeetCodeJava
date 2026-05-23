import java.util.Arrays;

public class LeetCode210 {
    /*
     * Há um total de numCourses cursos que você precisa fazer, numerados de 0 a
     * numCourses - 1. Você recebe um array de pré-requisitos onde preschools[i] =
     * [ai, bi] indica que você deve fazer o curso bi primeiro para poder fazer o
     * curso ai.
     * 
     * Por exemplo, o par [0, 1] indica que para fazer o curso 0 você precisa
     * primeiro fazer o curso 1.
     * 
     * Retorne a ordem dos cursos que você deve fazer para concluir todos os cursos.
     * Se houver várias respostas válidas, retorne qualquer uma delas. Se for
     * impossível concluir todos os cursos, retorne um array vazio.
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1)
            return new int[] { 0 };

        DirectedGraph3 graph = new DirectedGraph3(numCourses, prerequisites);

        if (graph.hasCycle())
            return new int[] {};
        else
            return graph.topologicalSort().reversed().stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}
