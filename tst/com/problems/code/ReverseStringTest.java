package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.ReverseString;

@RunWith(JUnit4.class)
public class ReverseStringTest {

	@Test
	public void testReverseString() {
		ReverseString rs = new ReverseString();
		
		String test1 = "   ";
		String test2 = "bird";
		String test3 = " bird";
		String test4 = "   bird";
		String test5 = "   bird ";
		String test6 = "   bird   ";
		String test7 = "bird is the word";
		String test8 = "   bird is the word   ";
		String test9 = "   bird  is    the word";
		String test10 = "   bird   is   the   word   ";
		
		
		assertThat(test1, rs.reverseString(test1), equalTo(""));
		assertThat(test2, rs.reverseString(test2), equalTo("bird"));
		assertThat(test3, rs.reverseString(test3), equalTo("bird"));
		assertThat(test4, rs.reverseString(test4), equalTo("bird"));
		assertThat(test5, rs.reverseString(test5), equalTo("bird"));
		assertThat(test6, rs.reverseString(test6), equalTo("bird"));
		assertThat(test7, rs.reverseString(test7), equalTo("word the is bird"));
		assertThat(test8, rs.reverseString(test8), equalTo("word the is bird"));
		assertThat(test9, rs.reverseString(test9), equalTo("word the is bird"));
		assertThat(test10, rs.reverseString(test10), equalTo("word the is bird"));
		
		assertThat(test1, rs.reverseStringImproved(test1), equalTo(""));
		assertThat(test2, rs.reverseStringImproved(test2), equalTo("bird"));
		assertThat(test3, rs.reverseStringImproved(test3), equalTo("bird"));
		assertThat(test4, rs.reverseStringImproved(test4), equalTo("bird"));
		assertThat(test5, rs.reverseStringImproved(test5), equalTo("bird"));
		assertThat(test6, rs.reverseStringImproved(test6), equalTo("bird"));
		assertThat(test7, rs.reverseStringImproved(test7), equalTo("word the is bird"));
		assertThat(test8, rs.reverseStringImproved(test8), equalTo("word the is bird"));
		assertThat(test9, rs.reverseStringImproved(test9), equalTo("word the is bird"));
		assertThat(test10, rs.reverseStringImproved(test10), equalTo("word the is bird"));
		
	}

}
