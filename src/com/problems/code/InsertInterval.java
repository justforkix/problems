package com.problems.code;

import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary). You may assume that the intervals were
 * initially sorted according to their start times. Example 1:Given intervals
 * [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9]. Example 2:Given
 * [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
 * [1,2],[3,10],[12,16]. This is because the new interval [4,9] overlaps with
 * [3,5],[6,7],[8,10].
 */
public class InsertInterval {

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {

		ArrayList<Interval> results = new ArrayList<Interval>();
		Interval current = newInterval;
		boolean found = false;

		for (Interval interval : intervals) {

			if (InsertInterval.isAfter(current, interval)) {
				results.add(interval);
			} else if (InsertInterval.isOverlap(current, interval)) {
				current = InsertInterval.merge(current, interval);
			} else {
				if (!found) {
					results.add(current);
					found = true;
				}
				results.add(interval);
			}

		}

		if (!found) {
			results.add(current);
		}
		return results;

	}

	// is 'a' before 'b'
	public static boolean isBefore(Interval a, Interval b) {
		return a.end < b.start;
	}

	// is 'a' after 'b'
	public static boolean isAfter(Interval a, Interval b) {
		return a.start > b.end;
	}

	// do 'a' and 'b' overlap
	public static boolean isOverlap(Interval a, Interval b) {
		return ((b.start >= a.start && b.start <= a.end) || (a.start >= b.start && a.start <= b.end));
	}

	// merge 'a' and 'b'
	public static Interval merge(Interval a, Interval b) {
		int start = 0;
		int end = 0;

		if (a.start < b.start) {
			start = a.start;
		} else {
			start = b.start;
		}

		if (a.end > b.end) {
			end = a.end;
		} else {
			end = b.end;
		}

		return new Interval(start, end);
	}

}
