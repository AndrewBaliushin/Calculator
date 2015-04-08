package com.baliushin.calculator.expression.tree;

public class ValueNode implements ExpressionNode {
	
	private Double value;
	
	public ValueNode(Double value) {
		this.value = value;
	}

	public Double evaluate() {
		return value;
	}

	public boolean isSane() {
		return true;
	}
}
