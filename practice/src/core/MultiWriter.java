package core;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * opens a log for writing and provides methods to easily write to both the console and file
 * @author Connor Bond
 *
 */
public class MultiWriter {

	private boolean writeToFile;
	private FileWriter file;
public MultiWriter() {
	JFrame frame = new JFrame();
	JFileChooser dialog = new JFileChooser();
	dialog.setDialogTitle("Select a Save Location");
	dialog.setApproveButtonText("Save");
	dialog.setApproveButtonToolTipText("Set log file");
	dialog.setSelectedFile(new File("C:\\log.txt"));
	int selection = dialog.showSaveDialog(frame);
	
	if (selection == JFileChooser.APPROVE_OPTION) {
		try {
			file = new FileWriter(dialog.getSelectedFile());
			writeToFile = true;
		} catch (Exception e) {
			writeToFile = false;
			System.out.println("file unavailable, continuing without log");
		}
	}
	frame.dispose();
	dialog = null;
}

/**
 * writes to console and file(if available) without going to the next line
 * @param input the text to write
 */
public void print(String input) {
	if (writeToFile) {
		try {
			file.write(input);
		} catch (Exception e) {
			writeToFile = false;
			System.out.println("file unavailable, continuing without log");
		}
	}
	System.out.print(input);
}

/**
 * writes to console and file(if available), goes to the next line afterwards
 * @param input the text to write
 */
public void println(String input) {
	if (writeToFile) {
		try {
			file.write(input + "\n");
		} catch (Exception e) {
			writeToFile = false;
			System.out.println("file unavailable, continuing without log");
		}
	}
	System.out.println(input);
}
/**
 * writes to file(if available), goes to the next line afterwards
 * allows writing info that would be redundant on the console
 * @param input the text to write
 */
public void Log(String input) {
	if (writeToFile) {
		try {
			file.write(input + "\n");
		} catch (Exception e) {
			writeToFile = false;
			System.out.println("file unavailable, continuing without log");
		}
	}
}
/**
 * saves and closes the internal FileWriter and disables file write attempts
 */
public void close() {
	if (writeToFile) {
		writeToFile = false;
		try {
			file.flush();
		} catch (Exception e) {
		}
		try {
			file.close();
		} catch (Exception e) {
		}
		System.out.println("logging disabled");
	}
	}
}
