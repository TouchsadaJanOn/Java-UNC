/**
 * This is Final Project for CS200
 *This program will simulate database management for a high school system. The user will have the option to search and sort for the student’s information 
 *(name, age, GPA, and grade), the teacher’s information (name, age, salary, and subjects). They will also be able to read and add to the CSV file.
 *(student.csv/teacher.csv) The user will also be able to find the teacher’s average and standard deviation of the salaries and ages and 
 *the student’s average and standard deviation of the ages and grades. 
 *Sound-effects is implemented as the user do a certain task in the program.
 *Techniques used:
 *Input/Output with files, Inheritance, user-defined methods, Exception Handling, Generics,
 *Collectiond(ArrayList), searching and sorting
 * 
 * @author (Junwen Huang)
 * @author (Touchsada Jan-On)
 * @version (Dec.2/2020)
 */
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class FinalProject
{
    // instance variables - replace the example below with your own
    public static void main(String[] args) {
      // Creates FileReadFrame and its components
      FileReadFrame myFrame = new FileReadFrame();

      myFrame.setSize(800,800); //set canvas
      
      myFrame.setLocationRelativeTo(null);
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close canvas
      
      myFrame.setVisible(true);
   }

}
