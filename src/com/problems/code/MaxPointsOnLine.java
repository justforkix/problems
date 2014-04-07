package com.problems.code;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given n points on a 2D plane, find the maximum number of 
 * points that lie on the same straight line.
 */

/* Doesn't work. Time limit exceeded */
public class MaxPointsOnLine {
	
    public static double slope(Point p1, Point p2) {
    	if (p1.getX() == p2.getX()) {
    		return Double.MAX_VALUE;
    	}
        return ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
     }

    public static class Point {
        private int x;
        private int y;
        
        public Point() {
            this.x = 0;
            this.y = 0;
        }
        
        public Point(int a, int b) {
            this.x = a;
            this.y = b;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        @Override
        public String toString() {
        	String result = "(" +  this.x + "," + this.y + ")";
        	return result;
        }
    }
    
    public static class Line {
      
        private Set<Point> points = new HashSet<Point>();
        Point p1;
        Point p2;
        
        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
            points.add(p1);
            points.add(p2);
        }
        
        public Point getPoint() {
            return new Point(p1.getX(), p1.getY());
        }
        
        public Set<Point> getPoints() {
            return Collections.unmodifiableSet(points);
        }
        
        @Override
        public String toString() {
        	return "<[" + this.getPoint() + "]:" + "(" + points.toString() + ")>";
        }
        
        public void add(Line line) {
            points.addAll(line.getPoints());
        }
        
        public int size() {
            return points.size();
        }
        
        public double slope() {
        	return MaxPointsOnLine.slope(this.p1, this.p2);
        }
           
        public boolean sameLine(Line line) {
            Point other = line.getPoint();
            
            double slope = MaxPointsOnLine.slope(this.p1, other);
            
            if (this.slope() == line.slope() && this.slope() == slope) {
            	return true;
            } else {
            	return false;
            }
        } 
        
    }
    
    public int maxPoints(Point[] points) {
        
        Queue<Line> lines = new LinkedList<Line>();
        
        Queue<Point> queue = new LinkedList<Point>();
        for (Point point : points) {
            queue.add(point);
        }
        
        while(!queue.isEmpty()) {
            Point start = queue.remove();
            Iterator<Point> iterator = queue.iterator();
            
            while(iterator.hasNext()) {
                Point end = iterator.next();
                Line line = new Line(start, end);
                lines.add(line);
            }           
        }
        
        List<Line> finalList = new LinkedList<Line>();
        
        while(!lines.isEmpty()) {
            Line startLine = lines.remove();
            finalList.add(startLine);
            Iterator<Line> lineIterator = lines.iterator();
            while(lineIterator.hasNext()) {
                Line line = lineIterator.next();
                if (startLine.sameLine(line)) {
                    startLine.add(line);
                    System.out.println(startLine);
                    lineIterator.remove();
                }
            }
        }
        
        int result = 0;        
        for(Line line : finalList) {
            int lineSize = line.size();
            if (lineSize > result) {
                result = lineSize;
            }
        }
        
        return result;     
    }
        
}
