public class BinarySearchTree {
    private static TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insertRecursive(node.left, val);
        } else if (val > node.val) {
            node.right = insertRecursive(node.right, val);
        }
        return node;
    }

    public boolean search(int val) {
        return searchRecursive(root, val) != null;
    }

    public TreeNode searchNode(int val) {
        return searchRecursive(root, val);
    }

    private TreeNode searchRecursive(TreeNode node, int val) {
        if (node == null || node.val == val) {
            return node;
        }
        if (val < node.val) {
            return searchRecursive(node.left, val);
        }
        return searchRecursive(node.right, val);
    }

    public void delete(int val) {
        root = deleteRecursive(root, val);
    }

    private TreeNode deleteRecursive(TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        if (val < node.val) {
            node.left = deleteRecursive(node.left, val);
        } else if (val > node.val) {
            node.right = deleteRecursive(node.right, val);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.val = findMin(node.right).val;
            node.right = deleteRecursive(node.right, node.val);
        }
        return node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(TreeNode node) {
        if (node == null) return 0;
        return 1 + sizeRecursive(node.left) + sizeRecursive(node.right);
    }

    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(TreeNode node) {
        if (node == null) return -1;
        return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
    }

    public TreeNode findMin() {
        return findMin(root);
    }

    private TreeNode findMin(TreeNode node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeNode findMax() {
        return findMax(root);
    }

    private TreeNode findMax(TreeNode node) {
        if (node == null) return null;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void inorder() {
        inorderRecursive(root);
        System.out.println();
    }

    public static void inorderRecursive(TreeNode node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.val + " ");
            inorderRecursive(node.right);
        }
    }

    /** Prints pre-order traversal to console (root → left → right). */
    public static void preOrderRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    /**
     * Returns a space-separated pre-order traversal string
     * (root → left → right). Empty tree → empty string.
     */
    public static String preOrder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        preOrderHelper(node, sb);
        return sb.toString().trim();
    }

    private static void preOrderHelper(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val).append(" ");
            preOrderHelper(node.left, sb);
            preOrderHelper(node.right, sb);
        }
    }

    /** Prints post-order traversal to console (left → right → root). */
    public static void postOrderRecursive(TreeNode node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.val + " ");
        }
    }

    /**
     * Returns a space-separated post-order traversal string
     * (left → right → root). Empty tree → empty string.
     */
    public static String postOrder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        postOrderHelper(node, sb);
        return sb.toString().trim();
    }

    private static void postOrderHelper(TreeNode node, StringBuilder sb) {
        if (node != null) {
            postOrderHelper(node.left, sb);
            postOrderHelper(node.right, sb);
            sb.append(node.val).append(" ");
        }
    }

    public void levelOrder() {
        if (root == null) return;

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        System.out.println();
    }

    public void printTree() {
        printTreeRecursive(root, "", true);
    }

    private void printTreeRecursive(TreeNode node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.val);

        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTreeRecursive(node.left, prefix + (isTail ? "    " : "│   "), node.right == null);
            }
            if (node.right != null) {
                printTreeRecursive(node.right, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}