package bloomberg.newgrad.interview;

/*
 * Print level at which node is in a binary tree
 * 		   3
 *		  / \
 *		 2	 5
 * 		/ \
 * 	   1   4
 * for this tree level of nodes are as follow:
 * Node 3 at level 1
 * Node 2 at level 2
 * Node 5 at level 2
 * Node 1 at level 3
 * Node 4 at level 4
 */

public class FindNodeLevel {

	Node root;
	
	private static int getLevel(Node node, int data) {
		return getLevelRec(node, data, 1);
	}
	
	private static int getLevelRec(Node node, int data, int level) {
		if(node == null) return 0;
		if(node.data == data) return level;
		int i = getLevelRec(node.left, data, level+1);
		if(i > 0) return i;
		i = getLevelRec(node.right, data, level+1);
		return i;
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		FindNodeLevel tree = new FindNodeLevel();
		tree.root = new Node(3);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);
		
		System.out.println("Level of 4 = "+tree.getLevel(tree.root, 4));
	}
}

class Node{
	int data;
	public Node left, right;
	
	public Node(int data){
		this.data = data;
		left = right = null;
	}
}
