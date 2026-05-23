import java.util.Random;

public class LeetCode997 {
    /*
    Em uma cidade, existem n pessoas numeradas de 1 a n. Corre o boato de que uma dessas pessoas é secretamente o juiz da cidade.

Se o juiz da cidade existe, então:

O juiz da cidade não confia em ninguém.

Todos (exceto o juiz da cidade) confiam no juiz da cidade.

Existe exatamente uma pessoa que satisfaz as propriedades 1 e 2.

Dado um array `trust`, onde `trust[i] = [ai, bi]` representa que a pessoa numerada como `ai` confia na pessoa numerada como `bi`. Se uma relação de confiança não existir no array `trust`, então tal relação de confiança não existe.

Retorne o rótulo do juiz da cidade se ele existir e puder ser identificado, ou retorne -1 caso contrário.
     */
    public int findJudge(int n, int[][] trust) {
        DirectedGraph graph = new DirectedGraph(n, trust, true);
        Random random = new Random();
        int judgeCandidate = random.nextInt(n);

        for (int i = 0; i < 4 * n; i++) {
            /* Se existir um juiz, cada tentativa aleatória tem probabilidade 1/n
de escolher o juiz.

Depois de multiplier * n tentativas aleatórias independentes,
 a probabilidade de NÃO escolher o juiz nenhuma vez é:
   (1 - 1.0 / n)^(k * n)

 Para valores grandes de n, isso é aproximadamente:

    e^(-k)
*/
            if (graph.inDegree(judgeCandidate) == n - 1 && graph.outDegree(judgeCandidate) == 0)
                return judgeCandidate + 1; //indexação 0 -> indexação 0

            judgeCandidate = random.nextInt(n);

        }


        return -1;

    }
}
