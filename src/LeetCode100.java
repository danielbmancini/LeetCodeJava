public class LeetCode100 {
    /*
    Dadas as raízes de duas árvores binárias p e q, escreva uma função para verificar se elas são iguais ou não.

Duas árvores binárias são consideradas iguais se forem estruturalmente idênticas e os nós tiverem o mesmo valor.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null || p.val != q.val)
            return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }

    public static void main(String[] args) {
        LeetCode100 leetCode100 = new LeetCode100();

        System.out.println(leetCode100.isSameTree(TreeBuilder.buildTree(new Integer[]{1, 2, 1}),
                TreeBuilder.buildTree(new Integer[]{1, 1, 2})));
    }

}
