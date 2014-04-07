package com.problems.code;

import java.util.BitSet;

/**
 * If an element of an M x N matrix is 0, set it's entire row & column to 0.
 *
 */
public class ZeroMatrix {

    public void resetMatrix(int[][] input) {
        
        int rows = input.length;
        int cols = input[0].length;
        
        BitSet row = new BitSet(rows);
        BitSet col = new BitSet(cols);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (input[i][j] == 0) {
                    row.set(i);
                    col.set(j);
                }
            }
        }
        
        for(int i=0; i < rows; i++) {
            if (row.get(i)) {
                for(int j= 0; j < cols; j++) {
                    input[i][j] = 0;
                }
            }
        }
        
        for(int j=0; j < cols; j++) {
            if (col.get(j)) {
                for (int i=0; i < rows; i++) {
                    input[i][j] = 0;
                }
            }
        }
		
	}

}
