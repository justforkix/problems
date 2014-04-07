package com.problems.code;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.problems.code.MaxPointsOnLine;
import com.problems.code.MaxPointsOnLine.Point;

@RunWith(JUnit4.class)
public class MaxPointsOnLineTest {
	
	@Test
	public void testMaxPoints() {
		
		MaxPointsOnLine.Point p1 = new MaxPointsOnLine.Point(1,2);
		MaxPointsOnLine.Point p2 = new MaxPointsOnLine.Point(2,1);
		MaxPointsOnLine.Point p3 = new MaxPointsOnLine.Point(2,4);
		MaxPointsOnLine.Point p4 = new MaxPointsOnLine.Point(3,2);
		MaxPointsOnLine.Point p5 = new MaxPointsOnLine.Point(4,3);
		
		Point[] points = {p1, p2, p3, p4, p5};
		
		MaxPointsOnLine mp = new MaxPointsOnLine();
		
		assertThat("test1", mp.maxPoints(points), equalTo(3));

	}	

}
