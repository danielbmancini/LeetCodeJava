public class LeetCode404 {
    /*
    Dada a raiz de uma árvore binária, retorne a soma de todas as folhas à esquerda.

Uma folha é um nó sem filhos. Uma folha à esquerda é uma folha que é filha à esquerda de outro nó.
     */

    /*
    SUM-OF-LEFT-LEAVES(root)
 1  if root = NIL
 2      return 0
 3  sum ← 0
 4  if root.left ≠ NIL
 5      if root.left.left = NIL and root.left.right = NIL
 6          sum ← sum + root.left.val
 7      else
 8          sum ← sum + SUM-OF-LEFT-LEAVES(root.left)
 9  sum ← sum + SUM-OF-LEFT-LEAVES(root.right)
 10 return sum
     */


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.left != null)
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                sum += sumOfLeftLeaves(root.left);

        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
