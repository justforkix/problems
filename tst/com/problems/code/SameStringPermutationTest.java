package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.SameStringPermutation;

@RunWith(JUnit4.class)
public class SameStringPermutationTest {

	@Test
	public void testSameString1() {
		String s1 = "hello there";
		String s2 = "loetlh reeh";
		String s3 = "loetlh rerh";
		
		SameStringPermutation sp = new SameStringPermutation();
				
		assertTrue("must be same", sp.sameString1(s1, s2));
		assertFalse("must be different", sp.sameString1(s1, s3));
		
		assertTrue("must be same", sp.sameString2(s1, s2));
		assertFalse("must be different", sp.sameString2(s1, s3));

	}

}
