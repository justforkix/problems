package com.problems.code;

/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 *
 */
public class SortedArrayToBST {
	
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

    public TreeNode sortedArrayToBST(int[] num) {
        return convertBST(num, 0, num.length-1);
    }
    
    private TreeNode convertBST(int[] num, int min, int max) {
        if (min > max) {
            return null;
        }
        
        int mid = min + (max - min)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = convertBST(num, min, mid-1);
        node.right = convertBST(num, mid+1, max);
        return node;
        
    }

}
