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
* DESCRIPTION:                                                                 *
* This program will create picture and animations using StdDraw graphic        *
* library. This will be a representation of kirby hold objects of phone and/or *
* shield with different size, color and location. The program the user to      *
* change the direction of the rotation of kirby's picture clockwise or         *
* counter-clockwise using keyboard key "a" and "s"						       *											   *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/
import java.awt.Font;

public class Graphic {
	//defining attributes
	private double canvas1, canvas2, x ,y, size, halfx, halfy;
	private String color;

	/***********************************************************************
     * Method:   Graphic (Constructor)                                     *
     * Purpose:  Allow object's argument to run the program with default   *
     * 			 Canvas size        									   *                                   
     * Parameters: none                     							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public Graphic() {
		this.canvas1 = 600;
		this.canvas2 = 600;
	}
	/***********************************************************************
     * Method:   kirby	                          			               *
     * Purpose:  Pre-drawn kirby for the user to choose object for kirby   *                                   
     * Parameters: 	none           										   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void kirby() {
		//left arm
		StdDraw.setPenRadius(.5);
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.filledEllipse(.35, .50, .160, .10);
		//right arm
		StdDraw.setPenRadius(.5);
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.filledEllipse(.64, .50, .160, .10);
		//left shoe
		StdDraw.setPenRadius(.5);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledEllipse(.42, .30, .08, .09);
		
		//arms outline
		StdDraw.setPenRadius(.0019);
		StdDraw.setPenColor(StdDraw.BLACK);
    	StdDraw.circle(0.5, 0.5, 0.2);
    	StdDraw.ellipse(.35, .50, .160, .10);
    	StdDraw.ellipse(.64, .50, .160, .10);
		//body
		StdDraw.setPenRadius(.5);
		StdDraw.filledCircle(4, 4, 4);
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.point(0.5, 0.5);
		//outline body
		StdDraw.setPenRadius(.0019);
		StdDraw.setPenColor(StdDraw.BLACK);
    	StdDraw.circle(0.5, 0.5, 0.25);
		
		//running right shoe
		StdDraw.setPenRadius(.5);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledEllipse(.60, .30, .09, .10);
		
		//Ellipse for the cheeks
		//Left Cheek
			StdDraw.setPenRadius(.5);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledEllipse(.37, .5, .03, .014);
		//Right Cheek
			StdDraw.setPenRadius(.5);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledEllipse(.63, .5, .03, .014);
			
		//Ellipse for Eyes
		//Left Eye
			StdDraw.setPenRadius(.5);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledEllipse(.45, .60, .029, .08);
		//Right Eye
			StdDraw.setPenRadius(.5);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledEllipse(.56, .60, .029, .08);
		//black 
			StdDraw.setPenRadius(.05);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledEllipse(.45, .60, .019, .047);
			//black right 
			StdDraw.setPenRadius(.05);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledEllipse(.56, .60, .019, .047);
		//Eyes Glow
			StdDraw.setPenRadius(.05);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledEllipse(.45, .63, .016, .030);
			// right eye
			//Eyes Glow
			StdDraw.setPenRadius(.05);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledEllipse(.56, .63, .016, .030);
			
			//lips
			StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.setPenRadius(0.01);
	        StdDraw.arc(0.50, 0.48, 0.05, -180, 0);	        
	}
	/***********************************************************************
     * Method:   background                        			               *
     * Purpose:  Ability for the user to change the background color       *                                   
     * Parameters: 	String color   										   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void background(String color) {
		this.color = color;
		if (this.color == "gray")
			StdDraw.clear(StdDraw.GRAY);
		else if (this.color == "blue")
			StdDraw.clear(StdDraw.BLUE);
		else if (this.color == "green")
			StdDraw.clear(StdDraw.GREEN);
		else if (this.color == "orange")
			StdDraw.clear(StdDraw.ORANGE);
		else if (this.color == "pink")
			StdDraw.clear(StdDraw.PINK);
		else if (this.color == "red")
			StdDraw.clear(StdDraw.RED);
		else if (this.color == "white")
			StdDraw.clear(StdDraw.WHITE);
		else if (this.color == "yellow")
			StdDraw.clear(StdDraw.YELLOW);
	}
	/***********************************************************************
     * Method:   shield                        		     	               *
     * Purpose:  Ability for the user to change the position, size, and    *
     * 			 color of the shield                                       *                                   
     * Parameters: double x, double y, double size, String color  		   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void shield(double x, double y, double size, String color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
		//shield color gray
		if (this.color == "gray") {
			//outerCircle
			StdDraw.setPenRadius(.01);
			StdDraw.circle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.GRAY);
			//inner circle
			StdDraw.filledCircle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledCircle(this.x, this.y, this.size -.1);
			//text
			Font font = new Font("Arial", Font.BOLD, 40);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y, "SHIELD!");
	        //picture - logo
	        StdDraw.picture(this.x,this.y+.15,"shield.png", this.size-.13,this.size-.13);
	        StdDraw.show();
			
		}
		//shield color blue
		else if (this.color == "blue") {
			//outer circle
			StdDraw.setPenRadius(.01);
			StdDraw.circle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.BLUE);
			//inner circle
			StdDraw.filledCircle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledCircle(this.x, this.y, this.size -.1);
			//text
			Font font = new Font("Arial", Font.BOLD, 40);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y, "SHIELD!");
	        //picture
	        StdDraw.picture(this.x,this.y+.15,"shield.png", this.size-.13,this.size-.13);
	        StdDraw.show();
			
			}
		//shield color green
		else if (this.color == "green") {
			//outer circle
			StdDraw.setPenRadius(.01);
			StdDraw.circle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledCircle(this.x, this.y, this.size);
			//inner circle
			StdDraw.setPenColor(StdDraw.DARK_GRAY);
			StdDraw.filledCircle(this.x, this.y, this.size -.1);
			//text
			Font font = new Font("Arial", Font.BOLD, 40);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y, "SHIELD!");
	        //picture - logo
	        StdDraw.picture(this.x,this.y+.15,"shield.png", this.size-.13,this.size-.13);
	        StdDraw.show();
			
		}
		//shield orange
		else if (this.color == "orange") {
			//outer circle
			StdDraw.setPenRadius(.01);
			StdDraw.circle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledCircle(this.x, this.y, this.size);
			//inner circle
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledCircle(this.x, this.y, this.size -.1);
			//text
			Font font = new Font("Arial", Font.BOLD, 40);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.text(this.x, this.y, "SHIELD!");
	        //picture- logo
	        StdDraw.picture(this.x,this.y+.15,"shield.png", this.size-.13,this.size-.13);
	        StdDraw.show();
		}
		//shield pink
		else if (this.color == "pink") {
			//outer circle
			StdDraw.setPenRadius(.01);
			StdDraw.circle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.PINK);
			//inner
			StdDraw.filledCircle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledCircle(this.x, this.y, this.size -.1);
			//text
			Font font = new Font("Arial", Font.BOLD, 40);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y, "SHIELD!");
	        //pic
	        StdDraw.picture(this.x,this.y+.15,"shield.png", this.size-.13,this.size-.13);
	        StdDraw.show();
		}
		//shield red
		else if (this.color == "red") {
			//outer
			StdDraw.setPenRadius(.01);
			StdDraw.circle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledCircle(this.x, this.y, this.size);
			//inner
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledCircle(this.x, this.y, this.size -.1);
			//text
			Font font = new Font("Arial", Font.BOLD, 40);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y, "SHIELD!");
	        //pic
	        StdDraw.picture(this.x,this.y+.15,"shield.png", this.size-.13,this.size-.13);
	        StdDraw.show();
		}
		//shield white
		else if (this.color == "white") {
			//outer
			StdDraw.setPenRadius(.01);
			StdDraw.circle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(this.x, this.y, this.size);
			//inner
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledCircle(this.x, this.y, this.size -.1);
			//text
			Font font = new Font("Arial", Font.BOLD, 40);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.text(this.x, this.y, "SHIELD!");
	        //pic
	        StdDraw.picture(this.x,this.y+.15,"shield.png", this.size-.13,this.size-.13);
	        StdDraw.show();
		}
		//shield yellow
		else if (this.color == "yellow") {
			//outer
			StdDraw.setPenRadius(.01);
			StdDraw.circle(this.x, this.y, this.size);
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledCircle(this.x, this.y, this.size);
			//inner
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledCircle(this.x, this.y, this.size -.1);
			//text
			Font font = new Font("Arial", Font.BOLD, 40);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.text(this.x, this.y, "SHIELD!");
	        //logo - pic
	        StdDraw.picture(this.x,this.y+.15,"shield.png", this.size-.13,this.size-.13);
	        StdDraw.show();
		}
	}
	/***********************************************************************
     * Method:   phone                        		     	               *
     * Purpose:  Ability for the user to change the position, size, and    *
     * 			 color of the phone                                        *                                   
     * Parameters: double x, double y, double halfx, double halfy,         *
     * 			    String color  		                                   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void phone(double x, double y, double halfx, double halfy, String color) {
		this.x = x;
		this.y = y;
		this.halfx = halfx;
		this.halfy = halfy;
		this.color = color;
		//phone grey
		if (this.color == "gray") {
			//outline
			StdDraw.setPenRadius(.01);
			StdDraw.rectangle(this.x, this.y, this.halfx, this.halfy);
			//outer layer
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle(this.x, this.y, this.halfx, this.halfy);
			//screen
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledRectangle(this.x, this.y, this.halfx-.013, this.halfy-.013);
			//text
			Font font = new Font("Arial", Font.BOLD, 20);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y+.15, "PHONE!");
	        //pic - logo
	        StdDraw.picture(this.x,this.y-.05,"apple.png", this.halfx-.009,this.halfy-.05);
	        StdDraw.show();
			
		}
		//phone blue
		else if (this.color == "blue") {
			//outline
			StdDraw.setPenRadius(.01);
			StdDraw.rectangle(this.x, this.y, this.halfx, this.halfy);
			//outer layer
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledRectangle(this.x, this.y, this.halfx, this.halfy);
			//screen
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledRectangle(this.x, this.y, this.halfx-.013, this.halfy-.013);
			//text
			Font font = new Font("Arial", Font.BOLD, 20);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y+.15, "PHONE!");
	        //picture
	        StdDraw.picture(this.x,this.y-.05,"apple.png", this.halfx-.009,this.halfy-.05);
	        StdDraw.show();			
			}
		//phone green
		else if (this.color == "green") {
			//outline
			StdDraw.setPenRadius(.01);
			StdDraw.rectangle(this.x, this.y, this.halfx, this.halfy);
			//outer
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledRectangle(this.x, this.y, this.halfx, this.halfy);
			//screen
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledRectangle(this.x, this.y, this.halfx-.013, this.halfy-.013);
			//text
			Font font = new Font("Arial", Font.BOLD, 20);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y+.15, "PHONE!");
	        //pic
	        StdDraw.picture(this.x,this.y-.05,"apple.png", this.halfx-.009,this.halfy-.05);
	        StdDraw.show();
		}
		//phone orange
		else if (this.color == "orange") {
			//outline
			StdDraw.setPenRadius(.01);
			StdDraw.rectangle(this.x, this.y, this.halfx, this.halfy);
			//outer
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledRectangle(this.x, this.y, this.halfx, this.halfy);
			//screen
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledRectangle(this.x, this.y, this.halfx-.013, this.halfy-.013);
			//text
			Font font = new Font("Arial", Font.BOLD, 20);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y+.15, "PHONE!");
	        //pic
	        StdDraw.picture(this.x,this.y-.05,"apple.png", this.halfx-.009,this.halfy-.05);
	        StdDraw.show();
		}
		//phone pink
		else if (this.color == "pink") {
			//outline
			StdDraw.setPenRadius(.01);
			StdDraw.rectangle(this.x, this.y, this.halfx, this.halfy);
			//outer
			StdDraw.setPenColor(StdDraw.PINK);
			StdDraw.filledRectangle(this.x, this.y, this.halfx, this.halfy);
			//screen
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledRectangle(this.x, this.y, this.halfx-.013, this.halfy-.013);
			//text
			Font font = new Font("Arial", Font.BOLD, 20);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y+.15, "PHONE!");
	        //pic
	        StdDraw.picture(this.x,this.y-.05,"apple.png", this.halfx-.009,this.halfy-.05);
	        StdDraw.show();
		}
		//phone red
		else if (this.color == "red") {
			//outline
			StdDraw.setPenRadius(.01);
			StdDraw.rectangle(this.x, this.y, this.halfx, this.halfy);
			//outer
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledRectangle(this.x, this.y, this.halfx, this.halfy);
			//screen
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledRectangle(this.x, this.y, this.halfx-.013, this.halfy-.013);
			//text
			Font font = new Font("Arial", Font.BOLD, 20);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y+.15, "PHONE!");
	        //pic
	        StdDraw.picture(this.x,this.y-.05,"apple.png", this.halfx-.009,this.halfy-.05);
	        StdDraw.show();
		}
		//phone white
		else if (this.color == "white") {
			//outline
			StdDraw.setPenRadius(.01);
			StdDraw.rectangle(this.x, this.y, this.halfx, this.halfy);
			//outer
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(this.x, this.y, this.halfx, this.halfy);
			//screen
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledRectangle(this.x, this.y, this.halfx-.013, this.halfy-.013);
			//text
			Font font = new Font("Arial", Font.BOLD, 20);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y+.15, "PHONE!");
	        //pic
	        StdDraw.picture(this.x,this.y-.05,"apple.png", this.halfx-.009,this.halfy-.05);
	        StdDraw.show();
		}
		//phone yellow
		else if (this.color == "yellow") {
			//outline
			StdDraw.setPenRadius(.01);
			StdDraw.rectangle(this.x, this.y, this.halfx, this.halfy);
			//outer
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledRectangle(this.x, this.y, this.halfx, this.halfy);
			//screen
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledRectangle(this.x, this.y, this.halfx-.013, this.halfy-.013);
			//text
			Font font = new Font("Arial", Font.BOLD, 20);
	        StdDraw.setFont(font);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.text(this.x, this.y+.15, "PHONE!");
	        //pic
	        StdDraw.picture(this.x,this.y-.05,"apple.png", this.halfx-.009,this.halfy-.05);
	        StdDraw.pause(10);
		}
		
	}
	/***********************************************************************
     * Method:   spin                        		     	               *
     * Purpose:  User interface allowing the user to change the direction  *
     *           of the rotation of kirby clockwise or counter-clockwise   *
     *           using keyboard key "a" and "s"                            *                                   
     * Parameters: none  		                                           *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void spin() {
		int degree = 0;
		int direction = 0;
		while(true) {
			//picture
			StdDraw.picture(.18,.85, "kirby.jpg", .25, .25, degree);
			StdDraw.show();
			//spin kirby clockwise or counter-clockwise using letter "a" and "s" on keyboard
			if (StdDraw.hasNextKeyTyped()) {
				char ch = StdDraw.nextKeyTyped();
				if (ch == 'a')
					direction = 1;
				else if (ch == 's')
					direction = -1;
				else 
					direction = 0;
			}
			degree = (degree + direction)%360;
			StdDraw.show();
		}
	}

}
	
	