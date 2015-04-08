package com.baliushin.calculator.expression.tree;

public class SubtractOperationNode extends OperationNode {

	public Double evaluate() {
		return leftNode.evaluate() - rightNode.evaluate();
	}

}
