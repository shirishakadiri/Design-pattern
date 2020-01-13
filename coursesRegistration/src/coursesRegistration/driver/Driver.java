package coursesRegistration.driver;

/**
 * @author Shirisha Kadiri
 *
 */

import coursesRegistration.util.FileProcessor;
import coursesRegistration.util.Course;
import coursesRegistration.util.Student;
import coursesRegistration.scheduler.Schedule;
import coursesRegistration.util.StdoutDisplayInterface;
import coursesRegistration.util.FileDisplayInterface;
import coursesRegistration.util.Results;

import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		//takes 3 inputs, 1st is student file, 2nd is course file and 3rd is output file
		if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
		
        //object for FileProcessor class to process course and student files
        FileProcessor fp = new FileProcessor();
        //read course file and get details of course
        ArrayList<Course> courseList = new ArrayList();
        courseList = fp.readCourseFile(args[1]);

        //read student file and get details of student
        ArrayList<Student> studentList = new ArrayList();
        studentList = fp.readStudentFile(args[0]);

        //start scheduling courses to student
        Schedule sc = new Schedule();
        sc.schedule(studentList, courseList);

        //Display results on the terminal
        Results res = new Results();
        res.displayResult(studentList);

        //Write the results to file
        res.addResultsToFile(studentList, args[2]);
    
	}
}
