import java.util.ArrayList;
import java.util.List;

public class LeetCode119 {
    /*
    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
     */
    public List<Integer> getRow(int rowIndex) { //complexidade de tempo e espaço: O(rowIndex)
        List<Integer> row = new ArrayList<>();

        long current = 1;

        for (int k = 0; k <= rowIndex; k++) { // row.get(k) = C(rowIndex, k)
            row.add((int) current);
            current = current * (rowIndex - k) / (k + 1); // C(rowIndex, k + 1) = C(rowIndex, k) * (rowIndex - k) / (k + 1)
        }
        return row;
    }
}
