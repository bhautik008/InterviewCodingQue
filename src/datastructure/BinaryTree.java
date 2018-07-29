package datastructure;

public class BinaryTree {
	
	class Node{
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	Node root;
	
	public BinaryTree(int data) {
		root = new Node(data);
	}
	
	public void insert(int value) {
		insert(root, value);
	}
	
	private void insert(Node root, int value) {
		if(value <= root.data) {
			if(root.left == null) {
				root.left = new Node(value);
			} else {
				insert(root.left, value);
			}
		} else {
			if(root.right == null) {
				root.right = new Node(value);
			} else {
				insert(root.right, value);
			}
		}
	}
	
	public boolean contains(int value) {
		return contains(root, value);
	}
	
	private boolean contains(Node root, int value) {
		if(root.data == value)
			return true;
		else if(value < root.data) {
			if(root.left == null) 
				return false;
			else
				return contains(root.left, value);
		} else {
			if(root.right == null)
				return false;
			else
				return contains(root.right, value);
		}
	}
	
	public void printTree() {
		printTree(root);
	}
	
	// print InOrder
	private void printTree(Node root) {
		if(root != null)
			if(root.left != null)
				printTree(root.left);
			System.out.println(root.data);
			if(root.right != null)
				printTree(root.right);
	}
	
	public Node delete(int value) {
		return delete(root, value);
	}
	
	private Node delete(Node root, int value) {
		if(root == null) return root;
		else if(value < root.data) root.left = delete(root.left, value);
		else if(value > root.data) root.right = delete(root.right, value);
		else {
			if(root.left == null && root.right == null)
				root = null;
			else if(root.left == null)
				root = root.right;
			else if(root.right == null)
				root = root.left;
			else {
				Node temp = findMin(root.right);
				root.data = temp.data;
				root.right = delete(root.right, temp.data);
			}
		}
		return root;
	}
	
	private Node findMin(Node root) {
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
}
