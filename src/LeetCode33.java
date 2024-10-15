import java.util.*;
//Search in Rotated Sorted Array
public class LeetCode33 { //Melhor que 100% em termos de tempo! 
    /*
     * Há um array inteiro nums classificado em ordem crescente (com valores distintos).

Antes de ser passado para sua função, nums é possivelmente rotacionado em um índice de pivô desconhecido k (1 <= k < nums.length) de modo que o array resultante seja [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (indexado em 0). Por exemplo, [0,1,2,4,5,6,7] pode ser rotacionado no índice de pivô 3 e se tornar [4,5,6,7,0,1,2].

Dado o array nums após a possível rotação e um alvo inteiro, retorne o índice do alvo se estiver em nums, ou -1 se não estiver em nums.

Você deve escrever um algoritmo com complexidade de tempo de execução O(log n).
     */
    public int search(int[] nums, int target) {
        if (nums.length <= 3)
            return normalSearch(nums, target);

        if (nums[0] <= nums[nums.length - 1])
            return binarySearch(nums, target, 0, nums.length - 1);

        Random random = new Random();

        int big = nums.length - 1; // aqui teremos indice de numero maior
        int bigKounter = 0;
        while (nums[big] <= target) {
            if (nums[big] == target)
                return big;
            if (bigKounter++ == 4 * nums.length)
                return -1;
            big = random.nextInt(nums.length);

        }

        System.out.println("big = " + big);
        if (nums[big] == target)
            return big;

        int small = 0;
        int smallKounter = 0;
        while (nums[small] > target) {
            if (nums[small] == target)
                return small;
            if (smallKounter++ == 10 * big)
                return -1;
            small = random.nextInt(big);

        }

        System.out.println("small = " + small);
        if (nums[small] == target)
            return small;

        return binarySearch(nums, target, small, big);

    }

    public int normalSearch(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int[] arr, int target, int from, int to) {
        while (from <= to) {
            int mid = from + (to - from) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                from = mid + 1;
            else
                to = mid - 1;
        }
        return -1; // target not found
    }
}