public class LeetCode55 { //Jump Game

/*
 * Você recebe um array inteiro nums. Você é inicialmente posicionado no primeiro índice do array, e cada elemento no array representa seu comprimento máximo de salto naquela posição.

Retorne true se você puder atingir o último índice, ou false caso contrário.
 */
    boolean reachable = false;

    public static void main(String[] args) {
        LeetCode55 leetCode55 = new LeetCode55();

        System.out.println(leetCode55.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {

        int gasoline = nums[0];

        for (int i = 1; i < nums.length; i++) {
            gasoline += nums[i];
            if(--gasoline == 0)
                return false;

        }
        return true;

    }

}
