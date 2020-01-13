# CSX42: Assignment 1
## Name: Shirisha Kadiri

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile coursesRegistration/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile coursesRegistration/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile coursesRegistration/src/build.xml run -Darg0="input_file.txt" -Darg1="delete_file.txt" -Darg2="output1_file.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

I have created classes to store and retrieve information of students and courses file. Fileprocessor class reads input files and creats objects for each line of input and create array of objects. Schedule class assigns courses first for 3rd year, then 2nd year and then 1st year according to their requested preferences. I am checking if the course is already assigned, if the course has enough capacity and if the time clashes with other assigned courses. Results implements from Filedisplay and Stdoutdisplay interfaces. I have created an arraylist to store assigned sources in student class as a data member. I will be using that in results class. I am calculating satisfaction rate for each student and avarage satisfaction for entire course in Results class. Finally I am printing the output in terminal/output screen and writing it to the output file.



-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [9-19-2019]


# csx42-fall-2019-assign1-ShirishaKadiriReddy
