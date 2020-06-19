package Play;

/*******************************************************************************
*                     Final Project -- Play It 				                   *
*                                                                              *
* PROGRAMMER:        Touchsada Jan On (jano2187@bears.unco.edu)                *
* CLASS:             CS160 – Structured Programming                            *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   May 2nd 2020                                              *
*                                                                              *
* DESCRIPTION:                                                                 *
* This program will allow the Player class and its method to be called upon by *
* PlayerTester.            													   *					
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/

public class PlayerTester {
	
	public static void main(String[] args) {
		//Creating object for class
		Player Box = new Player();
		//Welcome Message
		System.out.print("Welcome To PLAY IT!!!\n");
		System.out.print("By Touchsada Jan On\n");
		System.out.println();
		System.out.print("Here is a record of what you have pressed...ENJOY!\n");
		//calling upon the method
		Box.setup();
		Box.button();
	
	}

}
