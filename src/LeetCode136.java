import java.util.*;

public class LeetCode136 {
    /*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.*/
    private int seed = (int) System.nanoTime();


    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums)
            result ^= num;

        return result;

    }


    public int singleNumberSpace(int[] nums) { //espaço linear
        // Rode n amostragens de tamanho k, identificar o elemento que menos aparece
        int n = 100*nums.length + 50;
        int k = 100;

        ArrayList<Integer> leastFrequents = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> amostras = new ArrayList<>();

            for (int j = 0; j < k; j++)
                amostras.add(nums[nextPseudoRandom(nums.length)]);

            leastFrequents.add(getLeastFrequent(amostras));
        }

        return getMostFrequent(leastFrequents);

    }

    private int nextPseudoRandom(int bound) {
        seed = seed * 1103515245 + 12345;
        return (seed >>> 1) % bound;
    }

    //genérico
    public int getLeastFrequent(List<Integer> list) {

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer item : list) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        Map.Entry<Integer, Integer> minEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (minEntry == null || entry.getValue() < minEntry.getValue()) {
                minEntry = entry;
            }
        }

        return minEntry.getKey();
    }

    //genérico
    public int getMostFrequent(List<Integer> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer item : list) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

    public static void main(String[] args) {
        LeetCode136 leetCode136 = new LeetCode136();

        System.out.println(leetCode136.singleNumberSpace(new int[]{-336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, -336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, 354})); //354
    }

}
