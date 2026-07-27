import java.util.*;

public class TreeBuilder {

    /**
     * Builds a binary tree from a level-order list representation.
     * @param values array containing Integer values (null means no node)
     * @return root of the constructed tree, or null if the array is empty/null
     */
    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Overload that accepts a List<Integer>
    public static TreeNode buildTree(List<Integer> values) {
        if (values == null) return null;
        return buildTree(values.toArray(new Integer[0]));
    }

    /**
     * Builds a binary tree from a level-order Object[] representation.
     * null means "no node" (including when the root is null).
     * Works with the given TreeNode that uses primitive int val.
     *
     * @param values Object array (null entries mean absent nodes)
     * @return root of the constructed tree, or null if the array is empty/null or root is null
     */
    public static TreeNode buildTreeAllowingNulls(Object[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(toInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(toInt(values[i]));
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(toInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Overload for List
    public static TreeNode buildTreeAllowingNulls(List<?> values) {
        if (values == null) return null;
        return buildTreeAllowingNulls(values.toArray());
    }

    /** Converts Object to int (throws if not a Number). */
    private static int toInt(Object val) {
        if (val instanceof Integer) {
            return (Integer) val;
        }
        if (val instanceof Number) {
            return ((Number) val).intValue();
        }
        throw new IllegalArgumentException("Expected Integer/Number, got: " + val.getClass());
    }

    /**
     * Constrói uma BST height-balanced a partir de um array ordenado (recursivo).
     * @param values array ordenado de Integers
     * @return raiz da BST balanceada
     */
    public static TreeNode sortedArrayToBST(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        return buildBalanced(values, 0, values.length - 1);
    }

    public static TreeNode sortedArrayToBST(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        return sortedArrayToBST(values.toArray(new Integer[0]));
    }


    private static TreeNode buildBalanced(Integer[] values, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;   // evita overflow
        TreeNode root = new TreeNode(values[mid]);

        root.left  = buildBalanced(values, left, mid - 1);
        root.right = buildBalanced(values, mid + 1, right);

        return root;
    }
}