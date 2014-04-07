package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.ReplaceSpacesInString;

@RunWith(JUnit4.class)
public class ReplaceSpacesInStringTest {

	@Test
	public void testReplaceSpace() {
		
		String input = "Mr John Smith    ";
		String output = "Mr%20John%20Smith";
		
		ReplaceSpacesInString rs = new ReplaceSpacesInString();
		
		assertThat("must be equal", rs.replaceSpace(input), equalTo(output));
		
	}

}
