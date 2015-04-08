package com.baliushin.calculator.expression.rpn;

import java.io.IOException;
import java.util.*;

import com.baliushin.calculator.expression.Operator;

/**
 * Converter from Prefix Notation to Reverse Polish Notation
 * 
 * @author Andrei Baliushin
 *
 */
public class RPNconverter {
	
	/**
	 * Convert tokens to Reverse Polish Notation.
	 * 
	 * @param tokens -- each token is operation, bracket or number
	 * @return tokens in RPN
	 * @see http://en.wikipedia.org/wiki/Reverse_Polish_notation
	 */
	public List<String> convert(List<String> tokens) throws IOException {
		// Shunting-yard algorithm

		Stack<String> resultRPNStack = new Stack<>();
		Stack<String> operatorsStack = new Stack<>();
		
		// handle unary "minus" in front of expression
		// convert "-1" to "0-1"
		if (tokens.get(0).equals(Operator.SUBTRACT.getOperationAsString())) {
			resultRPNStack.push("0"); 
		}
		
		for(int i = 0; i < tokens.size(); i++) {
			
			//operator
			if(Operator.isOperator(tokens.get(i))) {
				while (!operatorsStack.empty() && !operatorsStack.peek().equals("(")
						&& Operator.isOperationInPriorityOrEqual(Operator.getOperator(operatorsStack.peek()),
								Operator.getOperator(tokens.get(i)))) {
					resultRPNStack.push(operatorsStack.pop());
				}
				
				operatorsStack.push(tokens.get(i));
			}
			
			//"("
			else if (tokens.get(i).equals("(")) {
				
				// handle unary "minus"
				// convert "(-1)" to "(0-1)"
				if (i < (tokens.size() - 2) && tokens.get(i + 1).equals("-")) {
					resultRPNStack.push("0"); 
				}
				
				operatorsStack.push(tokens.get(i));
			}
			
			//")"
			else if (tokens.get(i).equals(")")) {
				try {
					while (!operatorsStack.peek().equals("(")) {
						resultRPNStack.push(operatorsStack.pop());
					}
				} catch (EmptyStackException e) {
					throw new IOException("'(' is missing");
				}
				operatorsStack.pop();
			}
			
			//number
			else {
				resultRPNStack.push(tokens.get(i));
			}
		}
		
		while (!operatorsStack.empty()) {
			resultRPNStack.push(operatorsStack.pop());
		}

		return resultRPNStack;
	}
}
