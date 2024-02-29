class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        this.root = insertRecursive(this.root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }

        return node;
    }

    public void printInOrder() {
        System.out.println("Binary Search Tree In-order Traversal:");
        printInOrderRecursive(this.root);
        System.out.println();
    }

    private void printInOrderRecursive(TreeNode node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.print(node.value + " ");
            printInOrderRecursive(node.right);
        }
    }

    public void printTree() {
        System.out.println("Binary Search Tree Structure:");
        printTreeRecursive(this.root, 0);
        System.out.println();
    }

    private void printTreeRecursive(TreeNode node, int level) {
        if (node != null) {
            printTreeRecursive(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(node.value);
            printTreeRecursive(node.left, level + 1);
        }
    }

    public int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int balanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public boolean isAVL(TreeNode node) {
        if (node == null) {
            return true;
        }
        int balance = balanceFactor(node);
        return Math.abs(balance) <= 1 && isAVL(node.left) && isAVL(node.right);
    }

    public boolean isAVLTree() {
        return isAVL(root);
    }
}