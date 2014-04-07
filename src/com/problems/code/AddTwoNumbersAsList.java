package com.problems.code;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list. Input: (2 -> 4 ->
 * 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
public class AddTwoNumbersAsList {

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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0;
		int sum;
		ListNode prev = null;
		ListNode head = null;
		
		System.out.println(l1.toString());
		System.out.println(l2.toString());

		while (l1 != null || l2 != null) {
			int val1, val2;
			if (l1 == null) {
				val1 = 0;
			} else {
				val1 = l1.val;
			}

			if (l2 == null) {
				val2 = 0;
			} else {
				val2 = l2.val;
			}

			sum = carry + val1 + val2;
			carry = (int) sum / 10;
			int val = sum % 10;

			ListNode node = new ListNode(val);
			if (prev != null) {
				prev.next = node;
			}

			if (head == null) {
				head = node;
			}

			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			prev = node;
		}
		
		if (carry != 0) {
			ListNode node = new ListNode(carry);
			prev.next = node;
		}
		
		return head;

	}
	
	public static void main(String[] args) {
		AddTwoNumbersAsList as = new AddTwoNumbersAsList();
		ListNode l1 = new ListNode(2);
		ListNode l1a =  new ListNode(4);
	    ListNode l1b =  new ListNode(3);
		l1.next = l1a;
		l1a.next = l1b;
		l1b.next = null;
		
		ListNode l2 = new ListNode(5);
		ListNode l2a =  new ListNode(6);
		ListNode l2b =  new ListNode(4);
		l2.next = l2a;
		l2a.next = l2b;
		l2b.next = null;

		
		ListNode result = as.addTwoNumbers(l1, l2);
		System.out.println(result);
	}

}
