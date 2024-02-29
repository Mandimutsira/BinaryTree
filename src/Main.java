public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] elements = {45, 27, 67, 36, 56, 15, 75, 31, 53, 39, 64};

        // Inserting elements into the BST
        for (int element : elements) {
            bst.insert(element);
        }

        // Printing the BST in order
        bst.printInOrder();

        // Printing the tree structure
        bst.printTree();


        System.out.println("Is AVL Tree: " + bst.isAVLTree());
    }
}