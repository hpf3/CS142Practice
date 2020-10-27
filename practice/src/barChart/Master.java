package barChart;

import core.root;
/**
 * Task:
 * Write a program that asks the user to enter today’s sales for five stores. 
 * The program should display a bar chart comparing each store’s sales. 
 * Create each bar in the bar chart by displaying a row of asterisks. 
 * Each asterisk should represent $100 of sales. 
 * @author Connor Bond
 *
 */
public class Master {

	public static void start() {
		int[] sales = new int[5];
		for (int i = 0; i < sales.length; i++) {
			root.println("Enter today's sales for store " + (i+1) + ":");
			sales[i] = root.GetInt(); 
		}
		DrawGraph(sales);
	}
	
	/**
	 * writes to output a line similar to:
	 * Store 1: *****
	 * for each entry in stores with the number of  "*" being stores[i]/100
	 * @param stores the list of sales numbers for each store
	 */
	public static void DrawGraph(int[] stores) {
		root.println("SALES BAR CHART");
		for (int i = 0; i < stores.length; i++) {
			root.println("Store " + (i+1) + ": " + RepeatString("*", (stores[i]/100)));
		}
	}
	
	/**
	 * concatenates a string onto itself a number of times based on count
	 * @param input the string to copy
	 * @param count number of times to copy the string
	 * @return the resulting string
	 */
	public static String RepeatString(String input,int count) {
		String result = "";
		for (int i = 0; i < count; i++) {
			result+=input;
		}
		
		return result;
	}
}
