package com.gedcom.parser.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PhraseTest {

	private Phrase phrase;

	/**
	 * Check valid input.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void checkValidInput() throws Exception {
		// Checking the LEVEL TAG & VALUE
		phrase = new Phrase("1 NAME Elizabeth Alexandra Mary /Windsor/");
		assertEquals(phrase.getLevel(), 1);
		assertEquals(phrase.getTag(), "name");
		assertEquals(phrase.getValue(), "Elizabeth Alexandra Mary /Windsor/");
		assertEquals(phrase.getId(), null);

		// Checking the LEVEL ID & TAG
		phrase = new Phrase("0 @I0001@ INDI");
		assertEquals(phrase.getLevel(), 0);
		assertEquals(phrase.getTag(), "indi");
		assertEquals(phrase.getId(), "@I0001@");
		assertEquals(phrase.getValue(), null);

		// Checking the LEVEL & TAG
		phrase = new Phrase("1 CHAN");
		assertEquals(phrase.getLevel(), 1);
		assertEquals(phrase.getTag(), "chan");
		assertEquals(phrase.getId(), null);
		assertEquals(phrase.getValue(), null);

		// Checking the LEVEL TAG & VALUE with different combination
		phrase = new Phrase("1 @CHAN XXXX");
		assertEquals(phrase.getLevel(), 1);
		assertEquals(phrase.getTag(), "@chan");
		assertEquals(phrase.getId(), null);
		assertEquals(phrase.getValue(), "XXXX");

		// Checking the LEVEL TAG & VALUE with different combination
		phrase = new Phrase("1 @CHAN@X XXXX");
		assertEquals(phrase.getLevel(), 1);
		assertEquals(phrase.getTag(), "@chan@x");
		assertEquals(phrase.getId(), null);
		assertEquals(phrase.getValue(), "XXXX");
	}

	/**
	 * Test case to check Line should have atleast 2 values LEVEL and TAG
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void checkInValidInputHavingOnlyLevel() throws Exception {
		new Phrase("0");
	}

	/**
	 * Test case to check LEVEL should be numeric and positive value
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void checkInValidInputHavingCharacterInLevel() throws Exception {
		new Phrase("S");
	}

	/**
	 * Test case to check LEVEL ID and TAG.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = Exception.class)
	public void checkInValidInputHavingOnlyLevelAndID() throws Exception {
		new Phrase("0 @I0001@");
	}
}
