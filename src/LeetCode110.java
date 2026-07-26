public class LeetCode110 {
    /*
    Dada uma árvore binária, determine se ela é height-balanced.
     */
    /*
     * Height-Or-Unbalanced(node)
     * 1  if node == NIL
     * 2      return 0
     * 3  left-height ← Height-Or-Unbalanced(node.left)
     * 4  if left-height == −1
     * 5      return −1
     * 6  right-height ← Height-Or-Unbalanced(node.right)
     * 7  if right-height == −1
     * 8      return −1
     * 9  if |left-height − right-height| > 1
     * 10     return −1
     * 11 return max(left-height, right-height) + 1
     */
    public boolean isBalanced(TreeNode root) {
        return heightOrUnbalanced(root) != -1;
    }

    private int heightOrUnbalanced(TreeNode node){
        if (node == null)
            return 0;

        int left = heightOrUnbalanced(node.left);

        if (left == -1)
            return -1;
        int right = heightOrUnbalanced(node.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(right,left) + 1;
    }
}
