package com.gedcom.parser.util;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.gedcom.parser.model.Phrase;

/**
 * Class to test NodeFormatter methods
 * @author ArunkumarR
 *
 */
public class NodeFormatterTest {
	
	/**
	 * Check start node with null phrase.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void checkStartNodeWithNullPhrase() throws Exception {
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.startNode(null), "");
	}
	
	/**
	 * Check valid start node with tag id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void checkValidStartNodeWithTagId() throws Exception {
		String input = "0 @I0001@ INDI";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.startNode(phrase), "<indi id=\"@I0001@\">");
	}
	
	/**
	 * Check valid start node with tag value.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void checkValidStartNodeWithTagValue() throws Exception {
		String input = "1 NAME Elizabeth Alexandra Mary /Windsor/";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.startNode(phrase), "  <name value=\"Elizabeth Alexandra Mary /Windsor/\">");
	}
	
	/**
	 * Check valid start node with indentation and tag.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void checkValidStartNodeWithIndentationAndTag() throws Exception {
		String input = "5 NAME";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.startNode(phrase), "          <name>");
	}
	
	/**
	 * Check end node with null phrase.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void checkEndNodeWithNullPhrase() throws Exception {
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.endNode(null,false), "");
	}
	
	/**
	 * Check valid endt node.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void checkValidEndtNode() throws Exception {
		String input = "1 NAME Elizabeth Alexandra Mary /Windsor/";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.endNode(phrase, false), "</name>");
	}
	
	/**
	 * Check valid endt node with indentation.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void checkValidEndtNodeWithIndentation() throws Exception {
		String input = "4 NAME Elizabeth Alexandra Mary /Windsor/";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.endNode(phrase, true), "        </name>");
	}
	
	/**
	 * Check valid endt node without indentation.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void checkValidEndtNodeWithoutIndentation() throws Exception {
		String input = "4 NAME Elizabeth Alexandra Mary /Windsor/";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.endNode(phrase, false), "</name>");
	}
}
