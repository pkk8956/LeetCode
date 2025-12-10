package Tree;

public class Run {

    public static void main(String[] args) {

        //Simple Binary Tree 
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(1);
        BinaryTree.Node left = binaryTree.addLeft(binaryTree.getRoot(), 2);
        BinaryTree.Node right = binaryTree.addRight(binaryTree.getRoot(), 3);
        binaryTree.addLeft(left, 4);
        binaryTree.addRight(right, 5);
        System.out.println("--- Simple Binary Tree ---");
        System.out.println("Binary Tree inorder traversal:");
        binaryTree.inorder();

        //Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {7, 3, 9, 1, 5, 8, 10};
        for (int value : values) bst.insert(value);
        System.out.println("--- Binary Search Tree ---");
        System.out.println("BST inorder traversal:");   
        bst.inorder();
        int searchValue = 5;
        System.out.println("Searching for " + searchValue + ": " + bst.search(searchValue));

        //AVL Tree
        AVLTree avlTree = new AVLTree();
        int[] avlValues = {10, 20, 30, 40, 50, 25};
        for (int value : avlValues) avlTree.insert(value);
        System.out.println("--- AVL Tree ---");
        System.out.println("AVL Tree inorder traversal:");
        avlTree.inorder();
        int avlSearchValue = 25;
        System.out.println("Searching for " + avlSearchValue + ": " + avlTree.search(avlSearchValue));
        avlTree.delete(40);
        avlTree.inorder();
        avlTree.delete(30);
        avlTree.inorder();
        avlTree.insert(60);
        avlTree.insert(70);
        avlTree.inorder();

        //B-Tree
        BTree bTree = new BTree(3); 
        int[] bTreeValues = {10, 20, 5, 6, 12, 30, 7, 17};
        for (int value : bTreeValues) bTree.insert(value);
        System.out.println("--- B-Tree ---");
        System.out.println("B-Tree traversal:");
        bTree.print();
        System.out.println("Searching for 6: " + bTree.search(6));
        System.out.println("Searching for 15: " + bTree.search(15));

        //B+ Tree
        BPlusTree bPlusTree = new BPlusTree(3);
        int[] bPlusTreeValues = {10, 20, 5, 6, 12, 30, 7, 17};
        for (int value : bPlusTreeValues) bPlusTree.insert(value);
        System.out.println("--- B+ Tree ---");
        System.out.println("B+ Tree traversal:");
        bPlusTree.print();
        System.out.println("Searching for 6: " + bPlusTree.search(6));
        System.out.println("Searching for 15: " + bPlusTree.search(15));

        System.out.println("--- Tree Traversals ---");
        System.out.print("DFS Preorder: ");
        TreeTraversal.dfsPreorder(binaryTree.getRoot());

        System.out.print("DFS Inorder: ");
        TreeTraversal.dfsInorder(binaryTree.getRoot());

        System.out.print("DFS Postorder: ");
        TreeTraversal.dfsPostorder(binaryTree.getRoot());

        System.out.print("BFS (Level-order): ");
        TreeTraversal.bfs(binaryTree.getRoot());

<<<<<<< HEAD
        //Red-Black Tree
        System.out.println("\n--- Red-Black Tree ---");
        RedBlackTree redBlackTree = new RedBlackTree();
        int[] redBlackValues = {10, 20, 30, 15, 25, 5, 1};
        for (int v : redBlackValues) redBlackTree.insert(v);
        redBlackTree.inorder();
        redBlackTree.delete(20);
        redBlackTree.delete(5);
        redBlackTree.inorder();
        
        //2-3 Tree
        System.out.println("--- 2-3 Tree ---");
        TwoThreeTree twoThreeTree = new TwoThreeTree();
        int[] twoThreeValues = {10, 20, 5, 15, 25, 30, 1};
        for (int v : twoThreeValues) twoThreeTree.insert(v);
        twoThreeTree.inorder();

        //2-3-4 Tree
        System.out.println("--- 2-3-4 Tree ---");
        TwoThreeFourTree twoThreeFourTree = new TwoThreeFourTree();
        int[] twoThreeFourValues = {10, 20, 5, 15, 25, 30, 1, 8, 12};
        for (int v : twoThreeFourValues) twoThreeFourTree.insert(v);
        twoThreeFourTree.inorder();

=======
>>>>>>> cacfd31 (Another one day gone by)

    



    
    }
    
}
