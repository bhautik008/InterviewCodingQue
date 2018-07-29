package bloomberg.newgrad.interview;

/*
 * Flatten 2-D Linked List
 * A linked list with not just a next node and down node as well.
 * write a function to flatten that linked list taking all the downward nodes
 * 		and merging them up between their parent and their next nodes.
 * i.e. 1 -> 2 -> 3 -> 4
 * 			 21
 * 			 31 -> 32 -> 33 -> 34
 * 						 43
 * Output: 1 -> 2 -> 21 -> 31 -> 32 -> 33 -> 43 -> 34 -> 3 -> 4
 */

public class Flatten2DLinkedList {

	NodeLL first;

	public static void main(String[] args) {
		Flatten2DLinkedList list = new Flatten2DLinkedList();
		list.first = new NodeLL(1);
		list.first.next = new NodeLL(2);
		list.first.next.down = new NodeLL(21);
		list.first.next.down.down = new NodeLL(31);
		list.first.next.down.down.next = new NodeLL(32);
		list.first.next.down.down.next.next = new NodeLL(33);
		list.first.next.down.down.next.next.down = new NodeLL(43);
		list.first.next.down.down.next.next.next = new NodeLL(34);
		list.first.next.next = new NodeLL(3);
		list.first.next.next.next = new NodeLL(4);
		flatten(list.first);
	}

	private static void flatten(NodeLL first) {
		Flatten2DLinkedList list = new Flatten2DLinkedList();
		list.first = new NodeLL(first.data);
		System.out.print(list.first.data);
		flattenRec(first, list.first);
		printList(list);
	}

	private static void flattenRec(NodeLL node, NodeLL secondListNode) {
		if (node.down != null) {
			secondListNode.next = new NodeLL(node.down.data);
			System.out.print(" -> " + secondListNode.next.data);
			flattenRec(node.down, secondListNode.next);
		}
		if (node.next != null) {
			secondListNode.next = new NodeLL(node.next.data);
			System.out.print(" -> " + secondListNode.next.data);
			flattenRec(node.next, secondListNode.next);
		}
	}

	public static void printList(Flatten2DLinkedList list) {
		NodeLL node = list.first;
		System.out.print(node.data);
		while (node.next != null) {
			System.out.print(" -> " + node.next.data);
			node = node.next;
		}
	}
}

class NodeLL {
	int data;
	NodeLL next, down;

	public NodeLL(int data) {
		this.data = data;
		next = down = null;
	}
}