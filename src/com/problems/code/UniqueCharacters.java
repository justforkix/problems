package com.problems.code;

import java.util.Arrays;

/**
 * Determine if a string has unique characters
 *
 */
public class UniqueCharacters {

	/**
	 * using array
	 */
	public boolean hasUnique1(String input) {
		if (input.isEmpty() || input == null) {
			return false;
		}
        boolean[] ascii = new boolean[256];
        
        for(int i=0; i < input.length(); i++) {
            char value = input.charAt(i);
   
            if (ascii[value]) {
                return false;
            } else {
                ascii[value] = true;
            }
        }
        return true;
	}
	
	/**
	 * sorting the characters first
	 */
	public boolean hasUnique2(String input) {
        char[] value = input.toCharArray();
        Arrays.sort(value);
        int prev = -1;
        for(int i = 0; i < value.length; i++) {
            int curr = value[i];
            if (prev == curr) {
                return false;
            }
            prev = curr;
        }
        return true;
	}
	
	/**
	 * using bit vector when chars are between a-z
	 */
	public boolean hasUnique3(String input) {
		char[] values = input.toCharArray();
		int store = 0;
		for(int i=0; i < values.length; i++) {
			int pos = values[i] - 'a';
			if ((store & (1 << pos)) > 0) {
				return false;
			}
			store |= (1 << pos);
		}
		return true;
	}
}
