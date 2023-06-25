import java.util.Arrays;
import java.util.HashMap;

public class LeetCode347 {
    /*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.*/
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            if (!hashMap.containsKey(i))
                hashMap.put(i, 1);
            else {
                int v = hashMap.get(i);
                hashMap.replace(i, v + 1);
            }
        }


        int[] v = new int[k];
        int i = k;
        while (i != 0) {
            int max = 0;
            int key2 = -1;
            for (int key : hashMap.keySet()) {
                int j = hashMap.get(key);
                if (j > max) {
                    max = j;
                    key2 = key;
                }
            }
            v[k - i--] = key2;
            hashMap.remove(key2);

        }
        return v;

    }

    public static void main(String[] args) {
        System.out.printf(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
