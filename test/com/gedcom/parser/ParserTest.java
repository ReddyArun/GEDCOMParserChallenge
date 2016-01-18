package com.gedcom.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Class to test Parser class
 * 
 * @author ArunkumarR
 *
 */
public class ParserTest {

	/**
	 * Test parse constructor1 with null param.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testParseConstructor1WithNullParam() throws Exception {
		new Parser(null);
	}

	/**
	 * Test parse constructor1 with invalid input file.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testParseConstructor1WithInvalidInputFile() throws Exception {
		new Parser("text.txt");
	}

	/**
	 * Test parse constructor1 with empty input file name.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testParseConstructor1WithEmptyInputFileName() throws Exception {
		new Parser("");
	}

	/**
	 * Test parse constructor1 with proper input file name with invalid data.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testParseConstructor1WithProperInputFileNameWithInvalidData() throws Exception {
		new Parser("invalidsample.txt");
	}

	/**
	 * Test parse constructor1 with proper input file name.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testParseConstructor1WithProperInputFileName() throws Exception {
		new Parser("sample.txt");
	}

	/**
	 * Test parse constructor2 with null param.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testParseConstructor2WithNullParam() throws Exception {
		new Parser(null, null);
	}

	/**
	 * Test parse constructor2 with invalid input file.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testParseConstructor2WithInvalidInputFile() throws Exception {
		new Parser("text.txt", null);
	}

	/**
	 * Test parse constructor2 with empty input file name.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testParseConstructor2WithEmptyInputFileName() throws Exception {
		new Parser("", null);
	}

	/**
	 * Test parse constructor2 with proper input file name null output file name.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testParseConstructor2WithProperInputFileNameNullOutputFileName() throws Exception {
		new Parser("sample.txt", null);
	}

	/**
	 * Test parse constructor2 with proper input file name empty output file name.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testParseConstructor2WithProperInputFileNameEmptyOutputFileName() throws Exception {
		new Parser("sample.txt", "");
	}

	/**
	 * Test parse constructor2 with proper input file name invalid output file name.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void testParseConstructor2WithProperInputFileNameInvalidOutputFileName() throws Exception {
		new Parser("sample.txt", "t:\test.xml");
	}

	/**
	 * Test parse constructor2 with proper input and output file name.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testParseConstructor2WithProperInputAndOutputFileName() throws Exception {
		new Parser("sample.txt", "output.xml");

		BufferedReader generated = new BufferedReader(new InputStreamReader(new FileInputStream("output.xml")));
		BufferedReader expected = new BufferedReader(new InputStreamReader(new FileInputStream("out.xml")));

		// Comparing the generated and expected files
		String strLine1 = null, strLine2 = null;

		while ((strLine1 = generated.readLine()) != null && (strLine2 = expected.readLine()) != null) {
			Assert.assertEquals(strLine1, strLine2);
		}
		generated.close();
		expected.close();
	}
}
