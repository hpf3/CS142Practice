package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * opens a file for reading and provides methods for getting the contained lines of text
 * @author Connor Bond
 * 
 */
public class FileReader {

	private boolean readFromFile;
	private Scanner fileScanner;
	
	public FileReader() {
		JFrame frame = new JFrame();
		JFileChooser dialog = new JFileChooser();
		dialog.setDialogTitle("Select a file to open");
		dialog.setDialogType(JFileChooser.OPEN_DIALOG);
		dialog.setAcceptAllFileFilterUsed(true);
		dialog.setApproveButtonToolTipText("open selected file");
		int selection = dialog.showSaveDialog(frame);
		
		if (selection == JFileChooser.APPROVE_OPTION) {
			try {
				fileScanner =new Scanner(dialog.getSelectedFile());
				readFromFile = true;
				root.println("Reading file: " + dialog.getSelectedFile().getAbsolutePath());
			} catch (Exception e) {
				readFromFile = false;
				root.println("failed to read file");
			}
		}else {
			readFromFile = false;
			root.println("no file selected, probably going to crash and burn now");
		}
		frame.dispose();
		dialog = null;
	}
	
	/**
	 * adds each line from the document to a List for further processing
	 * @return a list containing each line from the document
	 */
	public List<String> readAll() {
		if (!readFromFile) {
			return new ArrayList<String>();
		}
		List<String> result = new ArrayList<String>();
		while (fileScanner.hasNextLine()) {
			 result.add(fileScanner.nextLine());
		}
		return result;
	}
	
	/**
	 * adds each line from the document to a Stack for further processing
	 * and to allow easy access to the lines in reverse order
	 * @return a stack containing each line from the document
	 */
	public Stack<String> readAllReverse() {
		if (!readFromFile) {
			return new Stack<String>();
		}
		Stack<String> result = new Stack<String>();
		while (fileScanner.hasNextLine()) {
			 result.add(fileScanner.nextLine());
		}
		return result;
	}
	
	/**
	 * closes the internal FileReader and disables methods
	 */
	public void dispose() {
		if (readFromFile) {
			readFromFile = false;
			fileScanner.close();
		}
	}
}
