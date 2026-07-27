public class LeetCode226 {
    /*
    Dada a raiz de uma árvore binária, inverta a árvore e retorne sua raiz.
     */

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        swapNodeChildren(root);

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    private void swapNodeChildren(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
