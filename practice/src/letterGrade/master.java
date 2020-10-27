package letterGrade;

import java.util.ArrayList;
import java.util.List;
import core.FileReader;
import core.root;


/**
 * Task:
 * Write a program that reads in five test scores from a file. 
 * The program should display a letter grade for each score and the average test score. 
 * @author Connor Bond
 *
 */
public class master {
public static void Start() {
	FileReader reader = new FileReader();
	List<Double> grades = new ArrayList<Double>();
	List<String> lines = reader.readAll();
	int size = lines.size();
	for (int i = 0; i < size; i++) {
		double score = Double.parseDouble(lines.get(i));
		grades.add(score);
		root.println("Grade " + (i+1) + ": " + score + "is an \"" + DetermineGrade(score) + "\"");
	}
	root.println("the average score is: " + CalcAverage(grades));
}

/**
 * averages 5 doubles, required.
 * @return the average of all inputs
 */
public static double CalcAverage(double T1,double T2,double T3,double T4,double T5) {
	return ((T1+T2+T3+T4+T5)/5d);
}

/**
 * averages all doubles in a list
 * @param scoreDoubles the list of doubles to be averaged
 * @return the resulting average
 */
public static double CalcAverage(List<Double> scoreDoubles) {
	double total = 0;
	for (Double double1 : scoreDoubles) {
		total+=double1;
	}
	return total/scoreDoubles.size();
}

/**
 * tests the input against the following table and returns the letter grade:
 * Score	Letter Grade
 *	90–100	 A
 *	80–89	 B
 *	70–79	 C
 *	60–69	 D
 *	Below 60 F
 * @param T the score to test
 * @return the resulting grade
 */
public static String DetermineGrade(double T) {
		if (T>=90) {
			 return "A";
		} else if (T>=80) {
			 return "B";
		} else if (T>=70) {
			 return "C";
		} else if (T>=60) {
			 return "D";
		} else {
			 return "F";
		}
}
}
