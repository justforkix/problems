package com.problems.code;

/**
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
*/
public class ReverseString {
	
    public String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("invalid input");
        }
        
        boolean hit = false;
        String result = "";
        String word = "";
        char prev = 0;
        
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (!hit && c == 32) {
                continue;
            } else {
                hit = true;
            }   
            
            if (c == 32) {
                if (prev == 32) {
                    prev = c;
                    continue;
                } else {
                    result = c + word + result;
                    word = "";
                }
            } else {
                 word = word + c;
            }
            prev = c;
        }
        
        result = word + result;
        
        if (!result.isEmpty() && result.charAt(0) == 32) {
           result = result.substring(1,result.length());
        }
        
        return result;
    }
    
    public String reverseStringImproved(String s) { 
        if (s == null || s.isEmpty()) {
            throw new NullPointerException("invalid input");
        }
        
        String cleansedString = cleanse(s);
        String result = "";
        String word = "";
        
        for(int i=0; i < cleansedString.length(); i++) {
        	char x = cleansedString.charAt(i);
        	
        	if (x == 32) {
        		result = x + word + result;
        		word = "";
        	} else {
        		word = word + x;
        	}
            
        }
        return word + result;
    }
    
    private String cleanse(final String input) {
        String result = "";
        
        boolean hit = false;
        char prev = 0;
        
        for(int i=0; i < input.length(); i++) {
            char x = input.charAt(i);
            
            if (!hit && x == 32) {
                continue;
            } else {
                hit = true;
            }
            
            if (x != 32 || (x==32 && !(prev==32))) {
                result = result + x;
            } 
            
            prev = x;
        }
        
        if (!result.isEmpty() && result.charAt(result.length()-1) == 32) {
        	result = result.substring(0, result.length()-1);
        }
        return result;
    }
    
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		String result = rs.reverseString("The sky is blue");
		System.out.println(result);
	}
   
}
