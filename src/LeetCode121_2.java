public class LeetCode121_2 {

    public static void main(String[] args) {
        LeetCode121 leetCode121 = new LeetCode121();
        System.out.println(leetCode121.maxProfit(new int[]{2, 2, 3, 4, 6}));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int least = prices[0];

        for (int num : prices){
            if (num < least)
                least = num;

            int thisProfit = num - least;
            if (thisProfit > profit)
                profit = thisProfit;

        }

        return profit;
    }
}
