package com.problems.code;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishNotation {
	
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> stack = new LinkedList<Integer>();
        int result;
        int val1;
        int val2;
        for(String token : tokens) {
        	
            switch(token) {
                case "+": 
                	val2 =  stack.pollFirst();
                	val1 = stack.pollFirst();
                    result = val1 + val2;
                    stack.offerFirst(result);
                    break;
                case "-": 
                	val2 =  stack.pollFirst();
                	val1 = stack.pollFirst();
                    result = val1 - val2;
                    stack.offerFirst(result);
                    break;
                case "*": 
                	val2 =  stack.pollFirst();
                	val1 = stack.pollFirst();
                    result = val1 * val2;
                    stack.offerFirst(result); 
                    break;
                case "/":
                	val2 =  stack.pollFirst();
                	val1 = stack.pollFirst();
                    result = val1 / val2;
                    stack.offerFirst(result);
                    break;
                default:
                    stack.offerFirst(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pollFirst();
    }

}
