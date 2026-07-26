import java.util.ArrayList;
import java.util.List;

public class LeetCode145 {
    /*
    Dada a raiz de uma árvore binária, retorne a travessia pós-ordem dos valores de seus nós.
     */
    ArrayList<Integer> treeWalk = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return treeWalk;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        treeWalk.add(root.val);
        return treeWalk;
    }

    public static void main(String[] args) {
        LeetCode145 leetCode145 = new LeetCode145();

        System.out.println(leetCode145.postorderTraversal(TreeBuilder.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9})));
    }
}
