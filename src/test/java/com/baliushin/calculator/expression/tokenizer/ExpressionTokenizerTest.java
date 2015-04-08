package com.baliushin.calculator.expression.tokenizer;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.*;

import org.hamcrest.*;
import org.junit.Test;

public class ExpressionTokenizerTest {

	@Test
	public void testTokenizeString() {
		StringExpressionTokenizer et = new StringExpressionTokenizer();
		
		List<String> expected1 = Arrays.asList("1.0","/","2.0");
		List<String> expected2 = Arrays.asList("1.0","+","2.0");
		List<String> expected3 = Arrays.asList("(", "1.0","+","2.0", ")", "*", "5.0", "/", "10.5"); 
		
		try {
			assertThat(et.tokenize("1 / 2"), CoreMatchers.is(expected1));
			assertThat(et.tokenize("1 + 2"), CoreMatchers.is(expected2));
			assertThat(et.tokenize("(1 + 2)*5 / 10.5"), CoreMatchers.is(expected3));
			assertThat(et.tokenize("( 1  +2) *5/ 10.5"), CoreMatchers.is(expected3));
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
	}

}
