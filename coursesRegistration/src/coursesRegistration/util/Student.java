package coursesRegistration.util;

import java.util.ArrayList;

//Details of student
public class Student{
	public int id; //Id of the student
	public ArrayList<String> preference = new ArrayList<String>(); //List of course preference given by the student
	public String level; //Level of the student (1st, 2nd, 3rd)
	public ArrayList<String> assignedCourse = new ArrayList<String>(); //List of courses allocated to student
	public ArrayList<Integer> currentTimings = new ArrayList<Integer>(); //List of timings of the allocated courses

	//Empty Constructor
	public Student(){}

}