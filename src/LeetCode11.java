import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode11 {
    public static int maxArea(int[] height) { //correct but time limit bad
        Queue<Integer> records = new PriorityQueue<>() ;
        records.add(0);
        for (int i = 0; i < height.length; i++)
            for (int j = 0; j < height.length; j++){

                int minimum = Math.min(height[i],height[j]);
                double calculation;
               // if(!records.isEmpty())
                    calculation = records.peek() - (j-i + 1)*minimum;
                if( calculation < 0)
                records.add((j - i) * Math.min(height[i], height[j]));
                if(records.size() > 1)
                    records.poll();
            }


        return records.peek();

    }





    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
