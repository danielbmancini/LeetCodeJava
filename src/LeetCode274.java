import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LeetCode274 {
    public static void main(String[] args) {
        LeetCode274 leetCode274 = new LeetCode274();

        System.out.println(leetCode274.hIndex(new int[]{3,0,6,1,5}));
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        HashMap<Integer,Integer> map = new HashMap<>();


        for (int i = citations.length - 1; i >= 0; i--) {

                map.put(i, citations.length - 1 - i  );


        }

        System.out.println(map.values());
      return citations[getMaxKey(map)];

    }

    public  int getMaxKey(HashMap<Integer, Integer> map) {
        HashMap.Entry<Integer, Integer> maxEntry = null;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();  // Return the key associated with the biggest value
    }
}

