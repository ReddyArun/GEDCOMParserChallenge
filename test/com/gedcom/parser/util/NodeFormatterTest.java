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
	
	@Test
	public void checkStartNodeWithNullPhrase() throws Exception {
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.startNode(null), "");
	}
	
	@Test
	public void checkValidStartNodeWithTagId() throws Exception {
		String input = "0 @I0001@ INDI";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.startNode(phrase), "<indi id=\"@I0001@\">");
	}
	
	@Test
	public void checkValidStartNodeWithTagValue() throws Exception {
		String input = "1 NAME Elizabeth Alexandra Mary /Windsor/";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.startNode(phrase), "  <name value=\"Elizabeth Alexandra Mary /Windsor/\">");
	}
	@Test
	public void checkValidStartNodeWithIndentationAndTag() throws Exception {
		String input = "5 NAME";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.startNode(phrase), "          <name>");
	}
	
	@Test
	public void checkEndNodeWithNullPhrase() throws Exception {
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.endNode(null,false), "");
	}
	
	@Test
	public void checkValidEndtNode() throws Exception {
		String input = "1 NAME Elizabeth Alexandra Mary /Windsor/";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.endNode(phrase, false), "</name>");
	}
	@Test
	public void checkValidEndtNodeWithIndentation() throws Exception {
		String input = "4 NAME Elizabeth Alexandra Mary /Windsor/";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.endNode(phrase, true), "        </name>");
	}
	@Test
	public void checkValidEndtNodeWithoutIndentation() throws Exception {
		String input = "4 NAME Elizabeth Alexandra Mary /Windsor/";
		Phrase phrase = new Phrase(input);
		NodeFormatter formatter = new NodeFormatter();
		assertEquals(formatter.endNode(phrase, false), "</name>");
	}
}
