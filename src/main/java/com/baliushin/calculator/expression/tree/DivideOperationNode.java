package com.baliushin.calculator.expression.tree;

public class DivideOperationNode extends OperationNode {

	public Double evaluate() {
		return leftNode.evaluate() / rightNode.evaluate();
	}
	
}
