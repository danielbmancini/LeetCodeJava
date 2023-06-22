import java.util.Arrays;

public class LeetCode238 {
    public static int[] productExceptSelf(int[] nums) {
        //Complexity O(n) but doesn't follow problem's instruction
        int[] newNums = new int[nums.length];

        int product = 1;

        for (int k : nums)
            product *= k;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                newNums[i] = product / nums[i];
            else
                newNums[i] = recalculate(nums, i);
        }
        return newNums;
    }

    private static int recalculate(int[] nums, int index) {
        int v = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == index)
                continue;
            v *= nums[i];
        }
        return v;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
