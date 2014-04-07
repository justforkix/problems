package com.problems.code;

/**
 * Given a sorted array of integers, find the starting and ending 
 * position of a given target value. Your algorithm's runtime complexity 
 * must be in the order of O(log n). If the target is not found in the array, 
 * return [-1, -1].For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */
public class SearchForRange {

    public int[] searchRange(int[] A, int target) {
    	int[] notFound = {-1, -1};
        
        if (A.length == 0) {
            return notFound;
        }
        
        int mid = binSearch(A, target, 0, A.length-1);
        if (mid == -1) {
            return notFound;
        }
        int min = binSearchLeft(A, target, mid, 0, mid-1);
        int max = binSearchRight(A, target, mid, mid+1, A.length-1);
        int[] result = {min, max};
        return result;
    }
    
    private int binSearch(int[] A, int target, int first, int last) {
        if (first > last) {
            return -1;
        }
        
        int mid = first + (last - first)/2;
        
        if (target == A[mid]) {
            return mid;
        } else if (target < A[mid]) {
            return binSearch(A, target, first, mid-1);
        } else {
            return binSearch(A, target, mid+1, last);
        }
    }
    
    private int binSearchLeft(int[] A, int target, int mid, int first, int last) {
           
           int find = binSearch(A, target, first, last);
           
           if (find == -1) {
               return mid;
           } else {
               return binSearchLeft(A, target, find, first, find-1);
           }
    }   
    
    private int binSearchRight(int[] A, int target, int mid, int first, int last) {
           
           int find = binSearch(A, target, first, last);
           
           if (find == -1) {
               return mid;
           } else {
               return binSearchRight(A, target, find, find+1, last);
           }
    }   

}
