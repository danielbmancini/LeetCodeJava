import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : nums)
            list.add(i);

        return TreeBuilder.sortedArrayToBST(list);
    }
}
