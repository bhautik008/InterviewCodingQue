package datastructure;

public class RedBlackTree<K, V> {

	@SuppressWarnings("hiding")
	class Node<K, V> {
		K key;
		V value;
		Node<K, V> left, right, parent;
		boolean isLeft, black;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = right = parent = null;
			black = false;
			isLeft = false;
		}
	}

	Node<K, V> root;
	int size;

	public void insert(K key, V value) {
		Node<K, V> node = new Node<K, V>(key, value);
		if (root == null) {
			root = node;
			root.black = true;
			size++;
		} else {
			insert(root, node);
			checkRules(node);
			size++;
		}
	}

	@SuppressWarnings("unchecked")
	private void insert(Node<K, V> parent, Node<K, V> node) {
		if (((Comparable<K>) node.key).compareTo(parent.key) > 0) {
			if (parent.right == null) {
				parent.right = node;
				node.parent = parent;
				node.isLeft = false;
			} else {
				insert(parent.right, node);
			}
		} else {
			if (parent.left == null) {
				parent.left = node;
				node.parent = parent;
				node.isLeft = true;
			} else {
				insert(parent.left, node);
			}
		}
	}

	public int height() {
		if (root == null)
			return 0;
		return height(root) - 1;
	}

	private int height(Node<K, V> node) {
		if (node == null)
			return 0;
		int leftheight = height(node.left) + 1;
		int rightheight = height(node.right) + 1;
		if (leftheight > rightheight)
			return leftheight;
		return rightheight;
	}

	@SuppressWarnings("unused")
	public int blackNodes(Node<K, V> node) {
		if (node == null)
			return 1;
		int rightBlackNode = blackNodes(node.right);
		int leftBlackNode = blackNodes(node.left);
		if (node.black)
			leftBlackNode++;
		return leftBlackNode;
	}

	private void checkRules(Node<K, V> node) {
		if (node == root)
			return;
		if (!node.black && !node.parent.black)
			correctTree(node);
		checkRules(node.parent);
	}

	private void correctTree(Node<K, V> node) {
		if (node.parent.isLeft) { // aunt is right
			if (node.parent.parent.right == null || node.parent.parent.right.black) {
				rotate(node);
				return;
			}
			if (node.parent.parent.right != null)
				node.parent.parent.right.black = true;
			node.parent.parent.black = false;
			node.parent.black = true;
			return;
		} else { // aunt is left
			if (node.parent.parent.left == null || node.parent.parent.right.black) {
				rotate(node);
				return;
			}
			if (node.parent.parent.left != null)
				node.parent.parent.left.black = true;
			node.parent.parent.black = false;
			node.parent.black = true;
			return;
		}
	}

	private void rotate(RedBlackTree<K, V>.Node<K, V> node) {
		if (node.isLeft) {
			if (node.parent.isLeft) {
				rightRotate(node.parent.parent);
				node.black = false;
				node.parent.black = true;
				if (node.parent.right != null)
					node.parent.right.black = false;
				return;
			}
			rightLeftRotate(node.parent.parent);
			node.black = true;
			node.left.black = node.right.black = false;
			return;
		} else {
			if (!node.parent.isLeft) {
				leftRotate(node.parent.parent);
				node.black = false;
				node.parent.black = true;
				if (node.parent.left != null)
					node.parent.left.black = false;
				return;
			}
			leftRightRotate(node.parent.parent);
			node.black = true;
			node.left.black = node.right.black = false;
			return;
		}
	}

	public void leftRotate(Node<K, V> node) {
		Node<K, V> temp = node.right;
		node.right = temp.left;
		if (node.right != null) {
			node.right.parent = node;
			node.right.isLeft = false;
		}
		if (node.parent == null) {
			root = temp;
			temp.parent = null;
			temp.isLeft = false;
		} else {
			temp.parent = node.parent;
			if (node.isLeft) {
				temp.isLeft = true;
				temp.parent.left = temp;
			} else {
				temp.isLeft = false;
				temp.parent.right = temp;
			}
		}
		temp.left = node;
		node.isLeft = true;
		node.parent = temp;
	}

	public void rightRotate(Node<K, V> node) {
		Node<K, V> temp = node.left;
		node.left = temp.right;
		if (node.left != null) {
			node.left.parent = node;
			node.left.isLeft = true;
		}
		if (node.parent == null) {
			root = temp;
			temp.parent = null;
			temp.isLeft = false;
		} else {
			temp.parent = node.parent;
			if (node.isLeft) {
				temp.isLeft = true;
				temp.parent.left = temp;
			} else {
				temp.isLeft = false;
				temp.parent.right = temp;
			}
		}
		temp.right = node;
		node.isLeft = false;
		node.parent = temp;
	}

	public void leftRightRotate(Node<K, V> node) {
		leftRotate(node.left);
		rightRotate(node);
	}

	public void rightLeftRotate(Node<K, V> node) {
		rightRotate(node.right);
		leftRotate(node);
	}

	public void printInorder() {
		printInorder(root);
	}

	private void printInorder(Node<K, V> node) {
		if (node != null) {
			if (node.left != null)
				printInorder(node.left);
			System.out.println(node.value);
			if (node.right != null)
				printInorder(node.right);
		}
	}
}