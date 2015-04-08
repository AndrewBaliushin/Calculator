package com.baliushin.calculator.expression;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
	ADD("+", 1), SUBTRACT("-", 1), MULTIPLY("*", 2), DIVIDE("/", 2);
	
	private final String operationAsString;
	
	/**
	 * Priority in prefix notation
	 */
	private final int priority;
	
	private static final Map<String, Operator> operatorsLookup = new HashMap<String, Operator>();
	static {
		for(Operator o : Operator.values()) {
			operatorsLookup.put(o.operationAsString, o);
		}
	}
	
	private Operator(String operator, int priority) {
		this.operationAsString = operator;
		this.priority = priority;
	}
	
	/**
	 * Get String representation of operation.
	 * 
	 * @return 
	 */
	public String getOperationAsString() {
		return operationAsString;
	}
	
	/**
	 * Return true if operation have priority in prefix notation.
	 * 
	 * @param op
	 * @param compareToOp
	 * @return
	 */
	public static boolean isOperationInPriorityOrEqual(Operator op, Operator compareToOp) {
		return (op.priority >= compareToOp.priority);
	}
	
	/**
	 * Get operator by it's String alias ("+", "-", "*", "/")
	 * 
	 * @param operation
	 * @return Operator or null if no such Operator exist.
	 */
	public static Operator getOperator(String operation) {
		return operatorsLookup.get(operation);
	}
	
	/**
	 * Check if String is alias to Operator
	 * @param operation
	 * @return
	 */
	public static boolean isOperator(String operation) {
		return operatorsLookup.containsKey(operation);
	}
}