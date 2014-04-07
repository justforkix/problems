package com.problems.code;

/**
 * Replace spaces in string with %20. The string has additonal 
 * space in the end to hold the additonal characters. 
 * Do it in place.
 */
public class ReplaceSpacesInString {

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int end = chars.length-1;
        boolean hit = false;
        
        for(int j = chars.length-1; j >= 0; j--) {
            
            if(chars[j] == 32 && !hit) {
                continue;
            }
            
            hit = true;
            
            if(chars[j] == 32) {
            	chars[end--] = '0';
            	chars[end--] = '2';
            	chars[end--] = '%';
            } else {
            	chars[end--] = chars[j];
            }
        }
        
        return String.valueOf(chars);
    }

}
