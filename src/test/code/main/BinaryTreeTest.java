package test.code.main;

import datastructure.BinaryTree;

public class BinaryTreeTest {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(50);
		 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        System.out.println("printTree traversal of the given tree");
        tree.printTree();
 
        System.out.println("\nDelete 20");
        tree.delete(20);
        System.out.println("printTree traversal of the modified tree");
        tree.printTree();
 
        System.out.println("\nDelete 30");
        tree.delete(30);
        System.out.println("printTree traversal of the modified tree");
        tree.printTree();
 
        System.out.println("\nDelete 50");
        tree.delete(50);
        System.out.println("printTree traversal of the modified tree");
        tree.printTree();
	}
	
}
