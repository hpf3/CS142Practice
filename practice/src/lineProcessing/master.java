package lineProcessing;

import java.util.Stack;
import core.FileReader;
import core.root;

/**
 * Task:
 * Write a program that asks the user for the name of a file.
 *  The program should display the lines of the file in reverse order.
 *  For example, if the input file is:
 *	
 *	This is a line
 *	I have to find
 *	The time to dine
 *	
 *	The output is:
 *	
 *	The time to dine
 *	I have to find
 *	This is a line
 * @author Connor Bond
 */
public class master {
	public static void start() {
		FileReader reader = new FileReader();
		Stack<String> file = reader.readAllReverse();
		int x = file.size();
		root.println("BEGINNING FILE OUTPUT (" + x +" lines):");
		while (!file.empty()) {
			root.println(file.pop());
			
		}
	}
}
