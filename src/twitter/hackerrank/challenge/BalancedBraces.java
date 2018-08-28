package twitter.hackerrank.challenge;

import java.util.Arrays;
import java.util.Stack;

public class BalancedBraces {

	static String[] braces(String[] values) {
		String[] result = new String[values.length];
		for(int i=0;i<values.length;i++) {
			result[i] = helper(values[i]);
		}
		return result;
	}
	
	static String helper(String string) {
		char[] chars = string.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<chars.length;i++) {
			if(chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
				stack.push(chars[i]);
			}
			if(chars[i] == '}' || chars[i] == ']' || chars[i] == ')') {
				if(!stack.empty()) {
					char c = stack.pop();
					if(c == '{') {
						if(chars[i] != '}')
							return "NO";
					} else if(c == '[') {
						if(chars[i] != ']')
							return "NO";
					} else if(c == '(') {
						if(chars[i] != ')')
							return "NO";
					}
				}
			}
		}
		return "YES";
	}

	public static void main(String[] args) {
		String[] values = {"{}[]()", "{[}]}", "[}]{}", "[{}]"};
		System.out.println(Arrays.toString(braces(values)));
	}
}
