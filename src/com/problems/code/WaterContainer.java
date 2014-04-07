package com.problems.code;

/**
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) 
 * and (i, 0). Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 */
// Doesn't work
public class WaterContainer {

    public int maxArea(int[] height) {
        
        int maxArea = 0;
        int temp = 0;
        int current = 0;
        
        for(int j=1; j < height.length; j++) {
            if (height[current] < height[j]) {
                temp = temp + height[current];
                if (temp > maxArea) {
                    maxArea = temp;
                }
                temp = 0;
                current = j;
            } else {
                temp = temp + height[current];
            }
        }
        if (temp > maxArea) {
            maxArea = temp;
        }

        return maxArea;
        
    }

}
