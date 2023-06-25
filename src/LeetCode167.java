import java.util.Arrays;

public class LeetCode167 {
    /*Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

*/
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


