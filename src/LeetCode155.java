import java.util.ArrayList;
import java.util.Comparator;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
public class LeetCode155 {
    ArrayList<Integer> arrayList;
    ArrayList<Integer> minimaList;
    public LeetCode155() {
        arrayList = new ArrayList<>();
        minimaList = new ArrayList<>();
    }

    public void push(int val) {
        arrayList.add(val);

        if(minimaList.isEmpty() || val <= minimaList.get(minimaList.size() - 1))
            minimaList.add(val);

    }

    public void pop() {
        int removed = arrayList.remove(arrayList.size() - 1);
        if( minimaList.contains(removed))
            minimaList.remove((Integer) removed);
    }


    public int top() {
        return arrayList.get(arrayList.size() - 1);
    }

    public int getMin() {
        if(!minimaList.isEmpty())
            return minimaList.get(minimaList.size() - 1);
        else
            return arrayList.get(0);
    }

    public static void main(String[] args) {
        LeetCode155 leetCode155 = new LeetCode155();

        leetCode155.push(1);
        leetCode155.push(2);
        System.out.println(leetCode155.top());
        System.out.println(leetCode155.getMin());
        leetCode155.pop();
        System.out.println(leetCode155.getMin());
        System.out.println(leetCode155.top());
    }
}
