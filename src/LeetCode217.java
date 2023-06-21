import java.util.Arrays;
public class LeetCode217 {
    public static boolean containsDuplicate(int[] nums) {
        return
                Arrays.stream(nums).distinct().count() != nums.length;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,2,3}));
    }
}
