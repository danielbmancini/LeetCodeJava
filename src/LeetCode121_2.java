public class LeetCode121_2 { //Best Time to Buy and Sell Stock
/*Você recebe uma matriz de preços onde preços[i] é o preço de uma ação dada no i-ésimo dia.

Você quer maximizar seu lucro escolhendo um único dia para comprar uma ação e escolhendo um dia diferente no futuro para vender essa ação.

Retorne o lucro máximo que você pode obter com essa transação. Se você não conseguir obter nenhum lucro, retorne 0. */
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
