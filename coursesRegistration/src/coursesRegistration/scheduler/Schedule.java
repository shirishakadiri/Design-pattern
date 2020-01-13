package coursesRegistration.scheduler;

import coursesRegistration.util.Course;
import coursesRegistration.util.Student;

import java.util.ArrayList;
import java.lang.*;

//Schedule courses to student
//Assign courses first for 3rd year students first, then 2nd and finally 1st according to their preferences
public class Schedule{

	 public void schedule(ArrayList<Student> students, ArrayList<Course> courses){
        
        //iterate through each student
        for (Student student : students) {

        	//First assign the courses for 3rd year students
            if(student.level.compareTo("THIRD_YEAR") == 0){

            	//Iterate through each course in student preference list
            	for(String requestedCourse : student.preference){

            		//Assign course if the courses assigned are less than 3
            		if(student.assignedCourse.size() < 3){

            			//Check if this requested course is already assigned
            			if(!student.assignedCourse.contains(requestedCourse)){

            				//Check if the requested course has availability or not
	            			int courseAvailability = checkForCourseAvailability(requestedCourse, student.currentTimings, courses);
	            			
	            			//check if the capacity and timings conditions satisfy
	            			if(courseAvailability >= 0){

	            				//add the course and course timings
	            				student.assignedCourse.add(requestedCourse);
	            				student.currentTimings.add(courseAvailability);		
	            			}
            			}
            		}
            	}	
            }
        }

        for (Student student : students) {

        	//assign the courses for 2nd year students
            if(student.level.compareTo("SECOND_YEAR") == 0){

            	//Iterate through each course in student preference list
            	for(String requestedCourse : student.preference){

            		//Assign course if the courses assigned are less than 3
            		if(student.assignedCourse.size() < 3){

            			//Check if this requested course is already assigned
            			if(!student.assignedCourse.contains(requestedCourse)){

            				//Check if the requested course has availability or not
	            			int courseAvailability = checkForCourseAvailability(requestedCourse, student.currentTimings, courses);
	            			
	            			//check if the capacity and timings conditions satisfy
	            			if(courseAvailability >= 0){

	            				//add the course and course timings
	            				student.assignedCourse.add(requestedCourse);
	            				student.currentTimings.add(courseAvailability);		
	            			}
            			}
            		}
            	}
            }
        }

        for (Student student : students) {

        	//Assign the courses for 1st year students
            if(student.level.compareTo("FIRST_YEAR") == 0){

            	//Iterate through each course in student preference list
            	for(String requestedCourse : student.preference){

            		//Assign course if the courses assigned are less than 3
            		if(student.assignedCourse.size() < 3){

            			//Check if this requested course is already assigned
            			if(!student.assignedCourse.contains(requestedCourse)){

            				//Check if the requested course has availability or not
	            			int courseAvailability = checkForCourseAvailability(requestedCourse, student.currentTimings, courses);
	            			
	            			//check if the capacity and timings conditions satisfy
	            			if(courseAvailability >= 0){

	            				//add the course and course timings
	            				student.assignedCourse.add(requestedCourse);
	            				student.currentTimings.add(courseAvailability);		
	            			}
            			}
            		}
            	}
            }
        }
    }

    //Check if the requested course can be assigned or not
    public int checkForCourseAvailability(String requestedCourse, ArrayList<Integer> currentTimings, ArrayList<Course> courses){
    	
    	//check if there are seats left in the class
        for (Course course : courses) {

        	//Check if the course exits in course list
        	if(course.courseName.compareTo(requestedCourse) == 0){

        		//Check if the there are seats left out
	            if(course.capacity > 0){

	            	//Checks if the timings are clashing with already assigned courses
	            	if(currentTimings.contains(course.classTiming)){
	            		return -1;
	            	}
	            	//else assign course and reduce the capacity of course
	            	else{
	            		course.capacity--;
	            		return course.classTiming;
	            	}
	            }
	            else{
	            	return -1;
	            }
        	}
        }
        return -1;
    }
}