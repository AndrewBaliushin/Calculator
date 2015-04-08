package com.baliushin.calculator.expression.tree;

public class ExpressionNodes {
	
	public static class ValueNode implements ExpressionNode {
		
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
	
	public static abstract class OperationNode implements ExpressionNode {
		
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
	
	public static class AddOperationNode extends OperationNode {
		public Double evaluate() {
			return leftNode.evaluate() + rightNode.evaluate();
		}
	}
	
	public static class DivideOperationNode extends OperationNode {
		public Double evaluate() {
			return leftNode.evaluate() / rightNode.evaluate();
		}
	}
	
	public static class MultiplyOperationNode extends OperationNode {
		public Double evaluate() {
			return leftNode.evaluate() * rightNode.evaluate();
		}
	}
	
	public static class SubtractOperationNode extends OperationNode {
		public Double evaluate() {
			return leftNode.evaluate() - rightNode.evaluate();
		}
	}
	
}
