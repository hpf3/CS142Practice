package showChar;
import core.root;

/**
 * Task:
 * Write a method named ShowChar.  
 * The method accepts two arguments: a string variable, and an integer. 
 * The integer is a character position within the string, starting with 0. 
 * When the method executes, it should display the character at that character position. 
 * For example: ShowChar ("New York", 2) would display the character w. 
 * Read the string and integer from the user. 
 * Output to the console and a file named "log.txt"
 * @author Connor Bond
 */
public class master {
	public static void start() {
		root.println("enter some text");
		String textString = root.GetInput();
		int selecter = GetGoodInt(textString.length()-1);
		root.println("The Selected Char is: " + ShowChar(textString, selecter));
	}
	
	public static int GetGoodInt(int max) {
		root.println("enter an integer smaller than " + (max+1) + " and greater than -1");
		String inputString = root.GetInput();
		while (inputString.matches("^(0-9)\\d*$") && !(Integer.parseInt(inputString) <= max) && !(Integer.parseInt(inputString) >= 0)) {
			root.println(inputString + " is invalid, enter an integer smaller than " + (max+1) + " and greater than -1");
			inputString = root.GetInput();
		}
		return Integer.parseInt(inputString);
	}
	
	public static char ShowChar(String input,int index) {
		return input.charAt(index);
	}

}
