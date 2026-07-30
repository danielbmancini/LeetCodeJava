public class LeetCode398 {
    /*
    Dado um array de inteiros `nums` com possíveis duplicatas, retorne aleatoriamente o índice de um número alvo fornecido. Você pode assumir que o número alvo fornecido deve existir no array.

Implemente a classe `Solution`:

`Solution(int[] nums)` Inicializa o objeto com o array `nums`.

`int pick(int target)` Seleciona um índice aleatório `i` de `nums` onde `nums[i] == target`. Se houver múltiplos valores válidos para `i`, cada índice deve ter a mesma probabilidade de ser retornado.
     */

    private int[] nums;
    private long seed;
    //reservoir sampling (apropriado) e monte carlo (aproximação arbitraria)
    public LeetCode398 (int[] nums) {
        this.nums = nums;
        this.seed = System.nanoTime();
    }

    public int pick(int target) {
        int count = 0;
        int chosen = -1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                count++;
                if (nextInt(count) == 0)
                    chosen = i; //no final, escolhe com probabilidade exatamente 1/n entre as n duplicatas
            }
        }

        return chosen;
    }

    // lcg X ← (a·X + c) mod 2³²
    private int nextInt(int bound) {
        seed = (seed * 1664525L + 1013904223L) & 0xFFFFFFFFL;
        return (int) ((seed * (long) bound) >>> 32);   // high bits → [0, bound)
    }

    public int pickMonteCarlo(int target){
        int hitsKounter = 0;
        int length = nums.length;
        int chosen = -1;
        while (hitsKounter < 38000){ //99.9% de confiança que a probabilidade é proxima de 1/n, |p - 1/n| <= 0.01 por desigualdade de Hoeffding
            int index = nextInt(length);
            if (nums[index] == target){
                hitsKounter++;
                chosen = index;
            }
        }
        return chosen;
    }

    public static void main(String[] args) {

    }
}
