
package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LinkedListPalindromeTest {

	@Test
	public void testLongestPalindromeSingle() {
		
		LinkedListPalindrome lp = new LinkedListPalindrome();
		LinkedListPalindrome.Node node1 = new LinkedListPalindrome.Node(1, null);
		
		assertTrue(lp.isPalindrome(node1));
	}
	
	@Test
	public void testLongestPalindromeDouble() {
		
		LinkedListPalindrome lp = new LinkedListPalindrome();
		LinkedListPalindrome.Node node2 = new LinkedListPalindrome.Node(1, null);
		LinkedListPalindrome.Node node1 = new LinkedListPalindrome.Node(1, node2);
			
		assertTrue(lp.isPalindrome(node1));
	}
	
	@Test
	public void testLongestPalindromeEven() {
		
		LinkedListPalindrome lp = new LinkedListPalindrome();
		LinkedListPalindrome.Node node4 = new LinkedListPalindrome.Node(1, null);
		LinkedListPalindrome.Node node3 = new LinkedListPalindrome.Node(2, node4);
		LinkedListPalindrome.Node node2 = new LinkedListPalindrome.Node(2, node3);
		LinkedListPalindrome.Node node1 = new LinkedListPalindrome.Node(1, node2);
			
		assertTrue(lp.isPalindrome(node1));
	}

	@Test
	public void testLongestPalindromeOdd() {
		
		LinkedListPalindrome lp = new LinkedListPalindrome();
		LinkedListPalindrome.Node node5 = new LinkedListPalindrome.Node(1, null);
		LinkedListPalindrome.Node node4 = new LinkedListPalindrome.Node(2, node5);
		LinkedListPalindrome.Node node3 = new LinkedListPalindrome.Node(3, node4);
		LinkedListPalindrome.Node node2 = new LinkedListPalindrome.Node(2, node3);
		LinkedListPalindrome.Node node1 = new LinkedListPalindrome.Node(1, node2);
			
		assertTrue(lp.isPalindrome(node1));
	}

	@Test
	public void testLongestPalindromeOddFail() {
		
		LinkedListPalindrome lp = new LinkedListPalindrome();
		LinkedListPalindrome.Node node5 = new LinkedListPalindrome.Node(1, null);
		LinkedListPalindrome.Node node4 = new LinkedListPalindrome.Node(3, node5);
		LinkedListPalindrome.Node node3 = new LinkedListPalindrome.Node(3, node4);
		LinkedListPalindrome.Node node2 = new LinkedListPalindrome.Node(2, node3);
		LinkedListPalindrome.Node node1 = new LinkedListPalindrome.Node(1, node2);
			
		assertFalse(lp.isPalindrome(node1));
	}

	@Test
	public void testLongestPalindromeEvenFail() {
		
		LinkedListPalindrome lp = new LinkedListPalindrome();
		LinkedListPalindrome.Node node4 = new LinkedListPalindrome.Node(1, null);
		LinkedListPalindrome.Node node3 = new LinkedListPalindrome.Node(3, node4);
		LinkedListPalindrome.Node node2 = new LinkedListPalindrome.Node(2, node3);
		LinkedListPalindrome.Node node1 = new LinkedListPalindrome.Node(1, node2);
			
		assertFalse(lp.isPalindrome(node1));
	}

}
