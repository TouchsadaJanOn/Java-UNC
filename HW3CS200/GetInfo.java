
/**
 * CS 200 Homework Assignment 3
 * extra credit attempted
 * @author: Touchsada Jan On
 * @Due: 7 November 2020
 * @Turned in: 1 November 2020
 */
import java.util.*;

public class GetInfo
{
     public static int getLength(Scanner scnr) throws Exception {
      int length = 0; 
      boolean exit = false;
           while(!exit){
               try{
                   // Get user data
                  System.out.print("Enter the length: ");
                  length = scnr.nextInt();
                try{
                   //Error checking, non-negative length
                    if (length <= 0) {
                        throw new Exception("Invalid entry. Only positive integers > 0. Please re-enter.");
                    }
                    else{
                        exit = true;
                    }
                }
                catch (Exception ex){
                System.out.println(ex.getMessage()); 
               }
               
               } catch (Exception ex1) {
                System.out.println("Invalid entry. Only positive integers > 0. Please re-enter.");
                scnr.nextLine();
               }
               
            }
      return length;
   }
   public static int getWidth(Scanner scnr) throws Exception {
      int width=0; 
      boolean exit =false;
       while(!exit){
               try{
                   // Get user data
                  System.out.print("Enter the width: ");
                  width = scnr.nextInt();
                try{
                   //Error checking, non-negative width
                    if (width <= 0) {
                        throw new Exception("Invalid entry. Only positive integers > 0. Please re-enter.");
                    }
                    else{
                        exit = true;
                    }
                }
                catch (Exception ex){
                System.out.println(ex.getMessage()); 
               }
               
               } catch (Exception ex1) {
                System.out.println("Invalid entry. Only positive integers > 0. Please re-enter.");
                scnr.nextLine();
               }
               
            }
      return width;
   }
   public static int getHeight(Scanner scnr) throws Exception {
      int height=0; 
      boolean exit = false;
          while(!exit){
               try{
                   // Get user data
                  System.out.print("Enter the height: ");
                  height = scnr.nextInt();
                try{
                   //Error checking, non-negative height
                    if (height <= 0) {
                        throw new Exception("Invalid entry. Only positive integers > 0. Please re-enter.");
                    }
                    else{
                        exit = true;
                    }
                }
                catch (Exception ex){
                System.out.println(ex.getMessage()); 
               }
               
               } catch (Exception ex1) {
                System.out.println("Invalid entry. Only positive integers > 0. Please re-enter.");
                scnr.nextLine();
               }
               
            }
      return height;
   }
   public static double getWeight(Scanner scnr) throws Exception {
      double weight=0; //initialized variable
      boolean exit = false;
           while(!exit){
               try{
                   // Get user data
                  System.out.print("Enter the weight: ");
                  weight = scnr.nextDouble();
                  // Error checking, non-negative weight
                    if (weight <= 0) {
                        throw new Exception("Invalid entry. Only positive integers > 0. Please re-enter.");
                    }
                    else{
                        exit = true;
                    }
    
                }catch (Exception ex){
                System.out.println(ex.getMessage()); 
                }
            }
      return weight;
   }
    
    public static void main(String[] args){
              int diameter = 0;
              int[] arr = new int[3];
              Scanner scnr = new Scanner(System.in);  
              boolean exit = false; 
            try{
                
                 int userLength = getLength(scnr);
                 int userWidth = getWidth(scnr);
                 int userHeight = getHeight(scnr); 
                 double userWeight = getWeight(scnr); 
                
                
                 arr[0] = userLength;
                 arr[1] = userWidth;
                 arr[2] = userHeight;
                 
                 Arrays.sort(arr);  //sort array from min to max
                 int sphereDia = arr[2]; //found the largest value
                 int coneDia = arr[1]; //found the second smallest value
         
                  Box myBox = new Box(userLength,userWidth,userHeight, userWeight); //object for box
                  Sphere mySphere = new Sphere(sphereDia, userWeight); //object for sphere
                  Cone myCone = new Cone(sphereDia, coneDia,userWeight); //object for cone
                   
                  myBox.dimensionBox(); //print box dimension
                  myCone.dimensionCone(); //print cone dimension
                  mySphere.dimensionSphere(); //print sphere dimension
                  System.out.println("\n");
                  
                  myBox.printBox(arr, userWeight); //print box calculation
                  myCone.printCone(arr, userWeight); //print cone calculation
                  mySphere.printSphere(arr, userWeight); //print sphere calculation
                  
                  System.out.println("\nAn object container would need to be: ");
                  myBox.containerBox(arr); //print box's waste and best fit
                  myCone.containerCone(arr); //print cone's waste and best fit
                  mySphere.containerSphere(arr); //print sphere's waste and best fit
                  
             }catch (Exception ex){
                System.out.println(ex.getMessage()); 
                }
            }
   }


