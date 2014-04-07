package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.StringCompression;

@RunWith(JUnit4.class)
public class StringCompressionTest {

	@Test
	public void testStringCompression() {
		
		StringCompression sc = new StringCompression();
		String s1 = "aabcccccaaa";
		String s2 = "abc";
		
		assertThat("must be compressed", sc.compress(s1), equalTo("a2b1c5a3"));
		assertThat("must not be compressed ", sc.compress(s2), equalTo("abc"));
		
	}

}
