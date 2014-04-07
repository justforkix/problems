package com.problems.code;

/**
 * Partition a linked list around a value x, such that all nodes less than x
 * come before all nodes greater than or equal to x.
 * 
 */
public class PartitionLinkedList {

	static class Node {
		int val;
		Node next;

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
		
		public String list() {
			Node current = this;
			StringBuilder sb = new StringBuilder();
			
			while(current != null) {
				sb.append(current.val + " --> ");
				current = current.next;
			}
			return sb.toString();
		}
 	}

	public Node partition(Node head, Node partition) {

		Node current = head;
		Node previous = null;
		boolean before = true;

		while (current != null) {
			if (current == partition) {
				before = false;
				previous = current;
				current = current.next;
				continue;
			}

			if (before) {
				if (current.val < partition.val) {
					previous = current;
					current = current.next;
				} else {
					Node temp_current = current;
					current = temp_current.next;

					if (temp_current == head) {
						head = temp_current.next;
					} else {
						previous.next = temp_current.next;
					}

					temp_current.next = partition.next;
					partition.next = temp_current;
				}
			} else {
				if (current.val >= partition.val) {
					previous = current;
					current = current.next;
				} else {
					Node temp_current = current;
					current = temp_current.next;

					previous.next = temp_current.next;
					Node temp = head;
					head = temp_current;
					temp_current.next = temp;
				}
			}

		}

		return head;
	}
	
	public static void main(String[] args) {
	
		Node node9 = new Node(1, null);
		Node node8 = new Node(9, node9);
		Node node7 = new Node(4, node8);
		Node node6 = new Node(5, node7);
		Node node5 = new Node(6, node6);
		Node node4 = new Node(3, node5);
		Node node3 = new Node(7, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(8, node2);
		
		System.out.println(node1.list());
		
		PartitionLinkedList pl = new PartitionLinkedList();
		Node head = pl.partition(node1, node6);
		
		System.out.println(head.list());
		

	}


}
