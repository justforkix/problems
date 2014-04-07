package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.LongestPalindrome;

@RunWith(JUnit4.class)
public class LongestPalindromeTest {
	
	@Test
	public void testLongestPalindrome() {
		
		LongestPalindrome lp = new LongestPalindrome();
		
		//String test1 = "this is a test a nut for a jar of tuna hello there";
		 String test2 = "able was I ere I saw elba";
		
		// assertThat("test1", lp.longestPalindrome(test1), equalTo("a nut for a jar of tuna"));
		assertThat("test2", lp.longestPalindrome(test2), equalTo("able was I ere I saw elba"));
	
	}

}
