package com.problems.code;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */

/* Doesn't work */
public class LongestPalindrome {

    class Result {
        
        private int length;
        private int index1;
        private int index2;
        
        public Result(int index1, int index2, int length) {
            this.index1 = index1;
            this.index2 = index2;
            this.length = length;           
        }
        
        public int getIndex1() {
            return this.index1;
        }
        
        public int getIndex2() {
            return this.index2;
        }
        
        public int getLength() {
            return this.length;
        }
        
        public void setIndex1(int index1) {
            this.index1 = index1;
        }
        
        public void setIndex2(int index2) {
            this.index2 = index2;
        }
        
        public void setLength(int length) {
            this.length = length;
        }
        
        @Override
        public String toString() {
        	return "index1: " + getIndex1() + " index2: " + getIndex2() + " length: " + getLength() ;
        }
    }
    
    public String longestPalindrome(String s) {
        
        Result result = new Result(0, 0, 0);
        
        for(int i=0; i < s.length() ; i++) {
            int temp = 0;
            int k = i-1;
            int j = i+1;
            
            while(k >= 0 && j < s.length() && s.charAt(k) == s.charAt(j)) {
                temp++;
                k--;
                j++;
            }
            
            if (temp > result.getLength()) {
                result.setLength(temp);
                result.setIndex1(k+1);
                result.setIndex2(j-1);
                System.out.println(s.charAt(i));
                System.out.println(result.toString());
            }
        }
        System.out.println("first: " + s.charAt(result.getIndex1()) + " second: " + s.charAt(result.getIndex2()));
        return s.substring(result.getIndex1(), result.getIndex2()+1);
        
    }

}
