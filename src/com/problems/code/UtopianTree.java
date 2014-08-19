package com.problems.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * The Utopian tree goes through 2 cycles of growth every year. 
 * The first growth cycle of the tree occurs during the monsoon,
 *  when it doubles in height. The second growth cycle of the tree 
 *  occurs during the summer, when its height increases by 1 meter. 
 *  Now, a new Utopian tree sapling is planted at the onset of the monsoon. 
 *  Its height is 1 meter. Can you find the height of the tree after N growth cycles?
 *  
 *  Input Format 
 *  The first line contains an integer, T, the number of test cases. 
 *  T lines follow. Each line contains an integer, N, that denotes 
 *  the number of cycles for that test case.
 *  
 *  Constraints 
 *  1 <= T <= 10 
 *  0 <= N <= 60
 *  
 *  Output Format 
 *  For each test case, print the height of the Utopian tree after N cycles.
**/
public class UtopianTree {

	public static void main(String[] args) throws IOException {
		long initialHeight = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long numTests = Long.parseLong(br.readLine());
        for (int i=0; i < numTests; i++) {
            long cycles = Long.parseLong(br.readLine());
            long height = initialHeight;
            if (cycles > 0) {
                for(int j=1; j <= cycles; j++) {
                    height = calculateGrowth(height, j);
                }
             } 
             System.out.println(height); 
        } 
	}
	
	private static long calculateGrowth(long height, int cycle) {
        if (cycle % 2 == 1) {
            return 2 * height;
        } else {
            return height + 1;
        }
    } 

}
