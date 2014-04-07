package com.problems.code;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level). For example: Given binary tree
 * {3,9,20,#,#,15,7},
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * return its level order traversal as:
 * 
 * [ [3], [9,20], [15,7] ]
 * 
 */
public class LevelOrderTraversalList {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		LinkedList<ArrayList<TreeNode>> queue = new LinkedList<ArrayList<TreeNode>>();

		if (root != null) {
			ArrayList<Integer> rootList = new ArrayList<Integer>();
			rootList.add(root.val);
			result.add(rootList);
			ArrayList<TreeNode> rootNodeList = new ArrayList<TreeNode>();
			rootNodeList.add(root);
			queue.add(rootNodeList);
		}

		while (!queue.isEmpty()) {
			ArrayList<TreeNode> list = queue.poll();
			ArrayList<Integer> valList = new ArrayList<Integer>();
			ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();

			for (TreeNode node : list) {

				if (node.left != null) {
					valList.add(node.left.val);
					nodeList.add(node.left);
				}
				if (node.right != null) {
					valList.add(node.right.val);
					nodeList.add(node.right);
				}
			}

			if (!valList.isEmpty()) {
				result.add(valList);
			}
			if (!nodeList.isEmpty()) {
				queue.add(nodeList);
			}

		}
		return result;
	}

}
