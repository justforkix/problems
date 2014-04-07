package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.ReversePolishNotation;

@RunWith(JUnit4.class)
public class ReversePolishNotationTest {
	
	@Test
	public void testRPN() {
		
		String[] input1 = {"2", "1", "+", "3", "*"};
		String[] input2 = {"4", "13", "5", "/", "+"};
		
		ReversePolishNotation rpn = new ReversePolishNotation();
		
		assertThat("test1", rpn.evalRPN(input1), equalTo(9));
		assertThat("test2", rpn.evalRPN(input2), equalTo(6));
	}

}
