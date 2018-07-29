package bloomberg.newgrad.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Finding Anagrams from a set of strings
 * 
 * What is anagram – two words are anagrams if they contain the same characters
 * 
 * i.e. ["bat", "cat", "act", "tab", "crazy"]
 * Anagrams = "bat" & "tab", "cat" & "act"
 * 
 */
public class FindAnagrams {

	private static void findAnagrams(String[] words) {
		Map<String, Set<String>> anagrams = new HashMap<String, Set<String>>();
		for(String word : words) {
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String w = new String(letters);
			if(!anagrams.containsKey(w)) {
				Set<String> set = new HashSet<String>();
				set.add(word);
				anagrams.put(w, set);
			} else {
				anagrams.get(w).add(word);
			}
		}
		System.out.println("Anagrams in given word set "+Arrays.toString(words)+":");
		for(Set<String> list : anagrams.values()) {
			System.out.println(list.toString());
		}
	}
	
	public static void main(String[] args) {
		String[] words = {"bat", "cat", "act", "tab", "crazy"};
		findAnagrams(words);
	}
}
