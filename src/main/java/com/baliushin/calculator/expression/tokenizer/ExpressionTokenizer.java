package com.baliushin.calculator.expression.tokenizer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for converting math expressions to tokens.
 * 
 * @author Andrei Baliushin
 */
public class ExpressionTokenizer {

	
	/**
	 * Read from reader and convert math expression to list of tokens.
	 * 
	 * @param reader 
	 * @return List of tokens. 
	 * @throws IOException
	 */
	public List<String> tokenize(Reader reader) throws IOException {
		StreamTokenizer tokenizer = new StreamTokenizer(reader);
		  tokenizer.ordinaryChar('-');  // Don't parse minus as part of numbers.
		  tokenizer.ordinaryChar('/');  // Don't parse slash as part of numbers.
		  
		  List<String> tokBuf = new ArrayList<String>();
		  while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
		    switch(tokenizer.ttype) {
		      case StreamTokenizer.TT_NUMBER:
		        tokBuf.add(String.valueOf(tokenizer.nval));
		        break;
		      case StreamTokenizer.TT_WORD:
		        tokBuf.add(tokenizer.sval);
		        break;
		      default:  // operator
		        tokBuf.add(String.valueOf((char) tokenizer.ttype));
		    }
		  }
		  
		  return tokBuf; 	
	}
}
