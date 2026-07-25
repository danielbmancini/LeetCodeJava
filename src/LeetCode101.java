public class LeetCode101 {
    /*
    Na raiz de uma árvore binária, verifique se ela é um espelho de si mesma (ou seja, simétrica em relação ao seu centro).
     */

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;

        return mirror(root.left, root.right);
    }

    public boolean mirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;

        return mirror(left.left, right.right) && mirror(left.right, right.left);

    }

    public static void main(String[] args) {
        LeetCode101 leetCode101 = new LeetCode101();

        System.out.println(leetCode101.isSymmetric(TreeBuilder.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
    }
}
