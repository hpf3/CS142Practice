package core;

import java.util.Scanner;
/**
 * made as practice for CS142 Team project, 
 * started at 1am oct26,2020
 * completed at 10pm oct26,2020
 * 
 * @author Connor Bond
 * @version 1
 */
public class root {
	private static Scanner ConsoleInput;
	public static MultiWriter ConsoleOutput;
	
	/**
	 * start task, starts logging and handles task selection, task start, and program exit.
	 * @param args unused,required.
	 */
	public static void main(String[] args) {
		ConsoleInput = new Scanner(System.in);
		ConsoleOutput = new MultiWriter();
		ConsoleOutput.println("select which task to run:");
		ConsoleOutput.println("1:ShowChar");
		ConsoleOutput.println("2:BarChart");
		ConsoleOutput.println("3:LineNumbers");
		ConsoleOutput.println("4:LineProcessing");
		switch (GetInt()) {
		case 1:
			showChar.master.start();
			break;
		case 2:
			barChart.Master.start();
			break;
		case 3:
			lineNumbers.master.start();
			break;
		case 4:
			lineProcessing.master.start();
			break;

		default:
			break;
		}
		System.exit(0);
	}
	
	/**
	 * pasthrough for Scanner.nextLine, sends record of input to log
	 * @return The line of user input
	 */
	public static String GetInput() {
		String input = ConsoleInput.nextLine();
		ConsoleOutput.Log("you entered: " + input);
		return input;
	}
	
	/**
	 * writes to output without going to the next line
	 * @param inputString the text to write
	 */
	public static void print(String inputString) {
		ConsoleOutput.print(inputString);
	}
	
	/**
	 * writes to output, goes to the next line afterwards
	 * @param inputString the text to write
	 */
	public static void println(String inputString) {
		ConsoleOutput.println(inputString);
	}
	
	/**
	 * gets user input and tests if it is a positive integer between 0 and infinity(inclusive)
	 * retries as needed until valid input is received
	 * @return the entered integer
	 */
	public static int GetInt() {
		String inputString = root.GetInput();
		while (!inputString.matches("^[0-9]\\d*$")) {
			ConsoleOutput.println("that wasn't an int, enter an int");
			inputString = root.GetInput();
		}
		return Integer.parseInt(inputString);
	}

}
