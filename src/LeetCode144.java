import java.util.*;
/*
Dada a raiz de uma árvore binária, retorne a travessia em pré-ordem dos valores de seus nós.
 */

public class LeetCode144 {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return list;

        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return list;
    }

    public static void main(String[] args) {
        LeetCode144 leetCode144 = new LeetCode144();
        System.out.println(leetCode144.preorderTraversal(TreeBuilder.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9})));

    }
}
