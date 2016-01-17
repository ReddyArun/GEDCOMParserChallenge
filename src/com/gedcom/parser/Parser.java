package com.gedcom.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Stack;

import com.gedcom.parser.model.Phrase;
import com.gedcom.parser.util.NodeFormatter;

public class Parser {
	// To read the current input file
	private BufferedReader inputFile;
	// To write the XML content back to desired destination
	private Writer out;

	/**
	 * @return the inputFile
	 */
	private BufferedReader getInputFile() {
		return inputFile;
	}

	/**
	 * Constructor to create STDOUT as output destination
	 * 
	 * @param inputFile
	 *            - where GEDCOMP file stored
	 * @throws Exception
	 *             throws if input location is not valid
	 */
	public Parser(String inputFile) throws Exception {
		try {
			// check inputFile not null and empty
			if (inputFile != null && inputFile.trim().length() > 0)
				this.inputFile = new BufferedReader(new FileReader(inputFile));
			else {
				System.out.println("Invalid input file, hence parse program terminated!..");
				throw new Exception("Invalid input file, hence parse program terminated!..");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		}
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		processFile();
	}

	/**
	 * Constructor to create desired output file on the disk
	 * 
	 * @param inputFile
	 *            - where GEDCOMP file stored
	 * @param outputFile
	 *            - where GEDCOMP Parse file needs to store
	 * @throws Exception
	 *             throws if input/output locations are not valid
	 */
	public Parser(String inputFile, String outputFile) throws Exception {
		try {
			// check inputFile not null and empty
			if (inputFile != null && inputFile.trim().length() > 0)
				this.inputFile = new BufferedReader(new FileReader(inputFile));
			else {
				System.out.println("Invalid input file, hence parse program terminated!..");
				throw new Exception("Invalid input file, hence parse program terminated!..");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		}
		// check outputFile not null and empty
		if (outputFile != null && outputFile.trim().length() > 0) {
			try {
				out = new BufferedWriter(new FileWriter(outputFile));
			} catch (IOException e) {
				System.out.println(e.getMessage());
				throw new Exception(e.getMessage());
			}
		} else {
			System.out.println("Invalid output file, hence parse program terminated!..");
			throw new Exception("Invalid output file, hence parse program terminated!..");
		}
		processFile();
	}

	/**
	 * 1. Read each line in the input file and phrase using Phrase class to
	 * create LEVEL, ID, TAG and VALUE
	 * 
	 * 2. Create the default node GEDCOM
	 * 
	 * 3. Always create the previous content XML node
	 * 
	 * @throws Exception
	 */
	private void processFile() throws Exception {
		try {
			// To hold the current node data;
			Stack<Phrase> phrases = new Stack<Phrase>();
			NodeFormatter formatter = new NodeFormatter();
			String line = null;
			String rootNode = "-1 GEDCOM";
			Phrase previousPhrase = new Phrase(rootNode);
			Phrase currentPhrase = new Phrase(rootNode);

			// Read the lines from the file
			while ((line = getInputFile().readLine()) != null) {
				// Ignore the empty lines
				if (line.trim().length() <= 0) {
					continue;
				}
				currentPhrase = new Phrase(line);

				// stack is empty to start new node
				if (phrases.empty()) {
					out.write(formatter.startNode(previousPhrase) + "\n");
					phrases.push(previousPhrase);
				}
				// prev.level < curr.level
				else if (previousPhrase.getLevel() < currentPhrase.getLevel()) {
					out.write(formatter.startNode(previousPhrase) + "\n");
					phrases.push(previousPhrase);
				}
				// prev.level == to curr.level the node sub child's for prev
				// node
				if (previousPhrase.getLevel() == currentPhrase.getLevel()) {
					out.write(formatter.startNode(previousPhrase) + formatter.endNode(previousPhrase, false) + "\n");
				}
				// prev.level > curr.level then create node and check levels in
				// the stack to create the end code
				if (previousPhrase.getLevel() > currentPhrase.getLevel()) {
					out.write(formatter.startNode(previousPhrase) + formatter.endNode(previousPhrase, false) + "\n");
					// loop till find the prev.level <= curr.level && stack is
					// not empty to create the end node
					while (currentPhrase.getLevel() <= phrases.peek().getLevel()) {
						out.write(formatter.endNode(phrases.pop(), true) + "\n");
					}
				}
				// Assign current line to previous
				previousPhrase = currentPhrase;
			}
			// We assigned current node to prev, hence write the prev node
			out.write(formatter.startNode(previousPhrase) + formatter.endNode(previousPhrase, false) + "\n");
			// finish the all end nodes from the stack
			while (!phrases.empty()) {
				out.write(formatter.endNode(phrases.pop(), true) + "\n");
			}
		} catch (Exception e) {
			throw e;

		} finally {
			// finally close the stream instances
			out.close();
			inputFile.close();
		}
	}
}
