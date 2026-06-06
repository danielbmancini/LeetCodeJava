
public class LeetCode81 {
    /*
    Existe um array de inteiros `nums` ordenado em ordem não decrescente (não necessariamente com valores distintos).

Antes de ser passado para a sua função, `nums` é rotacionado em um índice de pivô desconhecido `k` (0 <= k < `nums.length`) de forma que o array resultante seja `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (indexado a partir de 0). Por exemplo, `[0,1,2,4,4,4,5,6,6,7]` pode ser rotacionado no índice de pivô 5 e se tornar `[4,5,6,6,7,0,1,2,4,4]`.

Dado o array `nums` após a rotação e um inteiro `target`, retorne `true` se `target` estiver em `nums`, ou `false` caso contrário.

Você deve reduzir o número total de etapas da operação o máximo possível.
     */

    private int seed;

    public boolean search(int[] nums, int target) { //100% tempo, 78.07% memória.
        if (nums.length == 0)
            return false;
        if (nums.length <= 3)
            return linearSearch(nums, target, 0, nums.length - 1);
        /*
        Princípio probabilístico semelhante ao 33
        Dado 0 <= i < j < nums.length, existe uma subsequência monotônica a[i], a[i+1] .. ,a[j].

        1. Com n empírico e n tentativas randomizadas, encontre (i,j), com a[i] <= target <= a[j] minimizando k - i.
        2. Rode e retorne o resultado de pesquisa na subsequência a[i] .. a[j].
         */

        int i = 0;
        int j = nums.length - 1;
        int distance = 2 * 10000 + 1; //por constraint
        int n = Math.min(5, nums.length);

        for (int k = 0; k < n; k++) {
            int i1 = nextPseudoRandom(nums.length);
            int j1 = i1 + nextPseudoRandom(nums.length - i1);

            if (nums[i1] <= target && nums[j1] >= target && j1 - i1 < distance) {
                i = i1;
                j = j1;
                distance = j1 - i1;
            }
        }
        return linearSearch(nums, target, i, j);
    }

    private boolean linearSearch(int[] nums, int target, int from, int to) {

        for (int i = from; i <= to; i++)
            if (nums[i] == target)
                return true;

        return false;
    }

    //gerador congruente linear
    private int nextPseudoRandom(int bound) {
        seed = seed * 1103515245 + 12345;
        return (seed >>> 1) % bound;
    }

    public static void main(String[] args) {
        LeetCode81 leetCode81 = new LeetCode81();

        System.out.println(leetCode81.search(new int[]{2, 0, 1, 1, 1}, 2)); // true
        System.out.println(leetCode81.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0)); // true
        System.out.println(leetCode81.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3)); // false
        System.out.println(leetCode81.search(new int[]{1, 3, 1, 1, 1}, 3)); // true
    }
}