public class LeetCode112 {
        /*
        Dado o valor da raiz de uma árvore binária e um inteiro `targetSum`, retorne verdadeiro se a árvore possui um caminho da raiz até uma folha tal que a soma de todos os valores ao longo do caminho seja igual a `targetSum`.

Uma folha é um nó sem filhos.
         */
    /*
    root null = false

retorna falso p/ left and right nulos
    targetSum - root.val == 0?

targetSum - root.val

return hasPathSum(root.left, targetSum) || hasPathSum(root.right,targetSum)
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null)
            return false;

        if (root.left == null & root.right == null)
            return targetSum - root.val == 0;

        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);

    }
}
