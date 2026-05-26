import java.util.Arrays;

public class LeetCode16 {
    /*
    Dado um vetor de inteiros `nums` de comprimento `n` e um inteiro `target`, encontre três inteiros em índices distintos de `nums` cuja soma seja a mais próxima possível de `target`.

Retorne a soma dos três inteiros.

Você pode assumir que cada entrada terá exatamente uma solução.
     */
    public static int threeSumClosest(int[] nums, int target) {
        /*
        Impose order.

Choose one fixed element.

Use the remaining ordered region as a shrinking search window.

At each window state:
    evaluate the candidate triple
    remember it if it is the best approximation so far
    discard the boundary that can only move the sum in the wrong direction

Stop when every meaningful window state has been considered,
or when the target is hit exactly.
         */

        Arrays.sort(nums);
        int candidate = nums[0] + nums[1] + nums[2];

        int lo = 1;
        int hi = nums.length - 1;
        int anchor = 0;
        while (anchor < nums.length - 2) {
            int current = nums[anchor] + nums[lo] + nums[hi];
            int diff = current - target;
            candidate = Math.abs(diff) < Math.abs(candidate - target) ? current : candidate;

            if (diff == 0)
                return candidate;
            else if (diff < 0)
                lo++;
            else
                hi--;

            // current anchor's search window is exhausted
            if (lo >= hi) {
                anchor++;
                lo = anchor + 1;
                hi = nums.length - 1;
            }

        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(threeSumClosest(nums,-2));
    }
}
