package com.problems.code;

/**
 * Find the kth to last element of a singly linked list.
 */
public class KthToLastElementSinglyLinkedList {

	static class Node {
	    int val;
	    Node next;
	    
	    public Node(int val, Node next) {
	        this.val = val;
	        this.next = next;
	    }
	    
	    @Override
	    public boolean equals(Object obj) {
	    	if (obj == null) {
	    		return false;
	    	}
	    	if (this == obj) {
	    		return true;
	    	}
	    	if (!(obj instanceof Node)) {
	    		return false;
	    	} else {
	    		Node other = (Node) obj;
	    		return (this.val == other.val);
	    	}
	    }
	}
	
	public Node KthFromLast(Node head, int k) {
	    if (head == null) {
	        throw new NullPointerException();
	    }
	    Node current = head;
	    Node result = null;
	    int i = 0;
	    while(current != null) {
	        if (i == k) {
	        	result = head;
	        }
	        if (i > k) {
	        	result = result.next;
	        }
	        i++;
	        current = current.next;        
	    }
	    return result;
	}
}

