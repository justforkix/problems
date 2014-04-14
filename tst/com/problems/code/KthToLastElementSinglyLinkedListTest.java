package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.KthToLastElementSinglyLinkedList.Node;


@RunWith(JUnit4.class)
public class KthToLastElementSinglyLinkedListTest {

	@Test
	public void testKthToLast() {
		
		Node node7 = new Node(7, null);
		Node node6 = new Node(6, node7);
		Node node5 = new Node(5, node6);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		
		KthToLastElementSinglyLinkedList kle = new KthToLastElementSinglyLinkedList();
		assertThat("must be equal", kle.KthFromLast(node1, 0), equalTo(node7));
		assertThat("must be equal", kle.KthFromLast(node1, 1), equalTo(node6));
		assertThat("must be equal", kle.KthFromLast(node1, 2), equalTo(node5));
		assertThat("must be equal", kle.KthFromLast(node1, 3), equalTo(node4));
		assertThat("must be equal", kle.KthFromLast(node1, 4), equalTo(node3));
		assertThat("must be equal", kle.KthFromLast(node1, 5), equalTo(node2));
		assertThat("must be equal", kle.KthFromLast(node1, 6), equalTo(node1));
		
	}


}
