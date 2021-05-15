
/**
 * CS 200 Homework Assignment 2
 *
 * @author: Touchsada Jan On
 * @Due: 17 October 2020
 * @Turned in: 15 October 2020
 */
public abstract class Shape
{
    // instance variables 
    protected int weight;
    //contructor
    public Shape()
    {
        weight = 0;
    }
    //constructor
    public Shape(int newWeight){
        weight = newWeight;
    }
    //set method
    public void setWeight(int setWeight){
        weight = setWeight;
    }
    //get method
   public int getWeight(){
       return weight; 
    }
}
