import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode26 {
    /*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once*/
    public static int removeDuplicates(int[] nums) {
        //int[] nums1 = Arrays.copyOf(nums,nums.length);
        int pointer = -101;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pointer) {
                pointer = nums[i];
            } else
                nums[i] = 101;
        }

        ArrayList<Integer> pointers = new ArrayList<>();
        for (int num : nums) {
            if (num != 101)
                pointers.add(num);
        }

        int size = pointers.size();
        for (int i = 0; i < size; i++)
            nums[i] = pointers.get(i);

        System.out.println(Arrays.toString(nums));
        return size;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
