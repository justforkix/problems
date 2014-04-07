package com.problems.code;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center). For example, this binary tree is symmetric:
 */

/* Iterative doesn't work  */
public class SymmetricTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetricRecursive(TreeNode root) {
		if (root == null) {
			return true;
		}
		return mirrorRecursive(root.left, root.right);
	}

	private boolean mirrorRecursive(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		} else if (node1 == null && node2 != null) {
			return false;
		} else if (node1 != null && node2 == null) {
			return false;
		} else {
			return (node1.val == node2.val && mirrorRecursive(node1.left, node2.right) && mirrorRecursive(
					node1.right, node2.left));
		}
	}
	
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Deque<TreeNode> deque1a = new LinkedList<TreeNode>();
        Deque<TreeNode> deque1b = new LinkedList<TreeNode>();
        Deque<TreeNode> deque2a = new LinkedList<TreeNode>();
        Deque<TreeNode> deque2b = new LinkedList<TreeNode>();
        
        if (root.left != null) {
            deque1a.offerFirst(root.left);
            deque1b = fillLeft(deque1a);
        }
        
        if (root.right != null) {
            deque2a.offerFirst(root.right);
            deque2b = fillRight(deque2a);
        }
        
        if (deque1b.size() != deque2b.size()) {
            return false;
        } 
        
        while(!deque1b.isEmpty() && !deque2b.isEmpty()) {
            TreeNode node1b = deque1b.pollFirst();
            TreeNode node2b = deque2b.pollFirst();
            if (node1b.val != node2b.val) {
                return false;
            }
        }
        
        return true;
        
    }   
    
    private Deque<TreeNode> fillLeft(Deque<TreeNode> deque) {
        Deque<TreeNode> results = new LinkedList<TreeNode>();
        while(!deque.isEmpty() ) {
            TreeNode node = deque.pollFirst();
            if (node.left != null) {
                deque.offerFirst(node.left);
            } 
            if (node.right != null) {
                deque.offerFirst(node.right);
            }
            results.offerLast(node);
        }
        return results;
    }
    
        private Deque<TreeNode> fillRight(Deque<TreeNode> deque) {
        Deque<TreeNode> results = new LinkedList<TreeNode>();
        while(!deque.isEmpty() ) {
            TreeNode node = deque.pollFirst();
            if (node.right != null) {
                deque.offerFirst(node.right);
            } 
            if (node.left != null) {
                deque.offerFirst(node.left);
            }
            results.offerLast(node);
        }
        return results;
    }


}
