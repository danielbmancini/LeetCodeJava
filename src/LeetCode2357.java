import java.util.Arrays;

public class LeetCode2357 { //brute-force, HORRÍVEL!!

    public int minimumOperations(int[] nums) {
        int count = 0;
        nums = Arrays.stream(nums).sorted().distinct().toArray();

        System.out.println(Arrays.toString(nums));
        int i = 0;

        if (nums.length == 1)
            return nums[0] > 0 ? 1 : 0;

        int j = 0;
        while (j != nums.length)
            if (nums[j] > 0) {
                i = j;
                break;
            }else
                j++;

        while (nums[nums.length - 1] != 0) {

            count = sub(nums, nums[i],count);
            i++;
            System.out.println(Arrays.toString(nums));
        }

        return count;
    }

    public int sub(int[] nums, int least, int count) {
        for (int k = 0; k < nums.length; k++)
            nums[k] = nums[k] < least ? 0 : nums[k] - least;
        return count + 1;

    }

    public static void main(String[] args) {
        LeetCode2357 leetCode2357 = new LeetCode2357();

        System.out.println(leetCode2357.minimumOperations(new int[]{1,5,0,3,5}));
    }
}
