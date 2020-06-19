/*******************************************************************************
*                     Assignment 3 -- Object Oriented Programming (basic)      *
*                                                                              *
* PROGRAMMER:        Touchsada Jan On (tjcomputer13@gmail.com)                 *
* CLASS:             CS160 – Structured Programming                            *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   February 7, 2020                                          *
*                                                                              *
* DESCRIPTION:                                                                 *
* This program calculate the sum and the average of integer input,             *
* outputting the results of the user's name, study, sum, average, and data.    *
* This program also include basic Object Oriented Programming(OOP)             *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/

package OOP;

import java.util.Scanner;

public class AnalysisEngine
{
    // defining attributes
    private int num1;
    private int num2;
    private int num3;
    private int sum;
    private double average;
    private String researcher;
    private String study;
    
    /***********************************************************************
     * Method:   AnalysisEngine                                            *
     * Purpose:  Setting variables and store user's information of name    *
     * 			 and study. Also provide an introduction of the program    *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    
    public AnalysisEngine()
    {
        // initializing attributes
        this.num1 = 0;
        this.num2 = 0;
        this.num3 = 0;
        this.sum = 0;
        this.average = 0;
        
        // Scanner created
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Analysis Engine");
        System.out.println("Programmed by Touchsada Jan On"); 
        System.out.println();
        System.out.println("Welcome to Assignment 3, Object Oriented Programming(basic)");
        System.out.println();
        System.out.print("Please enter your name => ");
        this.researcher = input.nextLine();
        System.out.println("Hello, " + this.researcher);
        System.out.println();
        System.out.print("Please enter the title of the study => ");
        this.study = input.nextLine();
        System.out.println("Study title set to "+ this.study);
        System.out.println();
        System.out.println("Introduction:");
        System.out.println("This program will calculate basic statistics on three integer numbers. It will run in three phases: ");
        System.out.println("\tPhase 1 - Gather data from user");
        System.out.println("\tPhase 2 - Perform  Calculations");
        System.out.println("\tPhase 3 - Output results");
        System.out.println();
       
    }
    
    /***********************************************************************
    * Method:   phase1                                                     *
    * Purpose:  Gathering data from user's input and stored them in the    *
    * 			variables with try and catch installed                     *
    * Parameters:                                                          *      
    ***********************************************************************/
    public void phase1()
    {
    	try {
	        // gathering data
	    	Scanner input = new Scanner(System.in);
	        System.out.println("Phase 1: Gathering Data");
	        System.out.println("-----------------------");
	        //First number
	        System.out.print("\tFirst number => ");
	        String response1 = input.nextLine();
	        this.num1 = Integer.parseInt(response1);
	        //Second number
	        System.out.print("\tSecond number => ");
	        String response2 = input.nextLine();
	        this.num2 = Integer.parseInt(response2);
	        //Third number
	        System.out.print("\tThird number => ");
	        String response3 = input.nextLine();
	        this.num3 = Integer.parseInt(response3);
	        System.out.println();
	        System.out.println("Number entered: "+" "+this.num1+" "+this.num2+" "+this.num3);
	        System.out.println("Phased 1 complete");
	        System.out.println();
    	}
    	catch(Exception e) {
    		System.out.println("Please enter integer number!");
    		phase1();
    	}
    	
        
    }
    /***********************************************************************
     * Method:   phase2                                                    *
     * Purpose:  This method calculate the sum and average of three        *
     * 			 number by calling on calcSum and calcAverage method       *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    public void phase2() {
    	// performing calculations
    	 System.out.println("Phase 2: Performing calcualtions");
         System.out.println("--------------------------------");
         this.calcSum();
         System.out.println("\tCalculated total ("+this.sum+") ");
         this.calcAverage();
         System.out.println("\tCalculated average ("+this.average+") ");
         System.out.println("Phase 2 complete");
         System.out.println();
         
    }
    
    /***********************************************************************
     * Method:   calcSum                                                   *
     * Purpose:  This method calculate the sum of three number, saving the *
     * 			 result in sum attribute create.							   *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    
    public void calcSum() 
    {      
        //SUM
        this.sum = this.num1 + this.num2 + this.num3;   
    }
    
    /***********************************************************************
     * Method:   calcAverage                                               *
     * Purpose:  This method use the sum existing to calculate the average *
     * 			 of the three number, saving the result in average         *
     * 			 attribute							                       *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    
    public void calcAverage() 
    {
    	//Average
    	this.average = (double)this.sum/3;
        
    }
    
    /***********************************************************************
     * Method:   phase3                                                    *
     * Purpose:  This phase creates a report for the output. This method   *
     * 			 will print study, researcher, sum, average, and data      *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    
    public void phase3()
    {
        // outputting results
        System.out.println("Phase 3: Output table");
        System.out.println("------------------------");
        System.out.println();
        System.out.println("Study:\t\t" + this.study);
        System.out.println("Researcher:\t" + this.researcher);
        System.out.println("Data: " + " \t\t"+this.num1+" "+this.num2+" "+this.num3);
        System.out.println("Total:\t\t" + this.sum);
        System.out.println("Average:\t" + this.average);
        System.out.println();
        System.out.println("Phase 3 complete");
        System.out.println();
        System.out.println("Existing program");
    
    }
}
    