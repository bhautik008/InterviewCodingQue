package bloomberg.newgrad.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * Add 2 numbers whose digits are stored in a linked list:
 * i.e.: L1 = {1,2,3,4} , L2 = {4,6,2,4}
 * 	1234 + 4624 = 5858
 */
public class Add2ListNumbers {
	
	private static LinkedList<Integer> helper(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		ListIterator<Integer> i1 = l1.listIterator(l1.size());
		ListIterator<Integer> i2 = l2.listIterator(l2.size());
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		int sum = 0, carry = 0, i,j;
		while(i1.hasPrevious() || i2.hasPrevious()) {
			i = i1.hasPrevious() ? i1.previous() : 0;
			j = i2.hasPrevious() ? i2.previous() : 0;
			sum = carry + i + j;
			if(sum > 9) {
				carry = sum - 9;
				sum = sum - 9;
			}
			l3.addFirst(sum);
		}
		if(carry > 0) {
			l3.addFirst(carry);
		}
		return l3;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>(Arrays.asList(1,2,3,4));
		LinkedList<Integer> l2 = new LinkedList<Integer>(Arrays.asList(5,7,4,3));
		System.out.println(helper(l1,l2).toString());
	}
}
