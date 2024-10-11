import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LeetCode380 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    }

}

class RandomizedSet {

    public Hashtable<Integer, Integer> hashtable;
    public int index;
    public HashMap<Integer, Integer> map;

    public RandomizedSet() {

        hashtable = new Hashtable<>();
        map = new HashMap<>();
        index = 0;
    }

    public boolean insert(int val) {
        if (hashtable.containsValue(val))
            return false;
        if(map.containsValue(index))
            index = hashtable.size();
        hashtable.put(index, val);
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        try {
            hashtable.remove( map.get(val));
            index = map.remove(val);
            return true;
        } catch (NullPointerException e) {
            //System.err.println("err, val = " + val);
            return false;
        }
    }

    public int getRandom() {
     //   System.out.println(hashtable.values());
        Random random = new Random();
        int ind = random.nextInt(hashtable.values().size());
        return (int) hashtable.values().toArray()[ind];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */