package com.gedcom.parser.model;

import java.util.regex.Pattern;

/**
 * The Class Phrase to collect the data in the following manner.
 * 
 * To get "LEVEL TAG-OR-ID [DATA/VALUE]",
 * 
 * LEVEL is an integer,
 * 
 * TAG-OR-ID is either a tag that identifies the type of data in that node,
 * 
 * Tags are 3- or 4-letter words in uppercase,
 * 
 * If an ID is vale looks like @XXX@,
 * 
 * the DATA/VALUE is the type of the subtree that is identified
 * 
 * @author ArunkumarR
 */
public class Phrase {
	// To check give pattern is looks like @XXXX@
	/** The Constant idRegex. */
	private static final String idRegex = "(@(\\w+)@)";

	/** The Constant idPattern. */
	private static final Pattern idPattern = Pattern.compile(idRegex);
	// Node level in the current root
	/** The level. */
	private int level;
	// Node id in-case if present
	/** The id. */
	private String id;
	// Node TAG
	/** The tag. */
	private String tag;
	// Node value in-case if present
	/** The value. */
	private String value;

	/**
	 * Instantiates a new phrase.
	 *
	 * @param input
	 *            the input
	 */
	public Phrase(String input) throws Exception {

	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the tag.
	 *
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
