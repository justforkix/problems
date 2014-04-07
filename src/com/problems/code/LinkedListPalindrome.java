package com.problems.code;

/**
 * Implement a function to check if a linked list is a palindrome
 */
public class LinkedListPalindrome {

	static class Result {
		Node node;
		boolean flag;

		Result() {
		};

		Result(Node node, boolean flag) {
			this.node = node;
			this.flag = flag;
		}
	}

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

			if (obj instanceof Node) {
				Node other = (Node) obj;
				return (this.val == other.val);
			} else {
				return false;
			}
		}

		@Override
		public String toString() {
			return String.valueOf(this.val);
		}

	}

	public boolean isPalindrome(Node head) {
		if (head == null) {
			throw new IllegalArgumentException("invalid argument");
		}

		int size = 0;
		Node first = head;

		while (first != null) {
			size++;
			first = first.next;
		}

		if (size == 1) {
			return true;
		}

		int pos = 0;
		if (size % 2 == 0) {
			pos = (size / 2) + 1;
		} else {
			pos = (size / 2) + 2;
		}

		Node current = null;
		int i = 1;
		first = head;

		while (i <= pos) {
			current = first;
			first = first.next;
			i++;
		}

		Result result = eval(head, current);
		return result.flag;
	}

	private Result eval(Node head, Node current) {

		if (current.next == null) {
			Result result = new Result();
			result.flag = head.equals(current);
			result.node = head.next;
			return result;
		} else {
			Result prev_result = eval(head, current.next);
			if (prev_result.flag) {
				Result result = new Result();
				result.flag = prev_result.node.equals(current);
				result.node = head.next;
				return result;
			} else {
				return new Result(null, false);
			}
		}

	}

}
