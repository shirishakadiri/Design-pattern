package coursesRegistration.util;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Result class implements FileDisplayInterface and StdoutDisplayInterface
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	//Display results on the terminal or output screen
	public void displayResult(ArrayList<Student> students){
    	int sumOfSatisfactionRate = 0;
    	int averageSatisfactionRate = 0;

    	//Calculate the satisfaction Rate for each student
    	for (Student student : students) {
    		int sumOfCourseValue = 0;
    	
    		for(String assign : student.assignedCourse){
    			int counter = 0;
    			for(String pref : student.preference){
    				if(assign.compareTo(pref) == 0){
    					
    					int courseValue = 0;
    					courseValue = 9 - counter;
    					sumOfCourseValue = sumOfCourseValue + courseValue;
    				}
    				counter++;
    			}
    		}
    		System.out.println(student.id + " : " + student.assignedCourse + " :: SatisfactionRating = " +sumOfCourseValue);
    		sumOfSatisfactionRate = sumOfSatisfactionRate + sumOfCourseValue;
    	}
    	//Calculate the average satisfaction rat for each class
    	averageSatisfactionRate = sumOfSatisfactionRate / students.size(); 
    	System.out.println("AverageSatisfactionRating = " + averageSatisfactionRate);
    }

    //Write the output to output file
    public void addResultsToFile(ArrayList<Student> students, String resultsFile){

    	int sumOfSatisfactionRate = 0;
    	int averageSatisfactionRate = 0;
    	try{
    		BufferedWriter writer = new BufferedWriter(new FileWriter(resultsFile));;

    		//Calculate the satisfaction rate for each student
	    	for (Student student : students) {
	    		int sumOfCourseValue = 0;
	    	
	    		for(String assign : student.assignedCourse){
	    			int counter = 0;
	    			for(String pref : student.preference){
	    				if(assign.compareTo(pref) == 0){
	    					//System.out.println(assign + " = " + pref);
	    					int courseValue = 0;
	    					courseValue = 9 - counter;
	    					sumOfCourseValue = sumOfCourseValue + courseValue;
	    				}
	    				counter++;
	    			}
	    		}
	    		String str = student.id + " : " + student.assignedCourse + " :: SatisfactionRating = " +sumOfCourseValue;
	    		writer.write(str);
	    		writer.newLine();
	    		sumOfSatisfactionRate = sumOfSatisfactionRate + sumOfCourseValue;
	    	}
	    	//Calculate the average satisfaction rat for each class
	    	averageSatisfactionRate = sumOfSatisfactionRate / students.size(); 
	    	String str = "AverageSatisfactionRating = " + averageSatisfactionRate;
			writer.write(str);
			writer.newLine();
			writer.close();
		}
		catch (IOException e) {
            e.printStackTrace();
        }

    }

}
