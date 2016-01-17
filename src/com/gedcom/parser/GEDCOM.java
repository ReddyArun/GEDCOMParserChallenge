/**
 * 
 */
package com.gedcom.parser;

/**
 * @author ArunkumarR
 *
 */
public class GEDCOM {

	public static void main(String[] args) {
		try {
			Parser pharser = new Parser("sample.txt");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
