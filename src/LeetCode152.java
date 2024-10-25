import java.util.ArrayList;
import java.util.Collections;

public class LeetCode152 {
    public int maxProduct(int[] nums) {
        ArrayList<Integer> negatives = new ArrayList<>(nums.length / 2);
        int negativeProduct = 1;
        int bestProduct = 1;

        int currentProduct = 1;

        for (int x : nums) {
            if (x < 0) {
                negativeProduct *= x;
                continue;
            } else {
                negativeProduct = 1;
            }

            currentProduct = Math.max(x, currentProduct * x);
            bestProduct = Math.max(currentProduct, bestProduct);
        }
        
        if (nums[nums.length - 1] < 0)
            negatives.add(negativeProduct);
        int max = bestProduct;
        if (negatives.size() > 0) {
            max = negatives.get(0);
            for (int i = 1; i < negatives.size(); i++) {
                if (negatives.get(i) > max) {
                    max = negatives.get(i);
                }
            }
        }
        return bestProduct >= max ? bestProduct : max;
    }

    public static void main(String[] args) {
        LeetCode152 leetCode152 = new LeetCode152();
        System.out.println(leetCode152.maxProduct(new int[] { -3, -1, -1 }));
    }
}
