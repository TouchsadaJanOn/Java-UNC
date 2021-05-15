
/**
 * CS 200 Homework Assignment 3
 * extra credit attempted
 * @author: Touchsada Jan On
 * @Due: 7 November 2020
 * @Turned in: 1 November 2020
 */
import java.util.*;

public class Sphere implements Shape
{
    // instance variables - replace the example below with your own
    private int diameter;
    private double weight;

    /**
     * Constructor for objects of class Sphere
     */
    public Sphere(int userDiameter, double userWeight)
    {
        // initialise instance variables
        diameter = userDiameter;
        weight = userWeight;
    }
    @Override
    //set weight
    public void setWeight(double userWeight)
    {
        weight = userWeight;
       
    }
    @Override
    //return weight
    public double getWeight()
    {
        return weight;
       
    }
    //set diameter
    public void setDiameter(int userDiameter)
    {
        diameter = userDiameter;
       
    }
    //return diamter
    public int getDiameter()
    {
        return diameter;
       
    }
    @Override
    public double calculateVolume(int[] arr){
        int diameter = arr[2];
        //if (diameter >= userHeight)
        double radius = (double)diameter/2;
        double volume = (4 * Math.PI * Math.pow(radius, 3))/3;
        return volume;
    }
    //calculate density method
    public double calculateDensity(int[] arr, double userWeight){
        double density = userWeight/calculateVolume(arr); //
        return density;
    }
    @Override
    //calculate best fit method
    public double calculateBestFit(int[] arr){
    double fit = arr[2]*arr[2]*arr[2];
    return fit;
    }
    @Override
    //calculate waste method
    public double calculateWaste(int[] arr){
    double wasteSpace = (double)(calculateBestFit(arr)-calculateVolume(arr)) / (double)calculateBestFit(arr);
    return  wasteSpace;
    }
    
    public void dimensionSphere(){
    System.out.print("A Sphere of diameter "+getDiameter());
    System.out.printf( " and weight %.2f lb. created.", getWeight());
    }
    
    public void printSphere(int[] arr, double userWeight){
        System.out.printf("%-8s %.2f %6s %25s %.2f %10s %n", "Sphere volume: ", calculateVolume(arr),"cu ft", "Sphere density: "
        , calculateDensity(arr,userWeight), "lbs./cu ft"); 
    }
    
    public void containerSphere(int[] arr){
        System.out.printf("%.2f cu ft for a Sphere (%.2f%% waste)\n\n",calculateBestFit(arr), calculateWaste(arr)*100);
    }

    
    
}
