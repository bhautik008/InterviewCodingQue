package test.code.main;

import datastructure.RedBlackTree;

public class RedBlackTest {

	public static void main(String[] args) {
		RedBlackTree<Integer, Integer> tree = new RedBlackTree<Integer, Integer>();
		tree.insert(50,50);
		tree.insert(30,30);
        tree.insert(20,20);
        tree.insert(40,40);
        tree.insert(70,70);
        tree.insert(60,60);
        tree.insert(80,80);
        tree.printInorder();
	}
	
}
