package GA;

/*******************************************************************************
*                     Assignment 6 - Graphic and animation                     *
*                                                                              *
* PROGRAMMER:        Touchsada Jan On (tjcomputer13@gmail.com)                 *
* CLASS:             CS160 – Structured Programming                            *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   March 6, 2020  (Early Submission)                         *
*                                                                              *
* DESCRIPTION:                                                                 *
* This program will allow the Graphic class and its method to be               *
* called upon by GraphicTester. Here is where you specified parameters		   *					
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/

public class GraphicTester {

	public static void main(String[] args) {
		Graphic pic1 = new Graphic();
		//background color
		pic1.background("blue");
		//kirby
		pic1.kirby();
		//shield x-pos, y-pos, size, color
		pic1.shield(.7,.44, .2, "green");
		//phone x-pos, y-pos, size x, size y, color
		pic1.phone(.2,.50,.05,.1,"red");
		//allow picture to rotate a direction, must press "a" or "s" on keyboard to start
		pic1.spin();
	}

}
