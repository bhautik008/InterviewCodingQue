package bloomberg.newgrad.interview;

/*
 * Given an integer, check if is palindrome and if then find next largest palindrome
 * i.e. 12321 -> palindrome -> next largest palindrome -> 12421
 * 		738837 ->  palindrome -> next largest palindrome -> 739937
 * 		12532 -> not a palindrome number
 */

public class NextLargestPalindromeNumber {

	public static void main(String[] args) {
		int[] nums = { 12321, 738837, 56788765, 3435667 };
		for (int num : nums) {
			if (isPalindrome(num)) {
				System.out.println("Next larget palindrome number for " + num + " is: " + nextPalindrome(num));
			} else {
				System.out.println(num + " is not palindrome");
			}
		}
	}

	private static boolean isPalindrome(int number) {
		int reverse = 0, num = number;
		while (number != 0) {
			int reminder = number % 10;
			reverse = reverse * 10 + reminder;
			number = number / 10;
		}
		return reverse == num;
	}

	private static int nextPalindrome(int number) {
		String s = String.valueOf(number);
		StringBuilder s1 = new StringBuilder(s);

		int m = s.length() / 2;
		char c = s.charAt(m);
		int n = Character.getNumericValue(c);
		n += 1;
		s1.setCharAt(m, Character.forDigit(n, 10));

		if (s.length() % 2 == 0) {
			char c1 = s.charAt(m - 1);
			int n1 = Character.getNumericValue(c1);
			n1 += 1;
			s1.setCharAt(m - 1, Character.forDigit(n1, 10));
		}

		return Integer.parseInt(s1.toString());
	}
}
