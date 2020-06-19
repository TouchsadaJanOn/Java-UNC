package Clock;
/*******************************************************************************
*                     Assignment 5 -- Cuckoo Clock Simulation			       *
*                                                                              *
* PROGRAMMER:        Touchsada Jan On (tjcomputer13@gmail.com)                 *
* CLASS:             CS160 – Structured Programming                            *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   February 28, 2020 (Early Submission)                      *
*                                                                              *
* DESCRIPTION:                                                                 *
* This program simulate an antique cuckoo clock using combination of OOP       *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2020 Touchsada Jan On and Dean Zeller.          *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Cuckoo 
{
	// Defining attributes
	private int currentHour, startHour, endHour, currentMinute;
	private String cuckooSound, ticSound;
	
	/***********************************************************************
     * Method:   Cuckoo (Constructor)                                      *
     * Purpose:  Allow object's argument to run the program with specific  *
     * 			 CuckooSound and ticSound								   *                                   
     * Parameters: cuckooSound and ticSound 							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	//Constructor1
	public Cuckoo(String cuckooSound, String ticSound) {
	    this.cuckooSound = cuckooSound;
	    this.ticSound = ticSound;
	  }
	/***********************************************************************
     * Method:   Cuckoo (Constructor)                                      *
     * Purpose:  Allow object's argument to run the program with specific  *
     * 			 CuckooSound 											   *                                   
     * Parameters: cuckooSound 											   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	//Constructor2
	public Cuckoo(String cuckooSound) {
	    this.ticSound = "tic";
	    this.cuckooSound = cuckooSound;
	  }
	/***********************************************************************
     * Method:   Cuckoo (Constructor)                                      *
     * Purpose:  Allow object's argument to run the program with a default *
     * 			 cuckooSound and ticSound								   *                                   
     * Parameters: 							 							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	//Constructor3
	public Cuckoo() {
	    this.cuckooSound = "Cuckoo!";
	    this.ticSound = "tic";
	  }
	//Objects for musicMethod
	File Tic = new File("clock-ticking-2.wav");
	File Hour = new File("CUCKOO1.wav");
	
	/***********************************************************************
     * Method:   runHourlyChimes 	                                       *
     * Purpose:  Simulate the hourly chimes of a cuckoo clock              *
     * 			 [Clocks are 12 hours]								       *                                   
     * Parameters: 	int startHour, int endHour							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	
	public void runHourlyChimes(int startHour, int endHour)
	{	
	    System.out.print("Beginning cuckoo clock simulation");
	    this.startHour = startHour;
	    this.endHour = endHour;
	       while (true) 
	        {
	            System.out.print("\n["+ this.startHour +":00] It's "+ this.startHour +" o'clock! ");
	            for (int i = 1; i <= this.startHour; i++) 
	            {	                
	                System.out.print(this.cuckooSound+ " ");
	                //playSound(Hour);
	            }
	                if (this.startHour == this.endHour) 
	                {
	                    System.out.println("\nEnding simulation");
	                    System.out.println();
	                    break;           
	                }
	                else
	                {
	                    this.startHour += 1;
	                }
	                if (this.startHour == 13 )
	                {
	                    this.startHour = 1;
	                } 
	        }     
	}
	
	/***********************************************************************
     * Method:   runChimesAndTics 	                                       *
     * Purpose:  Simulate the tic sounds every minute                      *
     * 			 [Clocks are 12 hours]								       *                                   
     * Parameters: 	int startHour, int endHour							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	
	public void runChimesAndTics(int startHour, int endHour)
	{
		System.out.print("Beginning cuckoo clock simulation");
		this.startHour = startHour;
		this.endHour = endHour;
		this.currentMinute = 1;
		
	       while (true) 
	        { 
	    	   System.out.println();
	            System.out.print("\n["+ this.startHour +":00] It's "+ this.startHour +" o'clock! ");
	            for (int i = 1; i <= this.startHour; i++) 
	            {	                
	                System.out.print(this.cuckooSound+ " ");
	                //playSound(Hour);
	            }
	            
	            System.out.println();
	            
	            for (int j = 1; j < 10; j++ ) 
	            {
	            	System.out.print("[" +this.startHour+":0"+j+"] " + this.ticSound + " ");
	            	//playSound(Tic);
	            }
	            for (int j = 10; j <= 59; j++ ) 
	            {
	            	System.out.print("[" +this.startHour+":"+j+"] " + this.ticSound + " ");
	            	//playSound(Tic);
	            	
	            }
	            	
	                if (this.startHour == this.endHour-1) 
	                {
	                	System.out.println();
	                	System.out.print("\n["+ this.endHour +":00] It's "+ this.endHour +" o'clock! ");
	                	 for (int i = 1; i <= this.endHour; i++) 
	     	            {	                
	     	                System.out.print(this.cuckooSound+ " ");
	     	                //playSound(Hour);
	     	            }
	                	System.out.println();
	                    System.out.println("\nEnding simulation");
	                    System.out.println();
	                    break;
	                    
	                }
	                else
	                {
	                    this.startHour += 1;
	                }
	                if (this.startHour == 13 )
	                {
	                    this.startHour = 1;
	                }	                
           }        
	}
	/***********************************************************************
     * Method:   runChimesTicsQuarters                                     *
     * Purpose:  Simulate the tic sounds every minute and cuckoo           *
     * 			 every quarter - hour [Clocks are 12 hours]			       *                                   
     * Parameters: 	int startHour, int endHour							   *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public void runChimesTicsQuarters(int startHour, int endHour)
	{
		this.startHour = startHour;
		this.endHour = endHour;
		System.out.print("Beginning cuckoo clock simulation");
		this.currentMinute = 1;
		
	       while (true) 
	        {
	    	   System.out.println();
	            System.out.print("\n["+ this.startHour +":00] It's "+ this.startHour +" o'clock! ");
	            for (int i = 1; i <= this.startHour; i++) 
	            {	                
	                System.out.print(this.cuckooSound+ " ");
	                //playSound(Hour);
	            }
	            System.out.println();
	            for (this.currentMinute = 1; this.currentMinute < 10; this.currentMinute++ ) 
	            {
	            		System.out.print("[" +this.startHour+":0"+this.currentMinute+"] " + this.ticSound +" ");
	            		//playSound(Tic);
	            }
	            for (this.currentMinute = 10; this.currentMinute <= 59; this.currentMinute++ ) 
	            {
	            	if (this.currentMinute % 15 == 0) 
	            	{
	            		System.out.print("\n[" +this.startHour+":"+this.currentMinute+"] " + this.cuckooSound + " \n");
	            		//playSound(Hour);
	            	} 
	            	else
	            	{
	            	System.out.print("[" +this.startHour+":"+this.currentMinute+"] " + this.ticSound + " ");
	            	//playSound(Tic);
	            	}
	            }
	            	
	            if (this.startHour == this.endHour-1) 
                {
	            	System.out.println();
                	System.out.print("\n["+ this.endHour +":00] It's "+ this.endHour +" o'clock! ");
                	 for (int i = 1; i <= this.endHour; i++) 
     	            {	                
     	                System.out.print(this.cuckooSound+ " ");
     	                //playSound(Hour);
     	            }
                	System.out.println();
                    System.out.println("\nEnding simulation");
                    System.out.println();
                    break;
                    
                }
	                else
	                {
	                    this.startHour += 1;
	                }
	                if (this.startHour == 13 )
	                {
	                    this.startHour = 1;
	                }	                
           }        
	}

	/***********************************************************************
     * Method:   playSound (tic/cuckoo)                                    *
     * Purpose:  Simulate the tic sound for minute and cuckoo for hour     *                                   
     * Parameters: 	File Sound						                       *
     * Return-Value: None                                                  *      
     ***********************************************************************/
	public static void playSound(File Sound) {
			
			try {
				Clip minute = AudioSystem.getClip();
				minute.open(AudioSystem.getAudioInputStream(Sound));
				minute.start();
				Thread.sleep(1000);
				minute.stop();
			}
			catch (Exception e ) 
			{
				
			}
		}
}

