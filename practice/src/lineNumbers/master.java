package lineNumbers;

import java.util.List;

import core.FileReader;
import core.root;

/**
 * Task:
 * Write a program that asks the user for the name of a file.
 *  The program should display the contents of the file with each line preceded with a line number followed by a colon. 
 * The line numbering should start at 1.
 * @author Connor Bond
 */
public class master {

	public static void start() {
		FileReader reader = new FileReader();
		List<String> file = reader.readAll();
		int x = file.size();
		root.println("BEGINNING FILE OUTPUT (" + x +" lines):");
		root.ConsoleOutput.Log("Output disabled to prevent cloning input file (logSpam)");
		for (int i = 0; i < x; i++) {
			System.out.println(AddNumber(file.get(i), i+1));
		}
		root.println("FILE END REACHED");
	}
	
	/**
	 * adds the input number to the beginning of the input string. ex:
	 * "1: inputString"
	 * @param line the input string
	 * @param index the input number
	 */
	public static String AddNumber(String line,int index) {
		return (index + ": " + line);
	}
}
