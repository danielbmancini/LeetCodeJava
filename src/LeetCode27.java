import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode27 {
    /*Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.*/
    public static int removeElement(int[] nums, int val) {
        int count = 0;

        for (int i = 0; i < nums.length; i++)
            if(nums[i] == val){
                nums[i] = 101;
                count++;
        }
        System.out.println(Arrays.toString(nums));
        ArrayList<Integer> pointers = new ArrayList<>();
        for (int num : nums) {
            if (num != 101)
                pointers.add(num);
        }

        int size = nums.length - count;
        for (int i = 0; i < size; i++)
            nums[i] = pointers.get(i);
        System.out.println(Arrays.toString(nums));


        return size;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[] {3,2,2,3},3));
    }
}
