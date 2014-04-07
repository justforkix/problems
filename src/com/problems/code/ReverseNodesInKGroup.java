package com.problems.code;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time 
 * and return its modified list. If the number of nodes is not a multiple 
 * of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k cannot be 0");
        }
        if (head == null) {
            return head;
        }
        ListNode chop = cutList(head, k);
        ListNode node = reversedList(head, k);
        if (node != head || (node == head && node.next == null)) {
            head.next = reverseKGroup(chop, k);
        }
       
        return node;
    }
    
    private ListNode cutList(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        
        int i = 0;
        while(curr != null) {
        	
            i++;
            prev = curr;
            curr = curr.next;
            
            if (i == k) {
                break;
            }
        }
        
        prev.next = null;
        return curr;
    }
    
    private ListNode reversedList(ListNode head, int k) {
        ListNode curr = head;
        int i = 0;
        while(curr != null) {
            i++;
            curr = curr.next;
        }
        if (i < k) {
            return head;
        } else {
            return reverseList(head);
        }
    }
    
    private ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        
        ListNode next = head.next;
        head.next = null;
        ListNode node = reverseList(next);
        next.next = head;
        return node;
    }

}
