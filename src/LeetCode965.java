import java.util.List;

public class LeetCode965 {
    /*
    Uma árvore binária é univalorada se todos os seus nós tiverem o mesmo valor.

Dado o valor da raiz de uma árvore binária, retorne verdadeiro se a árvore for univalorada, ou falso caso contrário.
     */
    public boolean isUnivalTree(TreeNode root) {
       LeetCode145 leetCode145 = new LeetCode145(); //postorder traversal

        List<Integer> nodes = leetCode145.postorderTraversal(root);

        if (nodes.isEmpty())
            return true;

        int value = nodes.getFirst();

        for(int node : nodes)
            if (value != node)
                return false;

        return true;
    }

    public static void main(String[] args) {
        LeetCode965 leetCode965 = new LeetCode965();

        Object[] objects = {2,2,2,5,2};

        System.out.println(leetCode965.isUnivalTree(TreeBuilder.buildTreeAllowingNulls(objects)));
    }
}
