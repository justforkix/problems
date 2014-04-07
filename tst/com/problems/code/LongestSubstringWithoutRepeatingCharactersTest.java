package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.LongestSubstringWithoutRepeatingCharacters;

@RunWith(JUnit4.class)
public class LongestSubstringWithoutRepeatingCharactersTest {

	@Test
	public void longestSubstring() {
		LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
		int result = ls.lengthOfLongestSubstring("bbbb");
		assertThat("test1", result, equalTo(1));
		
	}
	
	@Test
	public void longestSubstring2() {
		LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
		int result = ls.lengthOfLongestSubstring("abcabcbb");
		assertThat("test2", result, equalTo(3));
		
	}


}
