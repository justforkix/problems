package com.problems.code;

/**
 * Sort a linked list using insertion sort.
 * 
 */
public class InsertionSortList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode result = head;
		ListNode first = head;
		ListNode curr = head.next;
		ListNode curr_prev = head;

		while (curr != null) {
			ListNode temp = curr;
			ListNode temp_prev = curr_prev;

			ListNode prev = null;
			boolean hit = false;
			while (first != temp) {
				if (first.val > temp.val) {
					hit = true;
					break;
				}
				prev = first;
				first = first.next;
			}
			if (hit) {
				curr = curr.next;
				temp_prev.next = temp.next;
				if (prev != null) {
					prev.next = temp;
				} else {
					result = temp;
				}
				temp.next = first;
			} else {
				curr_prev = curr;
				curr = curr.next;
			}

			first = result;
		}
		return result;

	}
}
