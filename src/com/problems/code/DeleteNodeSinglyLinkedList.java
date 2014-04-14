package com.problems.code;

/**
 * Delete a node in the middle of a singly linked list,
 * given only access to that node.
 */

/*
 * Doesn't work if the node to be deleted is the last one.
 */
public class DeleteNodeSinglyLinkedList {
	
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
    
    public void deleteNode(Node node) {
    	node.val = node.next.val;
    	Node tmp = node.next;
    	node.next = tmp.next;
    	tmp.next = null;
    }
    
	public static void main(String[] args) {
		
		Node node5 = new Node(5, null);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		
		System.out.println(node1.list());
		
		DeleteNodeSinglyLinkedList dl = new DeleteNodeSinglyLinkedList();
		dl.deleteNode(node3);
		
		System.out.println(node1.list());
		

	}

}
