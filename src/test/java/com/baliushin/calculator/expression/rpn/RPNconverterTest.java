package com.baliushin.calculator.expression.rpn;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class RPNconverterTest {

	@Test
	public void testConvert() {
		RPNconverter rpnc = new RPNconverter();
		
		try {
			List<String> rpn = rpnc.convert(Arrays.asList("(", "1", "+", "2", ")", "*", "3"));
			assertThat(rpn, CoreMatchers.is(Arrays.asList("1", "2", "+", "3", "*")));
			
			rpn = rpnc.convert(Arrays.asList("1", "+", "2", "*", "(", "3", "+", "4", ")"));
			assertThat(rpn, CoreMatchers.is(Arrays.asList("1", "2", "3", "4", "+", "*", "+")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
