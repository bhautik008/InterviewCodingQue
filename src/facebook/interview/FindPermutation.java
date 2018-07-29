package facebook.interview;

/*
- Given a set of characters, print out all possible  permutations
- Given a set of characters and a positive integer k,
	print all possible strings of length k that can be formed from the given set.
- Ex. {'a', 'b'} and k = 3: possible permutations:
	- aaa, aab, aba, abb, baa, bab, bba, bbb
*/
public class FindPermutation {

	static void printAllKLength(char[] set, int k) {
		int n = set.length;
		printAllKLengthRec(set, "", n, k);
	}

	static void printAllKLengthRec(char[] set, String prefix, int n, int k) {
		if (k == 0) {
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < n; ++i) {
			String newPrefix = prefix + set[i];
			printAllKLengthRec(set, newPrefix, n, k - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("First Test");
		char[] set1 = { 'a', 'b' };
		int k = 3;
		printAllKLength(set1, k);
	}
}
