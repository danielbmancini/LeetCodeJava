import java.util.Arrays;
public class LeetCode217 {
    /*Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

     */
    public static boolean containsDuplicate(int[] nums) {
        return
                Arrays.stream(nums).distinct().count() != nums.length;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,2,3}));
    }
}
