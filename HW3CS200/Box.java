
/**
 * CS 200 Homework Assignment 3
 * extra credit attempted
 * @author: Touchsada Jan On
 * @Due: 7 November 2020
 * @Turned in: 1 November 2020
 */
import java.util.*;

public class Box implements Shape
{
    // instance variables
    private int length, width,height;
    private double weight;

    // Constructor for objects of class Box
    public Box(int newLength, int newWidth, int newHeight, double newWeight)
    {
        this.length = newLength;
        this.width = newWidth;
        this.height = newHeight;
        this.weight = newWeight;
    }
    //set length
    public void setLength(int setLength)
    {
        this.length = setLength;
       
    }
    //return length
    public int getLength()
    {
        return this.length;
       
    }
    //set width
    public void setWidth(int setWidth)
    {
        this.width = setWidth;
       
    }
    //return width
    public int getWidth()
    {
        return this.width;
       
    }
    //set height
    public void setHeight(int setHeight)
    {
        this.height = setHeight;
       
    }
    //return height
    public int getHeight()
    {
        return this.height;
       
    }
    @Override
    public void setWeight(double setWeight)
    {
        this.weight = setWeight;
       
    }
    @Override
    //return height
    public double getWeight()
    {
        return weight;
       
    }
    @Override
    //calculate volume method
    public double calculateVolume(int[] arr){ 
        double volume = arr[0]*arr[1]*arr[2];
        return volume;
    }
    //calculate density method
    public double calculateDensity(int[] arr, double userWeight){
        double density = userWeight/calculateVolume(arr); //
        return density;
    }
    @Override
    public double calculateBestFit(int[] arr){
    double fit = arr[0]*arr[1]*arr[2];
    return fit;
    }
    @Override
    public double calculateWaste(int[] arr){
    double wasteSpace = (double)(calculateBestFit(arr)-calculateVolume(arr)) / calculateBestFit(arr);
    return  wasteSpace;
    }
    public void dimensionBox(){
        System.out.print("\nA Box of length "+getLength() + ", width "+getWidth() + ", height " + getHeight());
        System.out.printf( ", and weight %.2f lb. created.\n", getWeight());
    }
    public void printBox(int[] arr, double userWeight){
        System.out.printf("%-8s %.2f %6s %25s %.2f %10s %n", "Box volume: ", calculateVolume(arr),"cu ft", "Box density: "
        , calculateDensity(arr,userWeight), "lbs./cu ft"); 
    }
    public void containerBox(int[] arr){
        System.out.printf("%.2f cu ft for a Box (%.2f%% waste)\n",calculateBestFit(arr), calculateWaste(arr)*100);
    }
    
}