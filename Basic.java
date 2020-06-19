/*******************************************************************************
*                     Assignment 2 -- Basic Calculations                       *
*                                                                              *
* PROGRAMMER:        Touchsada Jan On (tjcomputer13@gmail.com)                 *
* CLASS:             CS160 -- Structured Programming                           *
* TERM:              Spring 2020                                               *
* INSTRUCTOR:        Dean Zeller                                               *
* SUBMISSION DATE:   Friday, January 31st 2020                                 *
*                                                                              *
* DESCRIPTION:                                                                 *
* This program calculate the sum and the average of integer input,             *
* outputting the results of the user's name, study, sum, average, and data.    *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c) 2020 Touchsada Jan On and Dean Zeller.         *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/
package BasicPack;

import java.util.Scanner;

public class Basic {
  public static void main(String[] args) {
	/*INFORMATION AND INSTRUCTIONS
	 *This section of code gathers user's name and name of study, and informs the user of what the program will accomplish. */
    System.out.println("Welcome to Assignment 2, Basic Calculations");
    System.out.println();
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter your name => ");
    String userName = input.nextLine();
    System.out.println("Hello, " + userName);
    System.out.println();
    System.out.print("Please enter the title of the study => ");
    String studyName = input.nextLine();
    System.out.println("Study title set to "+ studyName);
    System.out.println();
    System.out.println("Introduction:");
    System.out.println("This program will calculate basic statistics on three integer numbers. It will run in three phases: ");
    System.out.println("\tPhrase 1 - Gather data from user");
    System.out.println("\tPhrase 2 - Perform  Calculations");
    System.out.println("\tPhrase 3 - Output results");
    System.out.println();
    /* PHASE 1 - GATHER DATA
     * This phase gathers the necessary input from the user. 
     * Three integer values are read. */
    System.out.println("Phrase 1 - Gather data from user");
    System.out.println("--------------------------------");
    System.out.println("Please enter three numbers. Only enter integer values, as error-checking has not yet been implemented.");
    System.out.print("\tFirst number => ");
    String firstNum = input.next();
    int value1 = Integer.parseInt(firstNum);
    System.out.print("\tSecond number => ");
    String secondNum = input.next();
    int value2 = Integer.parseInt(secondNum);
    System.out.print("\tThird number => ");
    String thirdNum = input.next();
    int value3 = Integer.parseInt(thirdNum);
    System.out.println();
    System.out.println("Number entered: "+ firstNum +" "+ secondNum+" "+ thirdNum);
    System.out.println("Phase 1 complete");
    System.out.println();
    /*PHASE 2 - PERFORM CALCULATIONS
     * This section of code performs the necessary calculations,
     * including calculating the total and average of the input entered in Phrase 1.
     */
    System.out.println("Phase 2: Perform calculations");
    System.out.println("-----------------------------");
    double total = value1 + value2 + value3;
    int n = (int)total;
    double average;
    average = total/3;
    System.out.println("\tCalculated total ("+n+") ");
    System.out.println("\tCalculated average ("+average+") ");
    System.out.println("Phase 2 complete");
    System.out.println();
    /* PHASE 3 - OUTPUT RESULTS
     * This phase creates a report for output.
     */
    System.out.println("Phase 3: Output results");
    System.out.println("-----------------------");
    System.out.println();
    System.out.println("Study:\t\t" + studyName);
    System.out.println("Researcher:\t" + userName);
    System.out.println("Data:\t\t" + value1+" " + value2+" " + value3);
    System.out.println("Total:\t\t" + n);
    System.out.println("Average:\t" + average);
    System.out.println();
    System.out.println("Phase 3 complete");
    System.out.println();
    System.out.println("Existing program");
      
  }
}

