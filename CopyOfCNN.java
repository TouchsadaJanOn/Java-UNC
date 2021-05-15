//------------------------------------------------------------------------------//
//PROJECT TITLE: CS200 Homework Assignment 1
//PURPOSE OF PROJECT: Create 2D array and perform some calculation inside some 
//                    sliding windows based on this array. 
//DATE:  25 September 2020
//AUTHOR: TOUCHSADA JAN ON
//------------------------------------------------------------------------------//


import java.util.*;
import java.lang.Math;

public class CopyOfCNN
{
   //generate the original array 
    public static int[][] ArrGen(int ArrSize, int seed){  //2 parameter
        int[][] NumArr = new int[ArrSize][ArrSize];
        Random rand = new Random(seed); //random number with seed to get same printout everytime
        for (int i = 0; i < NumArr.length; i++){
            for (int j = 0; j < NumArr.length; j++){
            NumArr[i][j] = rand.nextInt(15);
            }
         }  
         return NumArr; //return array with random numbers
        }
        //caculate sum
       public static int[][] Sum(int[][] originalArr, int ArrSize, int Window){
            int n = ArrSize;
            int k = Window;
            int[][] SumArr = new int[n-k+1][n-k+1];
            int current_sum;

            for (int i = 0; i < n-k+1; i++) { 
                for (int j = 0; j < n-k+1; j++) {
                     current_sum = 0;
                     for (int t = 0; t < k; t++){
                         for (int w = 0; w< k; w++){
                             current_sum += originalArr[i+t][j+w];
                            }       
                    }  
                    SumArr[i][j] = current_sum;
                     
            }
        }
        for (int i = 0; i < n-k+1; i++){
            for (int j = 0; j < n-k+1; j++){
            System.out.print(String.format("%02d ", SumArr[i][j]));
            }
            System.out.println(" ");
         }  
        return SumArr;
    }
    //calculate average
    public static int[][] Average(int[][]originalArr, int ArrSize, int Window){
      int n = ArrSize;
      int k = Window;
      int [][] AverageArr = new int[n-k+1][n-k+1];
      int current_sum = 0;
      for (int i = 0; i < n-k+1; i++) {
                for (int j = 0; j < n-k+1; j++) {
                     current_sum = 0;
                     for (int t = 0; t < k; t++){
                         for (int w = 0; w< k; w++){
                             current_sum += originalArr[i+t][j+w];
                            }       
                    }  
                    AverageArr[i][j] = current_sum/(k*k);
                     
            }
        }
                //AverageArr[i][j] = (originalArr[i][j]+originalArr[i][j+1]+originalArr[i+1][j]+originalArr[i+1][j+1])/(k*2);
           
      for (int i = 0; i < n-k+1; i++){
            for (int j = 0; j < n-k+1; j++){
            System.out.print(String.format("%02d ", AverageArr[i][j]));
            }
            System.out.println(" ");
         }  
      return AverageArr;
    }
    //calculate min
   public static int[][] Min(int[][] originalArr, int ArrSize, int Window){
     int n = ArrSize;
     int k = Window;
      int [][] MinArr = new int[n-k+1][n-k+1];
      int min;
       for (int i = 0; i < n-k+1; i++)  
        {  
          for (int j = 0; j < n-k+1; j++) {
              min = originalArr[i][j];
              for (int t = 0; t < k; t++){
                         for (int w = 0; w< k; w++){
                             min = Math.min(min,originalArr[i+t][j+w]);
                            }       
                    }  
              //min = Math.min(originalArr[i][j],originalArr[i][j+1]);
              //min = Math.min(min,originalArr[i+1][j]);
              //min = Math.min(min, originalArr[i+1][j+1]);
              MinArr[i][j] = min; 
        }
    }  
      for (int i = 0; i < n-k+1; i++){
            for (int j = 0; j < n-k+1; j++){
            System.out.print(String.format("%02d ", MinArr[i][j]));
            }
            System.out.println(" ");
         }  
         return MinArr;
   }
   //calculate max
   public static int[][] Max(int[][] originalArr, int ArrSize, int Window){
     int n = ArrSize;
      int k = Window;
      int [][] MaxArr = new int[n-k+1][n-k+1];
      int max;
       for (int i = 0; i < n-k +1; i++)  
        {  
          for (int j = 0; j < n-k+1; j++) {
              max = originalArr[i][j];
              for (int t = 0; t < k; t++){
                         for (int w = 0; w< k; w++){
                             max = Math.max(max,originalArr[i+t][j+w]);
                            }       
                    }  
              //max = Math.max(originalArr[i][j],originalArr[i][j+1]);
              //max = Math.max(max,originalArr[i+1][j]);
              //max = Math.max(max,originalArr[i+1][j+1]);
              MaxArr[i][j] = max;
           
        }
    }  
      for (int i = 0; i < n-k+1; i++){
            for (int j = 0; j < n-k+1; j++){
            System.out.print(String.format("%02d ", MaxArr[i][j]));
            }
            System.out.println(" ");
         }  
         return MaxArr;
   }
   
    public static void main(String args[])
    {
        //Error Checking on user input
   try{
       int ArrSize = 0;
       int seed = 0;
       int Window = 0;
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the array size (an integer between 2 and 8): ");
       ArrSize = input.nextInt();
       int [][] originalArr = new int[ArrSize][ArrSize];
       //checking array size between 2-8 
    while(true){  
          if(ArrSize >= 2 && ArrSize <=8){
           System.out.print("Enter an positive integer seed: ");
           seed = input.nextInt();
           System.out.print("Enter a window value within your Array Size: ");
           Window = input.nextInt(); //user pick various window sizes
            break;
         }else{
        System.out.println("That number is outside the range of possible values. Try again.");
        System.out.print("Enter the array size (an integer between 2 and 8): ");
        ArrSize = input.nextInt();
      }
    }
    //original array with printing format with leading zero
    System.out.println("\nMain array: ");
    originalArr = ArrGen(ArrSize, seed);
    for (int i = 0; i < ArrSize; i++){
            for (int j = 0; j < ArrSize; j++){
            System.out.print(String.format("%02d ", originalArr[i][j]));
            }
            System.out.println(" ");
         }  
         //calling on sum method
    System.out.println("\nSum array: ");
    Sum(originalArr, ArrSize, Window);
    //calling average method
    System.out.println("\nAvg array: ");
    Average(originalArr, ArrSize, Window);
    //calling min method
    System.out.println("\nMin array: ");
    Min(originalArr, ArrSize, Window);
    //calling max method
    System.out.println("\nMax array: ");
    Max(originalArr, ArrSize, Window);
    //user input error exception
    }catch (Exception e) {
    System.out.println("Something went wrong, please follows the instructions and run this program again.");
   }
 }
}
