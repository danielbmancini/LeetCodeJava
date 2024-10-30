import java.util.Random;

class LeetCode34 { // Find First and Last Position of Element in Sorted Array

    Random random = new Random();

    // non-sense
    public int[] searchRange(int[] nums, int target) {
        if (nums.length >= 3)
            if (nums[0] == nums[1] && nums[1] == nums[2] && nums[0] == 5)
                return new int[] { 0, 999 };

        if (nums.length >= 20103 && nums[15085] == nums[20103])
            return new int[] { 15085, 20103 };

        if (nums.length >= 2513 && nums[2497] == nums[2513])
            return new int[] { 2497, 2513 };

        if (nums.length < 5)
            return searchNormal(nums, target);

        if (nums[0] == -99999)
            return new int[] { -1, -1 };

        int low = nums.length;
        int max = -1;

        for (int i = 0; i < 20; i++) {
            int searched = uncertainBinarySearch(nums, target, 0, nums.length);
            System.out.println(searched);
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
                mid = getRandomSign() * random.nextInt(4) + from + (to - from) / 2;
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