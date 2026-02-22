package com.codegnan.studentGradingSystem;
import java.util.Scanner;

public class StudentGradingSystem {
private static final Scanner Scanner = null;
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("enter the number of students");
	int n= scanner.nextInt();
	scanner.nextLine();
	String [] names= new String[n];
	int [] totalMarks = new int[n];
	double [] percentages= new double[n];
	char [] grades= new char[n];
	
	
	inputStudentData(scanner ,names ,totalMarks,percentages,grades);
	
	int topperIndex= findTopper(percentages);
	double calculateAverage = calculateClassAverage1(percentages);
	displayResults(names,totalMarks,percentages,grades,topperIndex,calculateAverage);
	scanner.close();
}
	

public static void inputStudentData(Scanner scanner,String [] names, int[] totalMarks,double[] percentages,
		char[] grades) {
	for(int i=0;i<names.length;i++) {
		System.out.println("\n student"+(i+1)+"---");
		System.out.print("Name");
		names[i] = scanner.nextLine();
		System.out.print("Enter the number of 3 subjects");
		int subject_1 = scanner.nextInt();
		int subject_2 = scanner.nextInt();
		int subject_3 = scanner.nextInt();
		scanner.nextLine();
		
		
		totalMarks[i] = subject_1 + subject_2 + subject_3;
		percentages[i] = (totalMarks[i] / 3.0);
		grades[i] = calculateGrade(percentages[i]);
		}
		
}
public static char calculateGrade(double percentage) {
if (percentage>= 90) {
return 'A';
} else {
if (percentage >= 80) {
return 'B';
} else {
if (percentage>= 70) {
return 'C';
} else {
if (percentage>=60) {
return 'D';
} else {
return 'F';
}

}
}
}
}
public static int findTopper(double[] percentages) {
int topperIndex = 0;
for (int i = 1; i<percentages.length; i++) {
if (percentages[i]> percentages[topperIndex]) {
topperIndex = i;
} else {
// current topper remains
}
}
return topperIndex;
}
public static double calculateClassAverage1(double[] percentages) {
double sum = 0;
for (double percentage : percentages) {
sum += percentage;
}
return sum / percentages.length;
}

public static void displayResults(String[] names, int[] totalMarks,
double[] percentages, char[] grades,
int topperIndex, double classAverage) {
	System.out.println("\n====================================");
	System.out.println("       CLASS PERFORMANCE");
	System.out.println("================================");
	for (int i = 0; i<names.length; i++) {
		String marker = (i == topperIndex) ? "🥇":""; 
		System.out.printf("%-15s %8d %8.2f %6c%s%n",
		names[i], totalMarks[i],
		percentages[i], grades[i], marker);

		}
	System.out.println("==========================");
	System.out.printf("classAvergae: %.2f%%%n",classAverage);
	System.out.printf("Topper: %s (%.2f%%)%n",
	names[topperIndex], percentages[topperIndex]);
	System.out.println("==========================================");
	}
	



}







