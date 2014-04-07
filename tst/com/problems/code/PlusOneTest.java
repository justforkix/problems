package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.PlusOne;

@RunWith(JUnit4.class)
public class PlusOneTest {

	@Test
	public void testPlusOne() {
		int[] digits = {0};
		PlusOne po = new PlusOne();
		int[] result = po.plusOne(digits);
		System.out.println(Arrays.toString(result));
	}

}
