package GA;
import java.util.*;
/*******************************************************************************
*                     Assignment 6 -- Graphic and Animation  			       *
*                                                                              *
* PROGRAMMER:        Touchsada Jan On (tjcomputer13@gmail.com)                 *
* CLASS:             CS160 – Structured Programming                            *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   March 6, 2020 (Early Submission)                          *
*                                                                              *
* DESCRIPTION: This program investigate how for-loop can be used in synthesis  *
* 			   with drawing command to create visual effects             	   *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/


public class DrawingWithLoops {

	public static void main(String[] args) {
		
		StdDraw.line(.2, .2, .4, .4);
		
		 StdDraw.setScale(-1.20, +1.20);
	        StdDraw.enableDoubleBuffering();
	        //for-loop
	        for (double t = 0.0; true; t += 0.003) {
	            double x = Math.sin(t);
	            double y = Math.cos(t);
	            if (t <= 30) {
	            	//size of drawnline
	            	StdDraw.setScale(-1.30, +1.30);
	            	StdDraw.setPenColor(StdDraw.RED);
	            	//coordinate of drawn line
		            StdDraw.line(x, y, x, y);
		            StdDraw.line(-x, -y, -x, -y);
		            StdDraw.show();
		            StdDraw.pause(20);
	            }
	            
	            if (t <= 55) {
	            	 StdDraw.setScale(-1.25, +1.25);
	            	StdDraw.setPenColor(StdDraw.BLUE);
	            	//drawn circle
		            StdDraw.filledCircle(x, y, x);
		            StdDraw.filledCircle(-x, -y, x);
		            StdDraw.show();
		            StdDraw.pause(20);
		            //another circle
	            	StdDraw.setScale(-1.20, +1.20);
	            	StdDraw.setPenColor(StdDraw.GREEN);
		            StdDraw.filledCircle(x, y, x);
		            StdDraw.filledCircle(-x, -y, x);
		            StdDraw.show();
		            StdDraw.pause(20);
	            }
	            else
	            {
	            	//another circle
	            StdDraw.setScale(-1.16, +1.16);
	            StdDraw.setPenColor(StdDraw.ORANGE);
	            //coordinate of circle
	            StdDraw.filledCircle(x, y, x);
	            StdDraw.filledCircle(-x, -y, x);
	            StdDraw.show();
	            StdDraw.pause(20);
	
}
	        }
}
}
	
