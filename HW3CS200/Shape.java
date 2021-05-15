
/**
 * CS 200 Homework Assignment 3
 * extra credit attempted
 * @author: Touchsada Jan On
 * @Due: 7 November 2020
 * @Turned in: 1 November 2020
 */
public interface Shape
{
   // set and get method for weight                 
    public void setWeight(double setWeight);
    public double getWeight();
     // method to calculate volume for Box, Sphere, and Cone
    public double calculateVolume(int[] arr);
    // method to calculate BestFit for Box, Sphere, and Cone
    public double calculateBestFit(int[] arr);
    // method to calculate waste for Box, Sphere, and Cone
    public double calculateWaste(int[] arr);
    // method to print the information about Box, Sphere, and Cone
}
