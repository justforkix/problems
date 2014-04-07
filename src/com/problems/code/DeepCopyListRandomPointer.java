package com.problems.code;

import java.util.HashMap;
import java.util.Map;

/**
 *A linked list is given such that each node contains an additional 
 *random pointer which could point to any node in the list or null.
 *Return a deep copy of the list. 
 */

/* Doesn't work. label not unique. */
public class DeepCopyListRandomPointer {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();

	public RandomListNode copyRandomList(RandomListNode head) {
		return deepCopy(head);
	}

	private RandomListNode deepCopy(RandomListNode node) {
		if (node == null) {
			return null;
		}

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		} else {
			RandomListNode copy = new RandomListNode(node.label);
			copy.next = deepCopy(node.next);
			copy.random = deepCopy(node.random);
			map.put(node.label, copy);
			return copy;
		}

	}

}
