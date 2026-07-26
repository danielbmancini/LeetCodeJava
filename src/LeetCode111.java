public class LeetCode111 {

/*
Dada uma árvore binária, encontre sua profundidade mínima.

A profundidade mínima é o número de nós ao longo do caminho mais curto da raiz até o nó folha mais próximo.

Nota: Uma folha é um nó sem filhos.
 */

    /*
MINIMUM-DEPTH(T)
1  if T = NIL
2      return 0
3  if T.left = NIL and T.right = NIL
4      return 1
5  if T.left = NIL
6      return 1 + MINIMUM-DEPTH(T.right)
7  if T.right = NIL
8      return 1 + MINIMUM-DEPTH(T.left)
9  return 1 + min(MINIMUM-DEPTH(T.left), MINIMUM-DEPTH(T.right)) */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        if (root.left == null)
            return 1 + minDepth(root.right);

        if (root.right == null)
            return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
