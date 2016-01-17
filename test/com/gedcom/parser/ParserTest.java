package com.gedcom.parser;

import org.junit.Test;

/**
 * Class to test Parser class
 * 
 * @author ArunkumarR
 *
 */
public class ParserTest {

	@Test(expected = Exception.class)
	public void testParseConstructor1WithNullParam() throws Exception {
		new Parser(null);
	}

	@Test(expected = Exception.class)
	public void testParseConstructor1WithInvalidInputFile() throws Exception {
		new Parser("text.txt");
	}

	@Test(expected = Exception.class)
	public void testParseConstructor1WithEmptyInputFileName() throws Exception {
		new Parser("");
	}

	@Test(expected = Exception.class)
	public void testParseConstructor1WithProperInputFileNameWithInvalidData() throws Exception {
		new Parser("invalidsample.txt");
	}

	@Test
	public void testParseConstructor1WithProperInputFileName() throws Exception {
		new Parser("sample.txt");
	}

	@Test(expected = Exception.class)
	public void testParseConstructor2WithNullParam() throws Exception {
		new Parser(null, null);
	}

	@Test(expected = Exception.class)
	public void testParseConstructor2WithInvalidInputFile() throws Exception {
		new Parser("text.txt", null);
	}

	@Test(expected = Exception.class)
	public void testParseConstructor2WithEmptyInputFileName() throws Exception {
		new Parser("", null);
	}
	
	@Test(expected = Exception.class)
	public void testParseConstructor2WithProperInputFileNameNullOutputFileName() throws Exception {
		new Parser("sample.txt", null);
	}
	
	@Test(expected = Exception.class)
	public void testParseConstructor2WithProperInputFileNameEmptyOutputFileName() throws Exception {
		new Parser("sample.txt", "");
	}
	
	@Test(expected = Exception.class)
	public void testParseConstructor2WithProperInputFileNameInvalidOutputFileName() throws Exception {
		new Parser("sample.txt", "t:\test.xml");
	}
	
	@Test
	public void testParseConstructor2WithProperInputAndOutputFileName() throws Exception {
		new Parser("sample.txt", "output.xml");
	}
}
