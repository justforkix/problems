package com.problems.code;

/**
 * Rotate image in N x N matrix by 90 degrees
 *
 */
public class RotateImage {

	/*
	 * instead of rotating each pixel here we could shift the
	 * entire 1-D array.
	 */
	public void rotate90(int[][] image) {
		
		int size = image.length;
		
		for (int row = 0; row < size/2; row++) {
		    for (int col = row; col < size-row-1; col++) {
		        rot(image, row, col, col, size-1-row, size, image[row][col]);
		    }
		}

	}
	
	private void rot(int[][] image, int orig_row, int orig_col, int row, int col, int size, int val) {
	    if (orig_row == row && orig_col == col) {
	    	image[row][col] = val;
	        return;
	    }
	    
	    int new_row = col;
	    int new_col = size-1-row;
	    
	    rot(image, orig_row, orig_col, new_row, new_col , size, image[row][col]);
	    image[row][col] = val;
	}

}
