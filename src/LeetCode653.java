import java.util.ArrayList;
import java.util.List;

public class LeetCode653 {
        /*
        Dado o valor raiz de uma árvore binária de busca e um inteiro k, retorne verdadeiro se existirem dois elementos na árvore binária de busca cuja soma seja igual a k, ou falso caso contrário.
         */
    public boolean findTarget(TreeNode root, int k) {
        LeetCode94 leetCode94 = new LeetCode94(); //inorder traversal

        List<Integer> list = leetCode94.inorderTraversal(root);

        for (int i = 0; i < list.size(); i++) { //solução 2-sum usual
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == k)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LeetCode653 leetCode653 = new LeetCode653();

        Object[] objects = {5,3,6,2,4,null,7};

        System.out.println(leetCode653.findTarget(TreeBuilder.buildTreeAllowingNulls(objects),28));
    }
}