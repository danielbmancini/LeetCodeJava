import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode113 {
    /*
    Dado o nó raiz de uma árvore binária e um inteiro `targetSum`, retorne todos os caminhos da raiz até uma folha onde a soma dos valores dos nós no caminho seja igual a `targetSum`. Cada caminho deve ser retornado como uma lista dos valores dos nós, não como referências aos nós.

Um caminho da raiz até uma folha é um caminho que começa na raiz e termina em qualquer nó folha. Uma folha é um nó sem filhos.
     */
    /*
    https://onlyimage.org/image/nblI3s
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> valList = new ArrayList<>();
        valList.add(root.val);
        Stack<Object> stack = new Stack<>();

        stack.push(root);
        stack.push(targetSum);
        stack.push(valList);

        while (!stack.isEmpty()){
            ArrayList<Integer> path = (ArrayList<Integer>) stack.pop();
            int currentSum = (int) stack.pop();
            TreeNode node = (TreeNode) stack.pop();

            if (node.right == null && node.left == null && currentSum == node.val){
                result.add(path);
                continue;
            }

            if (node.right != null) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(node.right.val);
                stack.push(node.right);
                stack.push(currentSum - node.val);
                stack.push(newPath);
            }


            if (node.left != null){
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(node.left.val);
                stack.push(node.left);
                stack.push(currentSum - node.val);
                stack.push(newPath);
            }

        }
        return result;
    }
}
