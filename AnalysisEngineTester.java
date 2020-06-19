package OOP;

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
* This program will allow the AnalysisEngine to be called upon by              *
* AnalysisEngineTester. Within the tester are methods from the AnalysisEngine  *					
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/

public class AnalysisEngineTester
{
    public static void main(String args[])
    {
        AnalysisEngine study1 = new AnalysisEngine();
        study1.phase1();
        study1.phase2();
        study1.phase3();
        
        AnalysisEngine study2 = new AnalysisEngine();
        study2.phase1();
        study2.phase2();
        study2.phase3();
        
        AnalysisEngine study3 = new AnalysisEngine();
        study3.phase1();
        study3.phase2();
        study3.phase3();
    }
}
