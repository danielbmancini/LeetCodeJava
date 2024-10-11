public class LeetCode55 {
    boolean reachable = false;

    public static void main(String[] args) {
        LeetCode55 leetCode55 = new LeetCode55();

        System.out.println(leetCode55.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {

        int gasoline = nums[0];

        for (int i = 1; i < nums.length; i++) {
            gasoline += nums[i];
            if(--gasoline == 0)
                return false;

        }
        return true;

    }

}
