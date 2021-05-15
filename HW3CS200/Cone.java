
/**
 * CS 200 Homework Assignment 3
 * extra credit attempted
 * @author: Touchsada Jan On
 * @Due: 7 November 2020
 * @Turned in: 1 November 2020
 */
public class Cone implements Shape
{
    // instance variables - replace the example below with your own
    private int height, diameter;
    private double weight;

    /**
     * Constructor for objects of class Cone
     */
    public Cone(int userHeight, int userDiameter, double userWeight)
    {
        // initialise instance variables
        height = userHeight;
        diameter = userDiameter;
        weight = userWeight;
    }
    //set weight
    @Override
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
    //calculate volume
    public double calculateVolume(int[] arr){
        int coneDiameter = arr[1];
        int coneHeight = arr[2];
        //if (diameter >= userHeight)
        double radius = (double)coneDiameter/(double)2;
        double volume = (Math.PI * Math.pow(radius, 2)*coneHeight)/(double)3;
        return volume;
    }
    //calculate density method
    public double calculateDensity(int[] arr, double userWeight){
        double density = (double)userWeight/(double)calculateVolume(arr); //
        return density;
    }
    @Override
    //calculate best fit
    public double calculateBestFit(int[] arr){
    double fit = arr[1]*arr[1]*arr[2];
    return fit;
    }
    @Override
    //calculate waste
    public double calculateWaste(int[] arr){
    double wasteSpace = (double)(calculateBestFit(arr)-calculateVolume(arr)) / calculateBestFit(arr);
    return  wasteSpace;
    }
    public void dimensionCone(){
        System.out.print("A Cone of height "+getHeight() + ", diameter "+getDiameter());
        System.out.printf( ", and weight %.2f lb. created.\n", getWeight());
    }
    public void printCone(int[] arr, double userWeight){
        System.out.printf("%-8s %.2f %6s %26s %.2f %10s %n", "Cone volume: ", calculateVolume(arr),"cu ft", "Cone density: "
        , calculateDensity(arr,userWeight), "lbs./cu ft"); 
    }
    public void containerCone(int[] arr){
        System.out.printf("%.2f cu ft for a Cone (%.2f%% waste)\n",calculateBestFit(arr), calculateWaste(arr)*100);
    }
}
