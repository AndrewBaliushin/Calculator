package com.baliushin.calculator.expression.tree;

public abstract class OperationNode implements ExpressionNode {
	
	protected ExpressionNode leftNode;
	protected ExpressionNode rightNode;
	
	public void setLeftNode(ExpressionNode left) {
		leftNode = left;
	}
	
	public void setRightNode(ExpressionNode right) {
		rightNode = right;
	}
	
	public boolean isSane() {
		boolean leftNodeSanity = (leftNode != null && leftNode.isSane());
		boolean rightNodeSanity = (rightNode != null && rightNode.isSane());
		
		return (leftNodeSanity && rightNodeSanity);
	}
	
}
