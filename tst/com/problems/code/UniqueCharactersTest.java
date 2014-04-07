package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.UniqueCharacters;

@RunWith(JUnit4.class)
public class UniqueCharactersTest {

	@Test
	public void testhasUnique1() {
		UniqueCharacters uc = new UniqueCharacters();
		
		 String input1 = "asdfasdfasdfas";
		 String input2 = "abc defghi";
		 
		 assertFalse("expect to return false", uc.hasUnique1(input1));
		 assertTrue("expect to return true", uc.hasUnique1(input2));
		 
		 assertFalse("expect to return false", uc.hasUnique2(input1)); 
		 assertTrue("expect to return true", uc.hasUnique2(input2));
		 
		 assertFalse("expect to return false", uc.hasUnique3(input1));
		 assertTrue("expect to return true", uc.hasUnique3(input2));
	}

}
