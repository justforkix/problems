package com.problems.code;

/**
 * Given a string, find the length of the longest substring 
 * without repeating characters. For example, the longest 
 * substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", 
 * with the length of 1.
 */

/* Doesn't work */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        
        int result = 0;
        int temp = 0;
        
        int[] arr = new int[128];
        
        
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( arr[(int)c] != 1) {
                temp++;
            } else {
                if (temp > result) {
                    result = temp;
                }
                temp = 0;
            }
            arr[(int)c] = 1;
        }
        
        if (temp > result) {
            result = temp;
        }
        return result;
    }

}
