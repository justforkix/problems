package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.RotateImage;

@RunWith(JUnit4.class)
public class RotateImageTest {

	@Test
	public void testRotate90_size4() {
		
		RotateImage ri = new RotateImage();
		int[][] input = new int[2][2];
		input[0][0] = 1;
		input[0][1] = 2;
		input[1][0] = 3;
		input[1][1] = 4;
		
		int[][] output = new int[2][2];
		output[0][0] = 3;
		output[0][1] = 1;
		output[1][0] = 4;
		output[1][1] = 2;
		
		System.out.println(Arrays.deepToString(input));
		ri.rotate90(input);
		System.out.println(Arrays.deepToString(input));
		
		assertThat("must be same", input, equalTo(output));

	}
	
	@Test
	public void testRotate90_size9() {
		
		RotateImage ri = new RotateImage();
		int[][] input = new int[3][3];
		input[0][0] = 1;
		input[0][1] = 2;
		input[0][2] = 3;
		input[1][0] = 4;
		input[1][1] = 5;
		input[1][2] = 6;
		input[2][0] = 7;
		input[2][1] = 8;
		input[2][2] = 9;

		
		int[][] output = new int[3][3];
		output[0][0] = 7;
		output[0][1] = 4;
		output[0][2] = 1;
		output[1][0] = 8;
		output[1][1] = 5;
		output[1][2] = 2;
		output[2][0] = 9;
		output[2][1] = 6;
		output[2][2] = 3;
		
		System.out.println(Arrays.deepToString(input));
		ri.rotate90(input);
		System.out.println(Arrays.deepToString(input));
		
		assertThat("must be same", input, equalTo(output));

	}


}
