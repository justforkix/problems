package com.problems.code;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

 * Given target = 3, return true.
 *
 */
public class TwoDimensionalMatrixSearch {

    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int min_row = 0;
        int max_row = rows-1;
        int found_row = searchRow(matrix, min_row, max_row, target);
        if (found_row == -1) {
            return false;
        }
        int found_column = searchCol(matrix[found_row], 0, matrix[found_row].length-1, target);
        if (found_column == -1) {
            return false;
        }
        return true;
    }
    
    private int searchRow(int[][] matrix, int min, int max, int target) {
        
        if (min > max) {
            return -1;
        }
        
        int mid = min + (max - min)/2;
        
        int cols = matrix[mid].length;
        
        if (target < matrix[mid][0]) {
            return searchRow(matrix, min, mid-1, target);
        } else if (target > matrix[mid][cols-1]) {
            return searchRow(matrix, mid+1, max, target);
        } else {
            return mid;
        }
    }
    
    private int searchCol(int[] matrix, int min, int max, int target) {
        
        if (min > max) {
            return -1;
        }
        
        int mid = min + (max - min)/2;
        
        if (target < matrix[mid]) {
            return searchCol(matrix, min, mid-1, target);
        } else if (target > matrix[mid]) {
            return searchCol(matrix, mid+1, max, target);
        } else {
            return mid;
        }
        
    }

}
