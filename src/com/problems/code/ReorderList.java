package com.problems.code;

/**
 * Given a singly linked list L: L0->L1->...->Ln-1->Ln, reorder it to:
 * L0->Ln->L1->Ln-1->L2->Ln-2->... You must do this in-place without altering the nodes'
 * values. For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

/* Doesn't work */
public class ReorderList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
		
		@Override 
		public String toString() {
			ListNode node = this;
			StringBuilder sb = new StringBuilder();
			while(node != null) {
				sb.append(node.val + "-->");
				node = node.next;
			}
			return sb.toString();
		}

	}

	// time limit exceeded
	public void reorderList(ListNode head) {
		reorder(head);
	}

	private ListNode reorder(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode last = removeLast(head);
		ListNode newHead = removeFirst(head);
		
		head.next = last;
		if (last != null) {
			last.next = reorder(newHead);
		}
		return head;
	}

	private ListNode removeFirst(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode newHead = head.next;
		head.next = null;
		return newHead;
	}

	private ListNode removeLast(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode curr = head.next;
		ListNode prev_prev = null;
		ListNode prev = head;

		while (curr != null) {
			prev_prev = prev;
			prev = curr;
			curr = curr.next;
		}
		if (prev_prev != null) {
			prev_prev.next = null;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 =  new ListNode(2);
	    ListNode l3 =  new ListNode(3);
	    ListNode l4 = new ListNode(4);
		ListNode l5 =  new ListNode(5);
		ListNode l6 =  new ListNode(6);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;	
		l4.next = l5;
		l5.next = null;
		l6.next = null;

		System.out.println(l1);
		ReorderList rl = new ReorderList();
		rl.reorderList(l1);
		System.out.println(l1);
	}


}
