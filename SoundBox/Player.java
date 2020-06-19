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
* This program will allow users to interact with their keyboard in order to    *
* displays sound effects, each sounds effects will be different according      *
* to the character on the keyboard that was pressed							   *					
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/
import java.awt.Font;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Player {
	// defining attributes
	private int xpos, ypos, radius;
	
	//Objects for playSound
	File airplane = new File("airplane_chime_x.wav");
	File applause = new File("applause_y.wav");
	File arrow = new File("arrow_x.wav");
	File disk = new File("bad_disk_x.wav");
	File blip = new File("blip.wav");
	File baseball = new File("baseball_hit.wav");
	File boxing = new File("boxing_bell.wav");
	File crash = new File("crash_x.wav");
	File drum = new File("drum_roll_y.wav");
	File cannon = new File("cannon_x.wav");
	File m16 = new File("m16_x.wav");
	File klaxon = new File("klaxon_ahooga.wav");
	File jingle = new File("jingle_bells_x.wav");
	File honk = new File("honk_x.wav");
	File gong = new File("peeeooop_x.wav");
	File modem1 = new File("modem1.wav");

	/***********************************************************************
     * Method:   setup                                                     *
     * Purpose:  Where most method will be called upon and gather in order *
     *  		 to keep everything organized.						       *                                   
     * Parameters: None                      							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void setup() 
	{
		this.radius = 8;
		//letter configuration
		Font font = new Font("Arial", Font.BOLD, 39);
    	StdDraw.setFont(font);
		StdDraw.setScale(-40, 40);
		//background
		StdDraw.clear(StdDraw.BLACK);
	
		//Dots for columns
		first();
		second();
		third();
		fourth();
		banner();
	}
	/***********************************************************************
     * Method:   first                                                     *
     * Purpose:  first four circle in the first column will be drawn;      *
     * 			 including letters according to those circle		       *                                   
     * Parameters: None                      							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void first() {
		String[] letter1 = {"A", "S", "D", "F"}; 
		this.xpos = -30;
		this.ypos = 30;
			while (true) {
				//use to display each letter in array
				for (int i=0; i<letter1.length;i++) {
					//big circle
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.filledCircle(this.xpos, this.ypos, this.radius);
					//small circle
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledCircle(this.xpos, this.ypos, 5);
					//letter
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.text(this.xpos, this.ypos, letter1[i]);
					//circle increment
					this.xpos += 20;
					//break loop
				}
				if (xpos >= 40) 
					break;
			}
	}
	/***********************************************************************
     * Method:   second                                                    *
     * Purpose:  Four circle in the second column will be drawn;           *
     * 			 including letters according to those circle		       *                                   
     * Parameters: None                      							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void second() {
		String[] letter2 = {"G", "H", "J", "K"}; 
		this.xpos = -30;
		this.ypos = 11;
			while (true) {
				//use to display each letter in array
				for (int i=0; i<letter2.length;i++) {
					//big circle
					StdDraw.setPenColor(StdDraw.MAGENTA);
					StdDraw.filledCircle(this.xpos, this.ypos, this.radius);
					//small circle
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledCircle(this.xpos, this.ypos, 5);
					//letter
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.text(this.xpos, this.ypos, letter2[i]);
					//circle increment
					this.xpos += 20;
					//break loop
				}
				if (xpos >= 40) 
					break;
				}
		
	}
	/***********************************************************************
     * Method:   third                                                     *
     * Purpose:  Four circle in the third column will be drawn;            *
     * 			 including letters according to those circle		       *                                   
     * Parameters: None                      							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void third() {
		String[] letter3 = {"L", "Z", "X", "C"}; 
		this.xpos = -30;
		this.ypos = -7;
			while (true) {
				//use to display each letter in array
				for (int i=0; i<letter3.length;i++) {
					//big circle
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledCircle(this.xpos, this.ypos, this.radius);
					//small circle
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledCircle(this.xpos, this.ypos, 5);
					//letter
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.text(this.xpos, this.ypos, letter3[i]);
					//circle increment
					this.xpos += 20;
					//break loop
				}
				if (xpos >= 40) 
					break;
				}
	}
	/***********************************************************************
     * Method:   fourth                                                    *
     * Purpose:  Four circle in the fourth column will be drawn;           *
     * 			 including letters according to those circle		       *                                   
     * Parameters: None                      							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void fourth() {
		//array of letter
		String[] letter4 = {"V", "B", "N", "M"}; 
		this.xpos = -30;
		this.ypos = -25;
			while (true) {
				//use to display each letter in array
				for (int i=0; i<letter4.length;i++) {
					//big circle
					StdDraw.setPenColor(StdDraw.CYAN);
					StdDraw.filledCircle(this.xpos, this.ypos, this.radius);
					//small circle
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledCircle(this.xpos, this.ypos, 5);
					//letter
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.text(this.xpos, this.ypos, letter4[i]);
					//circle increment
					this.xpos += 20;
					//break loop
				}
				if (xpos >= 40) 
					break;
				}
	}
	/***********************************************************************
     * Method:   playSound                                                 *
     * Purpose:  Simulate and play the sound files for method that called  *
     * 			 upon                                                      *                                   
     * Parameters: 	File Sound						                       *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public static void playSound(File Sound) {
		
		try {
			//creating object
			Clip minute = AudioSystem.getClip();
			//read the sound file
			minute.open(AudioSystem.getAudioInputStream(Sound));
			minute.start();
			Thread.sleep(1000);
			minute.stop();
		}
		catch (Exception e ) 
		{
			
		}
	}
	/***********************************************************************
     * Method:   button                                                    *
     * Purpose:  allocate the keyboard character to each sound files       *                                   
     * Parameters: None                      							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void button() {
		while (true) {
			if (StdDraw.hasNextKeyTyped()) {
				char ch = StdDraw.nextKeyTyped();
				// if user push character a
				if (ch == 'a') {
					playSound(airplane);
					banner();
					System.out.print("You pressed " + ch +" The Sound of AIRPLANE\n");
				}// if user push character s
				else if (ch == 's') {
					playSound(applause);
					banner();
					System.out.print("You pressed " + ch + " The Sound of APPLAUSE\n");
				}// if user push character d
				else if (ch == 'd') {
					playSound(arrow);
					banner();
					System.out.print("You pressed " + ch +" The Sound of ARROW\n");
				}// if user push character f
				else if (ch == 'f') {
					playSound(disk);
					banner();
					System.out.print("You pressed " + ch +" The Sound of DISK\n");
				}// if user push character g
				else if (ch == 'g') {
					playSound(m16);
					banner();
					System.out.print("You pressed " + ch +" The Sound of M16\n");
				}// if user push character h
				else if (ch == 'h') 
				{
					playSound(klaxon);
					banner();
					System.out.print("You pressed " + ch +" The Sound of KLAXON\n");
				}// if user push character j
				else if (ch == 'j') {
					playSound(blip);
					banner();
					System.out.print("You pressed " + ch +" The Sound of BLIP\n");
				}// if user push character k
				else if (ch == 'k') {
					playSound(baseball);
					banner();
					System.out.print("You pressed " + ch +" The Sound of BASEBALL\n");
				}// if user push character l
				else if (ch == 'l') {
					playSound(boxing);
					banner();
					System.out.print("You pressed " + ch +" The Sound of BOXING\n");
				}// if user push character z
				else if (ch == 'z') {
					playSound(crash);
					banner();
					System.out.print("You pressed " + ch +" The Sound of CRASH\n");
				}// if user push character x
				else if (ch == 'x') {
					playSound(drum);
					banner();
					System.out.print("You pressed " + ch +" The Sound of DRUM\n");
				}// if user push character c
				else if (ch == 'c') {
					playSound(cannon);
					banner();
					System.out.print("You pressed " + ch +" The Sound of CANNON\n");
				}// if user push character v
				else if (ch == 'v') {
					playSound(jingle);
					banner();
					System.out.print("You pressed " + ch +" The Sound of JINGLE\n");
				}// if user push character b
				else if (ch == 'b') {
					playSound(honk);
					banner(); 
					System.out.print("You pressed " + ch +" The Sound of HONK\n");
				}// if user push character n
				else if (ch == 'n') {
					playSound(gong);
					banner();
					System.out.print("You pressed " + ch +" The Sound of GONG\n");
				}// if user push character m
				else if (ch == 'm') 
				{
					playSound(modem1);
					banner();
					System.out.print("You pressed " + ch +" The Sound of MODEM\n");
				}
				//if users doesn't push the right button
				else
				{
					Font font = new Font("Arial", Font.BOLD, 29);
				    StdDraw.setFont(font);
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.text(0, -38, "This Character NOT on displayed");
					System.out.print("You pressed " + ch +" BUT NOT ON DISPLAYED, No Sound will Play \n");
				}
				
				}
			}
		}
	/***********************************************************************
     * Method:   banner                                                    *
     * Purpose:  displayed and draw a plane banner on the bottom of the    *
     * 			 canvas		                                               *                                   
     * Parameters: None                      							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void banner() {
		//bottom line
		StdDraw.setPenColor(StdDraw.ORANGE);
		StdDraw.filledRectangle(0, -39, 40, 4);
	}
}
			


