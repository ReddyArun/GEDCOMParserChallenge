package com.gedcom.parser.util;

import com.gedcom.parser.model.Phrase;

/**
 * Class to create the XML start and end node depends on ID, Value fields in the
 * given Phrase
 * 
 * @author ArunkumarR
 *
 */
public class NodeFormatter {

	/**
	 * Create the start node depends on ID, Value fields in the given Phrase
	 * 
	 * @param phrase
	 * @return XML start node
	 */
	public String startNode(Phrase phrase) {
		if (phrase != null) {
			String spaces = insertAlignementSpaces(phrase.getLevel());
			if (phrase.getId() != null) {
				return String.format("%s<%s id=\"%s\">", spaces, phrase.getTag(), phrase.getId());
			} else if (phrase.getValue() != null) {
				return String.format("%s<%s value=\"%s\">", spaces, phrase.getTag(), phrase.getValue());
			} else {
				return String.format("%s<%s>", spaces, phrase.getTag());
			}
		} else {
			return "";
		}
	}

	/**
	 * Create the end node with indentation flag
	 * 
	 * @param phrase
	 * @param indentRequired
	 *            - to insert the indentation spaces [spaces will be add depends
	 *            on level value]
	 * @return XML end node
	 */
	public String endNode(Phrase phrase, boolean indentRequired) {
		if (phrase != null) {
			if (indentRequired) {
				return String.format("%s</%s>", insertAlignementSpaces(phrase.getLevel()), phrase.getTag());
			} else {
				return String.format("</%s>", phrase.getTag());
			}
		} else {
			return "";
		}
	}

	/**
	 * Add spaces in front of the tag to align the depends on level
	 * 
	 * @param level
	 * @return indentation spaces
	 */
	private String insertAlignementSpaces(int level) {
		String space = "  ";
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < level; i++) {
			buffer.append(space);
		}
		return buffer.toString();
	}
}
