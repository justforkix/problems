package com.problems.code;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number. The digits are stored such that the most significant digit is at
 * the head of the list.
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
		int carry = 1;
		int[] result = new int[digits.length];

		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = (digits[i] + carry) % 10;
			result[i] = sum;
			carry = (digits[i] + carry) / 10;
		}

		if (carry == 1) {
			int[] answer = new int[result.length + 1];
			answer[0] = carry;
			for(int i=0; i < result.length; i++) {
				answer[i+1] = result[i];
			}
			return answer;
		} else {
			return result;
		}
	}

}
