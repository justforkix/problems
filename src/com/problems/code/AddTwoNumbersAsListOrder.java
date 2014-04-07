package com.problems.code;

/**
 * This assumes zeros on the end if one list is smaller than the other.
 * Instead we must take the difference in the size of the lists and recurse from
 * that many nodes down or just tag additional zero nodes in the front.
 */
public class AddTwoNumbersAsListOrder {
	
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
	
	static class Result {
		int carry;
		ListNode value;
		
		Result(int carry, ListNode value) {
			this.carry = carry;
			this.value = value;
		}
	}

	public ListNode addTwoNumbersOrder(ListNode head1, ListNode head2) {
		int carry = 0;
		Result result = addRecursive(head1, head2, carry);
		if(result.carry == 1) {
			ListNode node = new ListNode(result.carry);
			node.next = result.value;
			return node;
		} else {
			return result.value;
		}
	}
	
	private Result addRecursive(ListNode node1, ListNode node2, int carry) {
		int sum = 0;
		int x1 = 0;
		int x2 = 0;
		ListNode node1_next = null;
		ListNode node2_next = null;
		
		if (node1 == null && node2 == null) {
			return new Result(carry, null);
		}
		if (node1 != null) {
			x1 = node1.val;
			node1_next = node1.next;
		} 
		
		if (node2 != null) {
			x2 = node2.val;
			node2_next = node2.next;
		}
		
		Result prev =  addRecursive(node1_next, node2_next, carry);
		sum = (x1 + x2 + prev.carry) % 10;
		carry = (x1 + x2 + prev.carry) / 10;
		ListNode value = new ListNode(sum);
		value.next = prev.value;
		return new Result(carry, value);
		
	}
	
	public static void main(String[] args) {
		AddTwoNumbersAsListOrder as = new AddTwoNumbersAsListOrder();
		ListNode l1 = new ListNode(9);
		ListNode l1a =  new ListNode(9);
	    ListNode l1b =  new ListNode(9);
		l1.next = l1a;
		l1a.next = l1b;
		l1b.next = null;
		
		ListNode l2 = new ListNode(9);
		ListNode l2a =  new ListNode(9);
		ListNode l2b =  new ListNode(9);
		l2.next = l2a;
		l2a.next = null;
		l2b.next = null;

		
		ListNode result = as.addTwoNumbersOrder(l1, l2);
		System.out.println(result);
	}


}
