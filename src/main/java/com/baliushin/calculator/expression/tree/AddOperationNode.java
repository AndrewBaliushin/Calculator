package com.baliushin.calculator.expression.tree;

public class AddOperationNode extends OperationNode {

	public Double evaluate() {
		return leftNode.evaluate() + rightNode.evaluate();
	}

}
