package com.baliushin.calculator.expression.tokenizer;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * Tokenizer for Strings with math expressions
 * 
 * @author Andrei Baliushin
 */
public class StringExpressionTokenizer extends ExpressionTokenizer {

	/**
	 * Convert string with expression to list of tokens.
	 * 
	 * Ex: "1 + 2" => ("1.0","+","2.0")
	 * 
	 * @param expression 
	 * @return List of tokens. 
	 * @throws IOException
	 */
	public List<String> tokenize(String expression) throws IOException {
		return super.tokenize(new StringReader(expression));
	}
}
