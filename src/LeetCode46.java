import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode46 {
    /*
    Dado um array `nums` de inteiros distintos, retorne todos os valores possíveis de `nums`.
    Você pode retornar a resposta em qualquer ordem.
     */
/*
PERMUTE(A, start):
    if start == A.length:
        record a copy of A as one complete permutation
        return
    for i = start to A.length - 1:
        swap A[start] with A[i]
        PERMUTE(A, start + 1)
        swap A[start] with A[i]   // backtrack
 */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(nums,0,permutations);

        return permutations;
    }

    public void permute(int[] nums, int start, List<List<Integer>> permutations) {
        if (start == nums.length) {
            List<Integer> onePermutation = new ArrayList<>();
            for (int element : nums)
                onePermutation.add(element);

            permutations.add(onePermutation);
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(nums, start + 1, permutations);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
