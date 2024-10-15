import java.util.Arrays;
import java.util.Random;

class LeetCode33 {

    Random random = new Random();

    public static void main(String[] args) {
        LeetCode33 leetCode33 = new LeetCode33();

        System.out.println(Arrays.toString(leetCode33.searchNormal(new int[] {0,0,0,0,1,2,3,3,4,5,6,6,7,8,8,8,9,9,10,10,11,11}, 0)));
    }

    public int[] searchRange(int[] nums, int target) {

        
        
        if (nums.length < 5)
            return searchNormal(nums, target);

        int low = nums.length;
        int max = -1;

        for (int i = 0; i < 10*target + 100; i++) {
            int searched = uncertainBinarySearch(nums, target, 0, nums.length);
            if (searched <= low)
                low = searched;
            if (searched >= max)
                max = searched;
        }

        return new int[] { low == nums.length ? -1 : low, max };
    }

    public int uncertainBinarySearch(int[] arr, int target, int from, int to) {

        while (from <= to) {
            int mid = -1;
            while (mid >= arr.length || mid < 0) {
                mid = getRandomSign() * random.nextInt(3) + from + (to - from) / 2;
            }
            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                from = mid + 1;
            else if (mid != 0)
                to = mid - 1;
        }
        return -1; // target not found
    }

    public int getRandomSign() {
        return random.nextBoolean() ? 1 : -1;
    }

    public int[] searchNormal(int[] nums, int target) {
        int[] numbers = new int[2];
        numbers[0] = -1;
        numbers[1] = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && numbers[0] == -1)
                numbers[0] = i;
            if (nums[i] == target && numbers[0] != -1) {
                numbers[1] = i;
                // break;
            }
        }
        // numbers[1] = numbers[0] != -1 && numbers[1] == -1 ? numbers[0] : -1;
        return numbers;
    }
}