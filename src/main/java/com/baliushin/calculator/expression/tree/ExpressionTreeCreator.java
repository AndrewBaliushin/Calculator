package com.baliushin.calculator.expression.tree;

import static com.baliushin.calculator.expression.tree.ExpressionNodes.*;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import com.baliushin.calculator.expression.Operator;

/**
 * Create expression tree from Reverse Polish Notation.
 * 
 * @author Andrei Baliushin
 *
 */
public class ExpressionTreeCreator {
	
	private Stack<ExpressionNode> result;
	private int nodeCounter;
	
	/**
	 * Use RPN tokenized statement to create expression tree.
	 * 
	 * @param rpnStatement
	 * @return root node
	 * @throws IOException
	 */
	public ExpressionNode createTree(List<String> rpnStatement) throws IOException {
		result = new Stack<ExpressionNode>();
		nodeCounter = 0;
		
		for (String token : rpnStatement) {
			Operator op = Operator.getOperator(token);
			if(op == null) {
				createNode(token);
			} else {
				createNode(op);
			}
		}
		
		if(isTreeSane()) {
			return result.peek();	
		} else {
			throw new IOException("Expression tree faild sanity check.");
		}
	}
	
	private void createNode(Operator op) throws IOException {
		if(result.size() < 2) {
			throw new IOException("Operation on one or less operands.");
		}
		
		OperationNode n = null;
		
		if(op == Operator.ADD) {
			n = new  AddOperationNode();
		} else if(op == Operator.SUBTRACT) {
			n = new SubtractOperationNode();
		} else if(op == Operator.MULTIPLY) {
			n = new MultiplyOperationNode();
		} else if(op == Operator.DIVIDE) {
			n = new DivideOperationNode();
		}
		
		n.setRightNode(result.pop());
		n.setLeftNode(result.pop());
		
		nodeCounter++;
		
		result.push(n);
	}
	
	private void createNode(String val) throws IOException {
		try {
			ValueNode n = new ValueNode(Double.parseDouble(val));
			result.push(n);
			nodeCounter++;
		} catch (NumberFormatException e) {
			throw new IOException("Can't parse Double value");
		}
	}
	
	private boolean isTreeSane() {
		boolean isSizeSane = (nodeCounter >= 3 && ((result.peek() instanceof OperationNode))) ||
				(nodeCounter == 1 && (result.peek() instanceof ValueNode));
		return isSizeSane && result.peek().isSane();
	}

}
