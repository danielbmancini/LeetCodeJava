import java.util.Arrays;

public class LeetCode80 {
    public static void main(String[] args) {
        LeetCode80 leetCode80 = new LeetCode80();

        int k = leetCode80.removeDuplicates(new int[]{1, 1, 1, 2});
        System.out.println(k);
    }

    public int removeDuplicates(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + 10000;
        }

        int pointer = nums[0];
        int count = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pointer) {
                pointer = nums[i];
                count = 0;
            }
            if (++count > 2) {
                nums[i] = -1;
                n++;
            }
        }

        rearrange(nums);
        return nums.length - n;
    }

    public void rearrange(int[] nums) {
        int index = 0;
        for (int n = 0; n < nums.length; n++)
            if (nums[n] >= 0)
                nums[index++] = nums[n] - 10000;

        System.out.println(Arrays.toString(nums));
    }

}
