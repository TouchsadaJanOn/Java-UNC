package StdDev;

/*******************************************************************************
*                     Assignment 4 -- Standard Deviation				       *
*                                                                              *
* PROGRAMMER:        Touchsada Jan On (tjcomputer13@gmail.com)                 *
* CLASS:             CS160 – Structured Programming                            *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   February 14, 2020 (Early Submission)                      *
*                                                                              *
* DESCRIPTION:                                                                 *
* This program calculate the sum, the average, min, max, variance, and 		   *
* Standard Deviation of user's input, also outputting the results of the user  *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/


//import java.util.Scanner;
//import java.util.ArrayList;
import java.util.*;

public class AnalysisEngine2
{
    // defining attributes
	private int size;
    private int count;
    // for accurate index print out purposes only
    private int NewSize;
    private ArrayList<Double> data = new ArrayList<>();
    private double sum;
    private double average;
    private double variance;
    private double stdev;
    private double min;
    private double max;
    private double median;
    private double plane;
    private String researcher;
    private String study;
    
    /***********************************************************************
     * Method:   AnalysisEngine                                            *
     * Purpose:  Setting variables and store user's information of name    *
     * 			 and study. Also provide an introduction of the program    *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    
    public AnalysisEngine2()
    {
        // initializing attributes
        
        this.sum = 0;
        this.average = 0;
        this.median = 0;
        this.max = 0;
        this.max = 0;
        this.median = 0;
        this.variance = 0;
        this.stdev = 0;
        
        // Scanner created
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Analysis Engine");
        System.out.println("Programmed by Touchsada Jan On"); 
        System.out.println();
        System.out.println("Welcome to Assignment 4, Standard Deviation");
        System.out.println();
        System.out.print("Enter the title of the study => ");
        this.study = input.nextLine();
        System.out.println("Name of study set to "+ this.study);
        System.out.println();
        System.out.print("Enter the head of research for this study name => ");
        this.researcher = input.nextLine();
        System.out.println("Hello, " + this.researcher +".");
        System.out.println();
        System.out.println("Introduction:");
        System.out.println("This program will calculate the standard deviation for a list of number entered by the user.\n It will run in three phases: ");
        System.out.println("\tPhase 1 - Gather input from user");
        System.out.println("\tPhase 2 - Calculate sum, average, variance, stdev");
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
	        System.out.println("Phase 1: Gathering user input");
	        System.out.println("-----------------------------");
	        System.out.println("To enter the data correctly, the program needs to know how many \nnumbers are in the dataset.");
	        System.out.print("\tSize of dataset => ");
	        this.size = input.nextInt(); 
	        this.NewSize = this.size -1;
	        System.out.println("\tData will have " + this.size + " elements, indexed 0 through " + this.NewSize +".");
	        System.out.println();
	        System.out.println("Enter integer or floating-point values: ");
	        //Gather input using for loop
	        this.count = 0;
	        for (double i = 0; i < this.size; i++) {
	        	System.out.print("\tIndex " + this.count + " => ");
	        	double num = input.nextDouble();
	        	this.data.add(num);
	        	this.count ++;
	        }
	        	
	        this.plane = this.data.get(this.data.size()-1);
	        System.out.print("Data entered: ");
	        for (int i = 0; i < this.data.size()-1; i++)
				System.out.print(this.data.get(i)+", ");
	        System.out.print(this.plane);
	        System.out.println("\n" );
    	}
	        	
    	catch(Exception e) {
    		System.out.println("Please enter integer number!");
    		phase1();
    	}
        
    }
   	/***********************************************************************
     * Method:   phase2                                                    *
     * Purpose:  This method calculate the sum and average of three        *
     * 			 number by calling on calcSum, calcAverage, calcMin,       *
     * 			 calcMax, calcMedian, calcStdev, calcVariance method       *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    public void phase2() {
    	// performing calculations
    	 System.out.println("Phase 2: Performing calculations");
         System.out.println("--------------------------------");
         this.calcSum();
         System.out.println("\tCalculated sum ("+this.sum+") ");
         this.calcAverage();
         System.out.println("\tCalculated average ("+this.average+") ");
         //Called upon Variance
         calcVariance();
         System.out.println("\tCalculated variance ("+this.variance+") ");
         //Called upon Standard Deviation
         calcStdev();
         //Called upon Min
         calcMin();
         //Called upon Max
         calcMax();
         //Called upon Median
         calcMedian();
         System.out.println("\tCalculated standard deviation ("+this.stdev+") ");
         System.out.println("Phase 2 complete");
         System.out.println();
         
    }
    
    /***********************************************************************
     * Method:   calcSum                                                   *
     * Purpose:  This method calculate the sum of data entered, saving the *
     * 			 result in sum attribute create.						   *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    
    public void calcSum() 
    {    
    	//SUM
    	for (int i = 0; i< this.data.size(); i++) {
    		this.sum += this.data.get(i);
    	}
        
    }
    
    /***********************************************************************
     * Method:   calcAverage                                               *
     * Purpose:  This method use the sum existing to calculate the average *
     * 			 of data, saving the result in average attribute           *
     * 			 attribute							                       *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    
    public void calcAverage() 
    {
    	//Average
    	this.average = this.sum/this.data.size();
        
    }
    // variance
    /***********************************************************************
     * Method:   calcVariance                                              *
     * Purpose:  This method calculate the variance from data entered      *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    
    public void calcVariance()
    {
    	double temp = 0;
    	for (double a: this.data) 
    	{
    		temp += (a-this.average)*(a-this.average);
    		this.variance = temp/(this.data.size()-1);
    	}
    }
    // Standard Deviation
    /***********************************************************************
     * Method:   calcStdev                                                 *
     * Purpose:  This method calculate the standard deviation from data    *
     * 			 entered                                                   *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    public void calcStdev() 
    {
    	this.stdev = Math.sqrt(this.variance);
    }
    //min
    /***********************************************************************
     * Method:   calcMin                                                   *
     * Purpose:  This method calculate the minimum from data entered       *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    public void calcMin() 
    {
    	
    	this.min = Collections.min(this.data);
    }
    //max
    /***********************************************************************
     * Method:   calcMax                                                   *
     * Purpose:  This method calculate the maximum from data entered       *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    public void calcMax()
    {
    	this.max = Collections.max(this.data);
    }
    
    /***********************************************************************
     * Method:   calcMedian                                                *
     * Purpose:  This method calculate the median from data entered        *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    public void calcMedian()
    {
    	int doMedian;
    	doMedian = this.data.size()/2;
    	
    	if (this.data.size() % 2 == 1) {
    		this.median = this.data.get(doMedian);
    	} else {
    		this.median = this.data.get(doMedian-1)+this.data.get(doMedian) / 2;
    	}
    }
    
    
    /***********************************************************************
     * Method:   phase3                                                    *
     * Purpose:  This phase creates a report for the output. This method   *
     * 			 will print study, researcher, sum, average, min, max,     *
     * 		     variance, standard deviation, median                      *                                   
     * Parameters:                                                         *      
     ***********************************************************************/
    
    public void phase3()
    {
        // outputting results
        System.out.println("Phase 3: Output table");
        System.out.println("------------------------");
        System.out.println();
        System.out.println(" +---------------------------------------+");
        System.out.format(" |  %-35s  |\n",this.study);
        System.out.format(" |  by %-32s  |\n", this.researcher);
        System.out.println(" +---------------------------------------+");
        System.out.format(" |  Sum:               %15.3f   |\n",this.sum);
        System.out.format(" |  Mean:              %15.3f   |\n",this.average);
        System.out.format(" |  Variance:          %15.3f   |\n",this.variance);
        System.out.format(" |  Standard Deviation:%15.3f   |\n",this.stdev);
        System.out.format(" |  Min:               %15.3f   |\n",this.min);
        System.out.format(" |  Max:               %15.3f   |\n",this.max);
        System.out.format(" |  Median:            %15.3f   |\n",this.median);
        System.out.println(" +---------------------------------------+");
        System.out.println();
        System.out.println("Phase 3 complete");
        System.out.println("Existing program");
    
    }
}
 