package com.problems.code;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head. For example, Given linked list: 1->2->3->4->5, and n = 2. After
 * removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note: Given n will always be valid. Try to do this in one pass.
 */
public class RemoveNodeEndOfList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode curr = head;
		ListNode prev = head;
		ListNode prev_prev = null;
		int i = 0;
		boolean hit = false;
		while (curr != null) {
			if (i == n) {
				hit = true;
			}
			if (hit) {
				prev_prev = prev;
				prev = prev.next;
			}
			curr = curr.next;
			i++;
		}
		if (prev == head) {
			ListNode result = prev.next;
			prev.next = null;
			return result;
		} else {
			prev_prev.next = prev.next;
			prev.next = null;
			return head;
		}
	}
}
