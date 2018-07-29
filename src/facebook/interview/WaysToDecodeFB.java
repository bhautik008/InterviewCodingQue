package facebook.interview;

/*
 * Number ways to decode message?
 * 
 * Alphabets are mapped with their index
 * 	i.e. a -> 1, b -> 2, c -> 3,....., z -> 26
 * 
 * Given input string containing digits, find possible decoded message in alphabets. if string starts with "0" then return 0;
 * i.e. "12" -> 'ab' or 'l' -> 2 ways
 * 		"12345" -> 'a', 'l', 'b', 'w', 'c', 'd', 'e' -> 7
 */

public class WaysToDecodeFB {

	public static void main(String[] args) {
		String s = "12345";
		num_ways(s);
	}

	private static void num_ways(String s) {
		int[] memo = new int[s.length() + 1];
		int i = helper(s, s.length(), memo);
		System.out.println("ways " + i);
	}

	private static int helper(String s, int k, int[] memo) {
		if (k == 0)
			return 1;
		int i = s.length() - k;
		if (s.charAt(i) == '0')
			return 0;
		if (memo[k] != 0)
			return memo[k];
		int result = helper(s, k - 1, memo);
		int j = Integer.valueOf(s.substring(i, i + 1));
		if (k >= 2 && j <= 26)
			result += helper(s, k - 2, memo);
		memo[k] = result;
		return result;
	}
}