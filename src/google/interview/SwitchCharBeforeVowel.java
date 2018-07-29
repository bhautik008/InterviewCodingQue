package google.interview;

import java.util.Arrays;
import java.util.HashSet;

/*
 * for given word take characters before first vowel character and place them at then end with "ay".
 * if the first character is vowel then add "way" at then end.
 * i.e. Google	-> OogleGay
 * 		act 	-> actway
 * 		life	-> ifelay
 */

public class SwitchCharBeforeVowel {

	public static String solve(String s) {
		StringBuilder s1 = new StringBuilder(); // string contains character before first vowel
		StringBuilder s2 = new StringBuilder(); // string contains character before first vowel
		Character[] vv = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		HashSet<Character> v = new HashSet<Character>(Arrays.asList(vv));
		int i;
		char c;
		boolean firstCap = false;
		char[] str = s.toCharArray();

		// checking if first character is capitalized
		if (Character.isUpperCase(str[0])) {
			firstCap = true;
		}

		// add all the character into s1 which comes before first vowel
		for (i = 0; i < str.length; i++) {
			c = str[i];
			if (!v.contains(c)) {
				s1.append(c);
			} else {
				break;
			}
		}

		// add all the character into s2 which comes after first vowel
		while (i < s.length()) {
			c = str[i];
			s2.append(c);
			i++;
		}

		// replacing first character if word was capitalized
		if (firstCap) {
			s2.setCharAt(0, Character.toUpperCase(s2.charAt(0)));
			if (s1.length() > 0)
				s1.setCharAt(0, Character.toLowerCase(s1.charAt(0)));
		}
		return convertString(s1.toString(), s2.toString());
	}

	public static String convertString(String s1, String s2) {
		StringBuilder r = new StringBuilder();
		r.append(s2);
		r.append(s1);
		if (s1.isEmpty()) {
			r.append("way");
		} else {
			r.append("ay");
		}
		return r.toString();
	}

	public static void main(String[] args) {
		String[] words = { "Google", "act", "life" };
		for (String s : words) {
			System.out.println(s + " -> " + solve(s));
		}
	}
}
