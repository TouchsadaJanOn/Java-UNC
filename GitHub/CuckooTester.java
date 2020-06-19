/*******************************************************************************
*                     Assignment 5 -- Cuckoo Clock Simulation                  *
*                                                                              *
* PROGRAMMER:        Touchsada Jan On (tjcomputer13@gmail.com)                 *
* CLASS:             CS160 – Structured Programming                            *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   February 28, 2020  (Early Submission)                     *
*                                                                              *
* DESCRIPTION:                                                                 *
* This program will allow the Cuckoo class and its method to be called upon by *
* CuckooTester.            													   *					
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/

package Clock;
import java.io.File;
import java.util.*;

public class CuckooTester {

	public static void main(String[] args) {
		//Take user's input
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.print("Assignment 5 - Cuckoo Clock Simulation");
		System.out.println("\nBy Touchsada Jan On");
		System.out.println();
		System.out.print("Enter the start hour => ");
		int startHour = input.nextInt();
		System.out.print("Enter the end hour => ");
		int endHour = input.nextInt();
		System.out.println();
		
		
		Cuckoo study1 = new Cuckoo("Bawk!");      // customized clock sound
		//Cuckoo study1 = new Cuckoo();              //default clock sound
		study1.runHourlyChimes(startHour,endHour);
		System.out.println();
		
		Cuckoo study2 = new Cuckoo("Squawk!", "ping");  // customized clock sound
		//Cuckoo study2 = new Cuckoo();					//default clock sound
		study2.runChimesAndTics(startHour, endHour);
		System.out.println();
		
		Cuckoo study3 = new Cuckoo("Ricky-Roo!", "doot");		// customized clock sound
		//Cuckoo study3 = new Cuckoo();					       // default clock sound
		study3.runChimesTicsQuarters(startHour, endHour);
		System.out.println();

		
	}

}
