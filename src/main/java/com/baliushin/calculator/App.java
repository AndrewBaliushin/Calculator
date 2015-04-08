package com.baliushin.calculator;

import java.text.DecimalFormat;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

import com.baliushin.calculator.expression.rpn.RPNconverter;
import com.baliushin.calculator.expression.tokenizer.StringExpressionTokenizer;
import com.baliushin.calculator.expression.tree.ExpressionNode;
import com.baliushin.calculator.expression.tree.ExpressionTreeCreator;

public class App {

	private final static String DOUBLE_TO_STRING_FORMAT = "#.####";
	
	private static StringExpressionTokenizer tokenizer = new StringExpressionTokenizer();
	private static RPNconverter rpnConverter = new RPNconverter();
	private static ExpressionTreeCreator treeCreator = new ExpressionTreeCreator();
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String expression;
		Double result;
		
		System.out.println("Welcome to Calculator");
		
		while(true) {
			System.out.println("Enter math expression:");
			
			expression =  scanner.nextLine();
			
			try {
				result = evaluateExpression(expression);
				System.out.println(convertDoubleToString(result));
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.out.println("Try again.");
			}
		}
	}
	
	public static Double evaluateExpression(String expr) throws IOException {
		List<String> tokens = tokenizer.tokenize(expr);
		List<String> tokensRpn = rpnConverter.convert(tokens);
		ExpressionNode rootNode = treeCreator.createTree(tokensRpn);
		return rootNode.evaluate();
	}
	
	public static String convertDoubleToString(Double d) {
		return new DecimalFormat(DOUBLE_TO_STRING_FORMAT).format(d);
	}

}
