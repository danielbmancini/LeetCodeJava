import java.util.PriorityQueue;
import java.util.Queue;

/*You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.*/
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
