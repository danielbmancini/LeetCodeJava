import java.util.Arrays;

public class LeetCode167 {
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int search = Arrays.binarySearch(numbers,target - numbers[i]);
            if (i + 1 < numbers.length && search > -1 && numbers[i+1] != target - numbers[i])
                return new int[] {i + 1, search + 1};
            else if (i + 1 < numbers.length && numbers[i + 1] == target - numbers[i])
                return new int[] {i+1, i + 2};


            }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15},9)));
    }}


