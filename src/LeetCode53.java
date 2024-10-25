public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int bestSum = -nums.length * 10000;
        int currentSum = 0;

        for (int x : nums) {
            currentSum = Math.max(x, currentSum + x);
            bestSum = Math.max(currentSum, bestSum);
        }
        return bestSum;
    }

    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();
        System.out.println(leetCode53.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }
}
