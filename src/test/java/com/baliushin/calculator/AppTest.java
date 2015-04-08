package com.baliushin.calculator;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;

public class AppTest {
	
	public String evaluateAndConvert(String expr) throws IOException {
		Double result = App.evaluateExpression(expr);
		return App.convertDoubleToString(result);
	}

	@Test
	public void evaluationTest() throws IOException {
		
		assertEquals("1.5556", evaluateAndConvert("1.55555"));
		assertEquals("1.1111", evaluateAndConvert("1.11111"));
		assertEquals("3", evaluateAndConvert("1.5 + 1.5"));
		assertEquals("4.44", evaluateAndConvert("2.22 * 2"));
		
		assertEquals("1", evaluateAndConvert("3 - 2"));
		assertEquals("-1", evaluateAndConvert("-3 + 2"));
		assertEquals("-1", evaluateAndConvert(" -3   +    2  "));
		assertEquals("3", evaluateAndConvert("2 - (- 1)"));
		assertEquals("3", evaluateAndConvert("2-(-1)"));
		
		assertEquals("4", evaluateAndConvert("1 + 1 - 4/ 2 + 2 * 2"));
		assertEquals("0", evaluateAndConvert("1 - (1+1) / 2"));
		assertEquals("-1", evaluateAndConvert("1 - (1+1) / 2 * 2"));
		assertEquals("1", evaluateAndConvert("2 / (1 + 1)"));
		assertEquals("24", evaluateAndConvert("(3 + 3) * (2 + 2)"));
		assertEquals("3", evaluateAndConvert("(3) / (3 - 2)"));		
		
		assertEquals("40000", evaluateAndConvert("200*200"));	
		
		assertEquals("151", evaluateAndConvert("(1+38)*4-5"));
		assertEquals("29", evaluateAndConvert("7*6/2+8"));
		
		assertEquals("∞", evaluateAndConvert("3 / 0"));
	}
	
	@Test(expected=IOException.class)
	public void sanityCheckTest1() throws IOException {
		evaluateAndConvert("test");
	}
	
	@Test(expected=IOException.class)
	public void sanityCheckTest2() throws IOException {
		evaluateAndConvert("5 \\ 10");
	}
	
	@Test(expected=IOException.class)
	public void sanityCheckTest3() throws IOException {
		evaluateAndConvert("3 3");
	}
	
	@Test(expected=IOException.class)
	public void sanityCheckTest4() throws IOException {
		evaluateAndConvert("3 / / 3");
	}
	
	

}
