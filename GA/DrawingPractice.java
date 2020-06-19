package GA;
/*******************************************************************************
*                     Assignment 6 -- Graphic and Animation  			       *
*                                                                              *
* PROGRAMMER:        Touchsada Jan On (tjcomputer13@gmail.com)                 *
* CLASS:             CS160 – Structured Programming                            *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   March 6, 2020 (Early Submission)                          *
*                                                                              *
* DESCRIPTION: This program investigate different command in StdDraw to create *
* 				graphics                                                 	   *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/

import java.awt.Font;

public class DrawingPractice {

	public static void main(String[] args) {
		//line
		StdDraw.line(.2, .2, .4, .4);
		//square and filled
		StdDraw.square(.3, .8, .05);
		StdDraw.filledSquare(.8, .8, .05);
		//circle
		StdDraw.circle(0.5, 0.5, 0.2);
		//filledCircle
		StdDraw.filledCircle(.2, .2, .04);
		//Ellipse
		StdDraw.ellipse(.64, .50, .160, .10);
		//filledEllipse
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledEllipse(.35, .50, .160, .10);
		//point
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(.05);
		StdDraw.point(.4, .7);
		//poly and filled
		 StdDraw.setPenColor(StdDraw.GRAY);
	        double[] x = { 0.1, 0.2, 0.3, 0.2 };
	        double[] y = { 0.2, 0.3, 0.2, 0.1 };
	        StdDraw.filledPolygon(x,y);
	        StdDraw.setPenColor(StdDraw.YELLOW);
	        double[] k = { 0.5, 0.6, 0.7, 0.7 };
	        double[] j = { 0.6, 0.7, 0.6, 0.6 };
	        StdDraw.polygon(k, j);
		//rectangle and filled
		StdDraw.rectangle(.3, .2, .08, .01);
		StdDraw.filledRectangle(.5, .2, .08, .2);
		//picture
		StdDraw.picture(.8,.2,"water.jpg", .20,.20);
        StdDraw.show();
        //text
        Font font = new Font("Arial", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.textRight(.8, .8, "  TAH!!    ");
        //clear
        //StdDraw.clear();

	}

}
