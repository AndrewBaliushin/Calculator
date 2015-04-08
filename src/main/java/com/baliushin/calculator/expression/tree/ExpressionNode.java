package com.baliushin.calculator.expression.tree;

public interface ExpressionNode {
	
	public Double evaluate();
	
	public boolean isSane();

}
