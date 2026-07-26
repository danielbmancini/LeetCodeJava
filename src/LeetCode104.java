public class LeetCode104 {
    /*
    Dada a raiz de uma árvore binária, retorne sua profundidade máxima.

A profundidade máxima de uma árvore binária é o número de nós ao longo do caminho mais longo desde o nó raiz até o nó folha mais distante.
     */
    public int maxDepth(TreeNode root) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);

        return binarySearchTree.height() + 1; // 1 + -1 = 0 seria por esta definição a profundidade de uma bst nula
        // por consequência, height + 1 otherwise seria a profundidade máxima também

    }
}
