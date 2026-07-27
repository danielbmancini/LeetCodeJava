import java.util.ArrayList;
import java.util.List;

public class LeetCode257 {
    /*
    Dada a raiz de uma árvore binária, retorne todos os caminhos da raiz até uma folha, em qualquer ordem.

Uma folha é um nó sem filhos.
     */
    /*
    BINARY-TREE-PATHS(root)
1  answer ← empty list
2  if root ≠ NIL
3      SEARCH-BT(root, "", answer)
4  return answer


SEARCH-BT(u, path, answer)
1  if u.left = NIL and u.right = NIL
2      append (path + u.val) to answer
3  if u.left ≠ NIL
4      SEARCH-BT(u.left, path + u.val + "->", answer)
5  if u.right ≠ NIL
6      SEARCH-BT(u.right, path + u.val + "->", answer)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();


        if (root != null)
            search_BT(root, "", answer);

        return answer;
    }

    private void search_BT(TreeNode node, String path, List<String> answer) {
        if (node.left == null && node.right == null)
            answer.add(path + node.val);
        if (node.left != null)
            search_BT(node.left, path + node.val + "->",answer);
        if (node.right != null)
            search_BT(node.right, path + node.val + "->", answer);
    }


}
