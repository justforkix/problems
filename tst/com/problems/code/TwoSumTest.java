package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.TwoSum;

@RunWith(JUnit4.class)
public class TwoSumTest {
	
	@Test
	public void testTwoSum() {
		int[] input = {3, 4, 6, 8, 2};
		int target = 12;
		
		TwoSum twoSum = new TwoSum();
		int[] result = twoSum.twoSum(input, target);
		
		assertThat("test1", result[0], equalTo(2));
		assertThat("test2", result[1], equalTo(4));
	}
	
	@Test
	public void testTwoSum2() {
		
		int[] input = {0, 4, 3, 0};
		int target = 0;
		
		TwoSum twoSum = new TwoSum();
		int[] result = twoSum.twoSum(input, target);

		assertThat("test3", result[0], equalTo(1));
		assertThat("test4", result[1], equalTo(4));
	}


}
