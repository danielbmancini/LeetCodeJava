public class LeetCode169_2 {
    public int majorityElement(int[] nums) {
        Integer majority = null;
        int freq = 0;

        for (int num : nums) {
            if (freq == 0)
                majority = num;
            if (majority.equals(num))
                freq += 1;
            else
                freq -= 1;

        }
        return majority; //não retorna null por garantia de existência do majority element
    }

    public static void main(String[] args) {
        LeetCode169_2 leetCode169_2 = new LeetCode169_2();

        System.out.println(leetCode169_2.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
