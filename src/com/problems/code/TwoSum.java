package com.problems.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number. The function twoSum should return indices of the two
 * numbers such that they add up to the target, where index1 must be less than
 * index2. Please note that your returned answers (both index1 and index2) are
 * not zero-based. You may assume that each input would have exactly one
 * solution. Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {

		int index1 = 0;
		int index2 = 0;

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		int i = 0;
		for (int num : numbers) {
			if (map.containsKey(num)) {
				List<Integer> list = map.get(num);
				list.add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(num, list);
			}
			i += 1;
		}
		System.out.println(map);
		for (int j = 1; j < numbers.length; j++) {
			if (map.containsKey(target - numbers[j])) {
				List<Integer> list = map.get(target - numbers[j]);
				for (int index : list) {
					if (index < j) {
						index1 = index;
						index2 = j;
						break;
					}
				}

			}
		}

		int[] result = { index1 + 1, index2 + 1 };
		return result;

	}
}
