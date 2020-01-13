package coursesRegistration.util;

import coursesRegistration.util.Course;
import coursesRegistration.util.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

//Class to process the input files (student and course)
public class FileProcessor {

    //Read Course file and each course details i.e, each line in the file as an object of course class
    public ArrayList<Course> readCourseFile(String courseFile) {

        ArrayList<Course> courseList = new ArrayList();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(courseFile));
            String line = reader.readLine();
            while (line != null) {

                Course newCourse = new Course();
                String[] courseName = line.split(" ");

                String[] otherDetails = courseName[1].split(";");

                String[] capacity = otherDetails[0].split(":");
                int capacityInt = Integer.parseInt(capacity[1]);

                String[] classTiming = otherDetails[1].split(":");
                int classTimingInt = Integer.parseInt(classTiming[1]);

                //add the details to object
                newCourse.courseName = courseName[0];
                newCourse.capacity = capacityInt;
                newCourse.classTiming = classTimingInt;

                //add the object to array of objects
                courseList.add(newCourse);
                
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    //Read the student file and add each student details i.e, each line in the file as an object of student class
    public ArrayList<Student> readStudentFile(String studentFile){

        ArrayList<Student> studentList = new ArrayList();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(studentFile));
            String line = reader.readLine();
            while (line != null) {

                Student newStudent = new Student();
                
                String[] studentDetails = line.split(" ");
                int studentId = Integer.parseInt(studentDetails[0]);

                String[] otherDetails = studentDetails[1].split("::");

                String[] capacity = otherDetails[0].split(",");
                ArrayList<String> preference = new ArrayList<String>();
                for(String pref : capacity){
                    preference.add(pref);
                }

                //add the details to object
                newStudent.id = studentId;
                newStudent.level = otherDetails[1];
                newStudent.preference = preference;

                //add the object to array of objects
                studentList.add(newStudent);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
