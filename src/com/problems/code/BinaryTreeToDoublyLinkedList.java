package com.problems.code;

/**
 *  In-order traversal with a binary tree and
 *  turn it into a doubly-linked list in place.
 */
public class BinaryTreeToDoublyLinkedList {

    private TreeNode head;
    
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      
      public TreeNode(int val, TreeNode left, TreeNode right) {
    	  this.val = val;
    	  this.left = left;
    	  this.right = right;
      }
      
      public String list() {
    	  StringBuilder sb = new StringBuilder();
    	  TreeNode current = this;
    	  while(current != null ) {
    		  String left = "null";
    		  String right = "null";
    		  if (current.left != null) {
    			  left = String.valueOf(current.left.val);
    		  }
    		  if (current.right != null) {
    			  right = String.valueOf(current.right.val);
    		  }
    		  sb.append("<" + left + "(" + current.val + ")" + right + ">" + " --> ");
    		  current = current.right;
    	  }
    	  return sb.toString();
      }
    }
    
    public void bstToDoublyLinkedList(TreeNode root) {
    	inOrderRecursive(root, null); 
    }
    
    private TreeNode inOrderRecursive(TreeNode node, TreeNode previous) {
        if (node == null) {
            return previous;
        }
        
        TreeNode left_previous = inOrderRecursive(node.left, previous);
        if (left_previous != null) {
          left_previous.right = node;
        } else {
            this.head = node;
        }
        node.left = left_previous;
        TreeNode right_previous = inOrderRecursive(node.right, node);
        return right_previous;
    }
    
	public static void main(String[] args) {
		TreeNode node_4 = new TreeNode(4, null, null);
		TreeNode node_5 = new TreeNode(5, null, null);
		TreeNode node_6 = new TreeNode(6, null, null);
		TreeNode node_7 = new TreeNode(7, null, null);
		TreeNode node_2 = new TreeNode(2, node_4, node_5);
		TreeNode node_3 = new TreeNode(3, node_6, node_7);
		TreeNode node_1 = new TreeNode(1, node_2, node_3);
		
		BinaryTreeToDoublyLinkedList bt = new BinaryTreeToDoublyLinkedList();
		bt.bstToDoublyLinkedList(node_1);
		System.out.println(bt.head.list());
		
	}

}
