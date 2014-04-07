package com.problems.code;

/**
 * "aabcccccaaa" would become "a2b1c5a3". If the compressed string is longer
 * than the original string then return the original string.
 */
public class StringCompression {

	/* using string buffer. Another way is to allocate a 
	 char[] of the required size first. */
	public String compress(String s) {
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		char prev = '\0';
		int temp = 0;

		for (char c : chars) {
			if (prev != c && prev != '\0') {
				sb.append(prev);
				sb.append(temp);
				temp = 1;
			} else {
				temp++;
			}
			prev = c;
		}
		sb.append(prev);
		sb.append(temp);

		String result = sb.toString();
		if (result.length() < s.length()) {
			return result;
		} else {
			return s;
		}
	}

}
