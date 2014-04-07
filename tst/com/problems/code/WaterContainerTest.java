/**
 * 
 */
package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.WaterContainer;


@RunWith(JUnit4.class)
public class WaterContainerTest {

	@Test
	public void testWaterContainer() {
		
		WaterContainer wc = new WaterContainer();
		
		int[] test1 = {0,0,0,0};		
		assertThat("test1", wc.maxArea(test1), equalTo(0));
		
		int[] test2 = {0,1,0,0};
		assertThat("test2", wc.maxArea(test1), equalTo(0));
	}


}
