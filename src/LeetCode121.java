import java.util.ArrayList;

public class LeetCode121 {
    public static void main(String[] args) { // problema 121, Best Time to Buy and Sell Stock
        /*Você recebe uma matriz de preços onde preços[i] é o preço de uma ação dada no i-ésimo dia.

Você quer maximizar seu lucro escolhendo um único dia para comprar uma ação e escolhendo um dia diferente no futuro para vender essa ação.

Retorne o lucro máximo que você pode obter com essa transação. Se você não conseguir obter nenhum lucro, retorne 0. */
        LeetCode121 leetCode121 = new LeetCode121();

        System.out.println(leetCode121.maxProfit(new int[]{4, 2, 1, 7, 3, 5}));
    }

    public int maxProfit(int[] prices) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        int maxDiff = 0;

        for (int num : prices)
            arrayList.add(num);

        for (int i = 0; i < arrayList.size() - 1; i++) {
            int[] elems = max(arrayList, i);
            int diff = elems[0] - arrayList.get(i);
            if (diff > maxDiff) {
                maxDiff = diff;

            }

        }
        return maxDiff;
    }

    public int[] max(ArrayList<Integer> list, int k) {

        int max = list.get(k + 1);
        int index = 0;
        for (int i = k + 2; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }
        return new int[]{max, index};
    }
}
