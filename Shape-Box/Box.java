
/**
 * CS 200 Homework Assignment 2
 * 
 * @author: Touchsada Jan On
 * @Due: 17 October 2020
 * @Turned in: 15 October 2020
 */
import java.util.*;

public class Box extends Shape
{
    // instance variables
    private int length, width,height;

    // Constructor for objects of class Box
    public Box()
    {
        // initialize instance variables
        length = 0;
        width = 0;
        height = 0;
    }
    //contructor
    public Box(int newLength, int newWidth, int newHeight, int newWeight)
    {
        length = newLength;
        width = newWidth;
        height = newHeight;
        weight = newWeight;
    }
    //set length
    public void setLength(int setLength)
    {
        length = setLength;
       
    }
    //return length
    public int getLength()
    {
        return length;
       
    }
    //set width
    public void setWidth(int setWidth)
    {
        width = setWidth;
       
    }
    //return width
    public int getWidth()
    {
        return width;
       
    }
    //set height
    public void setHeight(int setHeight)
    {
        height = setHeight;
       
    }
    //return height
    public int getHeight()
    {
        return height;
       
    }
    //boolean if box is a cube method
    public boolean isACube(){
        boolean isCube = false;
        if (getLength() == getWidth() && getLength() == getHeight() && getWidth() == getHeight()){
            isCube = true;
        }
        return isCube;
    }
    //boolean if box is a square method
    public boolean hasASquare(){
        boolean isSquare = false;
        if (getLength() == getWidth() || getLength() == getHeight() || getWidth() == getHeight()){
            isSquare = true;
        }
        return isSquare;
    }
    //calculate volume method
    public int calculateVolume(){
        int volume = getLength()*getWidth()*getHeight();
        return volume;
    }
    //calculate density method
    public Double calculateDensity(){
        double density;
        if (calculateVolume() == 0){
            density = 0;
        } else {
            density = getWeight()/(double)calculateVolume();
        }
        return density;
    }
    //boolean if box is hea
    public boolean isHeavy(){
        boolean isHeavy = false;
        if (calculateDensity()  >= 10.00){
            isHeavy = true;
        }
        return isHeavy;
    }
    //main method
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    //user input
    System.out.print("Enter the box length: ");
    int userlength = input.nextInt();
    System.out.print("Enter the box width: ");
    int userwidth = input.nextInt();
    System.out.print("Enter the box height: ");
    int userheight = input.nextInt();
    System.out.print("Enter the box weight: ");
    int userweight = input.nextInt();
    
    //Box Object
    Box mybox = new Box();
    //set values
    mybox.setLength(userlength);
    mybox.setWidth(userwidth);
    mybox.setHeight(userheight);
    mybox.setWeight(userweight);
    //output desire methods
    System.out.println("The volume of the box is " + mybox.calculateVolume() + " cubic feet.");
    System.out.printf("The density of the box is %.2f lbs./cubic ft.\n", mybox.calculateDensity());
        //determine if box are square
        if (mybox.hasASquare() == true){
            System.out.println("At least one side of the box is square.");
        }else{
           System.out.println("No sides of box are square.");
        }
        //determine if box is cube
        if (mybox.isACube() == true){
            System.out.println("The box is a cube.");
        }else{
           System.out.println("The box is not a cube.");
        }
        //determine if box is heavy
        if (mybox.isHeavy() == true){
            System.out.println("The box is heavy.");
        }else{
           System.out.println("The box is not heavy.");
        }
    }
}
