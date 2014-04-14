package com.problems.code;

/**
 * Remove duplicates from an unsorted linked list.
 * Follow up - How would you solve the problem if a temporary 
 * buffer is not allowed.
 */

/* Uses two pointers. Sorting is another option */
public class RemoveDuplicatesUnsortedLinkedList {

    static class Node {
        int val;
        Node next;
        
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
        
        public String list() {
            StringBuilder sb = new StringBuilder();
            Node current = this;
            while (current != null) {
                sb.append(current.val + " --> ");
                current = current.next;
            }
            return sb.toString();
        }
    }
    
	public Node removeDuplicates(Node head) {
	    if (head == null) {
	        throw new NullPointerException("invalid input");
	    }
		Node outer = head.next;
		
		while(outer != null) {
		    Node current = head;
		    Node prev = null;
		    while(current != outer) {
		        if (current.val == outer.val) {
		            Node tmp = current;
		             current = current.next;
		            if (tmp == head) {
		                head = tmp.next;
		            } else {
		                prev.next = tmp.next;
		            }
		            tmp.next = null;
		        } else {
		            prev = current;
		            current = current.next;
		        }
		    }
		    outer = outer.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		Node node7 = new Node(5, null);
		Node node6 = new Node(3, node7);
		Node node5 = new Node(2, node6);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(1, node4);
		Node node2 = new Node(3, node3);
		Node node1 = new Node(4, node2);
		
		System.out.println(node1.list());
		
		RemoveDuplicatesUnsortedLinkedList rd = new RemoveDuplicatesUnsortedLinkedList();
		Node head = rd.removeDuplicates(node1);
		
		System.out.println(head.list());

	}


}
