package bloomberg.newgrad.interview;

/*
 * Find the maximum difference in an unsorted array with the index of max greater than min. Array can't be sorted.
 * 
 */

public class FindMaxDiffUnsortedAry {

	private static void solution2(int[] a) {
		int min = a[0], max = a[0], start = 0, end = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				if (start <= end) {
					min = a[i];
					start = i;
				}
			}
			if (a[i] > max) {
				max = a[i];
				end = i;
			}
		}

		System.out.println("Start: " + start + "-> " + a[start] + ", end: " + end + "-> " + a[end] + ", diff:"
				+ (a[end] - a[start]));
	}

	public static void main(String[] args) {
		int[] a = { 52, 4, 6, 89, 1, 5, 99, 35, 67, 9, 88 };
		solution2(a);
	}
}
