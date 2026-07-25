import java.util.*;

public class LeetCode94 {
    /*
    Dada a raiz de uma árvore binária, retorne o percurso em ordem dos valores de seus nós.
     */

    /*
    INORDER-TREE-WALK .x/
    1 if x != NIL
    2 INORDER-TREE-WALK.x:left/
    3 print x:key
    4 INORDER-TREE-WALK.x:right/
     */
    List<Integer> treeWalk = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null)
            return treeWalk;
        inorderTraversal(root.left);
        treeWalk.add(root.val);
        inorderTraversal(root.right);

        return treeWalk;
    }

    /*
INORDER-TRAVERSAL-ITERATIVE(root)
    result ← empty list
    stack  ← empty stack
    node   ← root
    while node ≠ NIL  OR  stack is not empty  do
        while node ≠ NIL  do
            PUSH(stack, node)
            node ← node.left
        end while
        node ← POP(stack)
        APPEND(result, node.val)
        node ← node.right
    end while

    return result
*/
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            treeWalk.add(node.val);
            node = node.right;
        }
        return treeWalk;
    }

    public static void main(String[] args) {
        LeetCode94 leetCode94 = new LeetCode94();
        System.out.println(leetCode94.inorderTraversalIterative(TreeBuilder.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9})));

    }

}
