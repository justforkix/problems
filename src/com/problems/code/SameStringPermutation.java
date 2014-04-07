package com.problems.code;

import java.util.Arrays;

/**
 * Decide if one string is a permutation of the other.
 *
 */
public class SameStringPermutation {

	/**
	 * sort the strings first
	 */
    public boolean sameString1(String s1, String s2) {
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        for(int i=0; i< c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
	/**
	 * character counts
	 */
    public boolean sameString2(String s1, String s2) {
    	
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int[] value = new int[256];
        
        for(char c : c1) {
            value[c]++;
        }
        
        for(char c : c2) {
            --value[c];
        }
        
        for(int i=0; i < value.length; i++) {
            if (value[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
