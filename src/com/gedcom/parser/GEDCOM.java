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
			Parser pharser;
			// both input and output file names from the command prompt
			if (args.length == 2) {
				pharser = new Parser(args[0], args[1]);
			}
			// Only input file from the command prompt
			else if (args.length == 1) {
				pharser = new Parser(args[0]);
			}
			// In case if we are running from the editor then I placed
			// "gedcominput.txt" under project. Place the required input this file.
			// System will read from "gedcominput.txt"
			else {
				pharser = new Parser("gedcominput.txt");
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
