/**
 * CS 200 Homework Assignment 4
 * @author: Touchsada Jan On
 * @Due: 29 November 2020
 * @Turned in: 22 November 2020
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
 
/**
 * adopted from Crunchify.com
 * 
 */
 
public class CSVtoArrayList {
    public static void main(String[] args) {
        ArrayList<FileData> fromFile = new ArrayList<FileData>();
        Scanner input = new Scanner(System.in);
        BufferedReader readBuffer = null;
        boolean exit_main = false; // all boolean use for try/catch purposes
        boolean exit_second = false;
        boolean exit_third = false;
        boolean exit_fourth = false;
        boolean exit_fifth = false;
        System.out.println("Welcome to Lyme Disease Counts (1992-2011)!\n");

        try {
            String inputLine;
            //prompt the user for the absolute path of the filename, this filename is hardcoded as an example
            System.out.println("Enter a full pathname and filename for the input file: ");
            String userFile = input.nextLine(); //read user input
            readBuffer = new BufferedReader(new FileReader(userFile));
            // Ensure the loaded fromFile ignores the header row
            readBuffer.readLine();
           while ((inputLine = readBuffer.readLine()) != null) {  
               //instantiating FileData and passing infomation from arraylist to contructor
                FileData file = new FileData(Integer.parseInt(CSVtoArrayList(inputLine).get(0)),Integer.parseInt(CSVtoArrayList(inputLine).get(1)),
                        (CSVtoArrayList(inputLine).get(2)),(CSVtoArrayList(inputLine).get(3)), Integer.parseInt(CSVtoArrayList(inputLine).get(4)), 
                        Integer.parseInt(CSVtoArrayList(inputLine).get(5)), Integer.parseInt(CSVtoArrayList(inputLine).get(6)),
                        Integer.parseInt(CSVtoArrayList(inputLine).get(7)));
                fromFile.add(file); //add info from "file" to another arraylist
            }
            
            
            System.out.println();
            System.out.println("  Reading file…. Done\n");
            System.out.println();
            while(!exit_main){
                try{
                  System.out.print("Do you wish to (1) Search or (2) Sort by a column? (Enter 1 or 2): ");
                  int userChoice1 = input.nextInt(); //user input for sort or search
                  if (userChoice1 <= 0 | userChoice1 >= 3){
                        throw new Exception("Invalid input. Enter 1 or 2 only."); //error checking for num range
                            }
                    if (userChoice1 == 1){ // search
                        System.out.print("Search by: \n1. state code\n2. state name\n3. county code\n4. county name\n");
                     while(!exit_second){
                      try{
                        System.out.print("Enter your choice (1-4): ");
                        int userSearch_Option = input.nextInt();
                            if (userSearch_Option <= 0 | userSearch_Option >= 5){ // error checking
                                throw new Exception("Invalid input. Enter 1-4 only.");
                            }
                            if (userSearch_Option == 1){
                                System.out.print("Search by state code. Enter a state code: ");
                                int stateCode = input.nextInt();
                                userSearch(fromFile, stateCode, userSearch_Option); //method search user's infomation from the fromFile
                                break;
                            }
                             if (userSearch_Option == 2){
                               System.out.print("Search by state name. Enter a state name: ");
                               input.nextLine();
                               String stateName = input.nextLine();
                               userSearch(fromFile, stateName, userSearch_Option); //method search user's infomation from the fromFile
                               break;
                            }
                            if (userSearch_Option == 3){
                                System.out.print("Search by county code. Enter a county code: ");
                                int countyCode = input.nextInt();
                                userSearch(fromFile, countyCode, userSearch_Option); //method search user's infomation from the fromFile
                                break;
                            }
                            if (userSearch_Option == 4){
                                System.out.print("Search by county name. Enter a county name: ");
                                input.nextLine();
                                String countyName = input.nextLine();
                                userSearch(fromFile, countyName, userSearch_Option); //method search user's infomation from the fromFile
                                break;
                            }
                       }catch (Exception ex1){
                       System.out.println("Invalid input. Enter 1-4 only.");
                       }
                       input.nextLine();
                      }
                      break;
                    } 
                   else if (userChoice1 == 2){//user pick sorting
                        System.out.print("1. State Code\n2. County Code\n3. State Name\n4. County Name\n5. Confirmed Count (1992-1996)\n6. Confirmed Count (1997-2001)\n7. Confirmed Count (2002-2006)\n8. Confirmed Count (2007-2011)\n");
                     outerloop: // breaking out of all loop when program complete
                      while(!exit_second){
                       try{
                            System.out.print("Enter the primary sort column (1-8): ");
                            int primary_sort = input.nextInt();
                           if (primary_sort <= 0 | primary_sort >= 9){
                                throw new Exception("Invalid input. Enter 1-8 only."); //error checking
                              }
                            while(!exit_third){
                             try{
                                   System.out.print("Enter the secondary sort column (1-8): ");
                                   int secondary_sort = input.nextInt();
                                   if (secondary_sort <= 0 | secondary_sort >= 9){
                                       throw new Exception("Invalid input. Enter 1-8 only.");
                                   }
                                   try{
                                        if (primary_sort == secondary_sort){
                                               throw new Exception("Primary and secondary sort column is the same. Please retry.");
                                              }
                                    while(!exit_fourth) {
                                      try{  
                                        System.out.print("Sort primary column in (1)ascending or (2)descending order. Enter 1 or 2:  ");
                                        int primary_order = input.nextInt();
                                        if (primary_order <= 0 | primary_order >= 3){
                                             throw new Exception("Invalid input. Enter 1 or 2 only.");
                                           }
                                         while(!exit_fifth){
                                             try{
                                                System.out.print("Sort secondary column in (1)ascending or (2)descending order:  Enter 1 or 2:  ");
                                                int secondary_order = input.nextInt(); 
                                              if (secondary_order <= 0 | secondary_order >= 3){
                                                 throw new Exception("Invalid input. Enter 1 or 2 only.");
                                              }
                                                  userSort(fromFile, primary_sort, secondary_sort, primary_order, secondary_order); // sorting method passing user's choice
                                                  break outerloop; // breaking out of all loop when program complete
                                                  
                                             }catch(Exception ex5){
                                             System.out.println("Invalid input. Enter 1 or 2 only.");
                                             }
                                             input.nextLine();
                                            }
                                          }catch(Exception ex4){
                                            System.out.println("Invalid input. Enter 1 or 2 only.");
                                        }
                                        input.nextLine();
                                    }
                                }catch(Exception same){
                                    System.out.println(same.getMessage());
                                }
                              }catch(Exception ex3){
                                System.out.println("Invalid input. Enter 1-8 only.");
                              }
                              input.nextLine();
                          }
                         }catch(Exception ex2){
                         System.out.println("Invalid input. Enter 1-8 only."); 
                       }
                       input.nextLine();
                     }
                    break;
                    }
                    //
                    }catch(Exception ex2){
                    System.out.println("Invalid input. Enter 1 or 2 only.");
                  }
                  //
                input.nextLine();
            }
        } catch(FileNotFoundException fileEx) {
            System.out.println("This filename cannot be found. Exiting.");
        } catch (IOException e) {
            System.out.println("This filename cannot be found. Exiting.");
            e.printStackTrace();
        } finally {
            try {
                if (readBuffer != null) 
                {
                    readBuffer.close();
                }
            } catch (IOException readException) {
                System.out.println("Ran into an error reading the file");
                readException.printStackTrace();
            }
        }
      }
    
    
    
    // Utility which converts CSV to ArrayList using Split operation
    public static ArrayList<String> CSVtoArrayList(String CSVFileName) {
        
        //TO DO: ensure this arraylist can handle integers, not only strings
        ArrayList<String> arrlist = new ArrayList<String>();
        
        
        if (CSVFileName != null) {
            String[] splitData = CSVFileName.split("\\,", -1); //the -1 helps handle the null values
            
            for (int i = 0; i < splitData.length; i++) {
                //if it is null, replace it with a 0
                if (splitData[i].length() == 0) {
                    splitData[i] = "0";
                }
                //as long as it is not null and the length is not 0, trim the value and add it to the arraylist
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    arrlist.add(splitData[i].trim());
                }
            }
         }
     return arrlist;
    }
    //method to search user's statecode, county code, county name, cases, etc.
    public static <T extends Comparable<T>> void userSearch(ArrayList<FileData> fromFile, T userSearch, int userSearch_Option){
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        T init_value = userSearch;
        if (userSearch_Option == 1){
        for (FileData i: fromFile){ // i look through "fromFile"
            if (userSearch.compareTo((T)i.stateCode) == 0){ // check user's input is the same as in the file
                //sum up all nums in the case corresponding to user's choice
                count1 += i.Confirmed_Count_92_96; 
                count2 += i.Confirmed_Count_97_01; 
                count3 += i.Confirmed_Count_02_06; 
                count4 += i.Confirmed_Count_07_11; 
                init_value = (T)i.stateName; // display the corresponding state to user's num
            }
         }
         //print info
            System.out.println(userSearch+" is "+ init_value);
            System.out.println("Count 92-96: " +count1);
            System.out.println("Count 97-01: " +count2);
            System.out.println("Count 02-06: " +count3);
            System.out.println("Count 07-11: " +count4);
      }
      if (userSearch_Option == 2){
           for(FileData i: fromFile){  // i look through "fromFile"
                if(userSearch.compareTo((T)i.stateName) == 0){
                count1 += i.Confirmed_Count_92_96; 
                count2 += i.Confirmed_Count_97_01; 
                count3 += i.Confirmed_Count_02_06; 
                count4 += i.Confirmed_Count_07_11;                                    
                    
                }
            }            
            System.out.println("Count 92-96: " +count1);
            System.out.println("Count 97-01: " +count2);
            System.out.println("Count 02-06: " +count3);
            System.out.println("Count 07-11: " +count4);
        }
        if (userSearch_Option == 3){
           for(FileData i: fromFile){  // i look through "fromFile"
               if(userSearch.compareTo((T)i.countyCode) == 0){
                count1 += i.Confirmed_Count_92_96; 
                count2 += i.Confirmed_Count_97_01; 
                count3 += i.Confirmed_Count_02_06; 
                count4 += i.Confirmed_Count_07_11;                                    
                init_value =(T)i.countyName;
                }
            }  
            System.out.println(userSearch+" is "+init_value);
            System.out.println("Count 92-96: " +count1);
            System.out.println("Count 97-01: " +count2);
            System.out.println("Count 02-06: " +count3);
            System.out.println("Count 07-11: " +count4);
        }
       if (userSearch_Option == 4){
           for(FileData i: fromFile){  // i look through "fromFile"
                if(userSearch.compareTo((T)i.countyName) == 0){
                    count1 += i.Confirmed_Count_92_96; 
                    count2 += i.Confirmed_Count_97_01; 
                    count3 += i.Confirmed_Count_02_06; 
                    count4 += i.Confirmed_Count_07_11;                                    
                    
                }
            }            
            System.out.println("Count 92-96: " +count1);
            System.out.println("Count 97-01: " +count2);
            System.out.println("Count 02-06: " +count3);
            System.out.println("Count 07-11: " +count4);
        }
    
       
      }
      //method for sorting; taking in user info and operate sort by ascending and descending order for all possible user's combination
      public static void userSort(ArrayList<FileData> fromFile, int primary_sort, int secondary_sort, int primary_order, int secondary_order)
      {
          
          // user wants to sort by primary = state code and secondary = county code
          if(primary_sort == 1 && secondary_sort == 2) 
          {
              if(primary_order == 1 && secondary_order == 1){// user wants both primary and secondary in ascending order
                    Collections.sort(fromFile, new Sort_State_Code());
                    Collections.sort(fromFile,new Sort_County_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo()); // print the sorted information by state and county code
                    }
                }
                else if(primary_order == 2 && secondary_order == 2){ // user wants both primary and secondary in decending order
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());               
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){// primary is ascending
                    Collections.sort(fromFile, new Sort_State_Code());
                    Collections.sort(fromFile,new Sort_County_Code().reversed());                 
                    for(int i=0; i<fromFile.size(); i++){
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){//primary is descending
                    Collections.sort(fromFile, new Sort_State_Code().reversed()); 
                    Collections.sort(fromFile,new Sort_County_Code());                               
                    for(int i=0; i<fromFile.size(); i++){
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            // user wants to sort by primary = county code and secondary = state code
            if(primary_sort == 2 && secondary_sort == 1){
                if(primary_order == 1 && secondary_order == 1){
                    //primary and seconary is ascending
                    Collections.sort(fromFile, new Sort_State_Code());
                    Collections.sort(fromFile,new Sort_County_Code());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order == 2 && secondary_order == 2){
                    //both descending
                    Collections.sort(fromFile, new Sort_State_Code().reversed()); 
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                                                           
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){//primary is ascending
                    Collections.sort(fromFile, new Sort_State_Code().reversed()); 
                    Collections.sort(fromFile,new Sort_County_Code()); // primary sort
                                     
                    for(int i=0; i<fromFile.size(); i++){
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){//primary is descending
                    Collections.sort(fromFile, new Sort_State_Code());
                    Collections.sort(fromFile,new Sort_County_Code().reversed()); // primary sort
                    for(int i=0; i<fromFile.size(); i++){
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
             if(primary_sort==1&&secondary_sort==3){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    Collections.sort(fromFile,new Sort_State_Name());
                    Collections.sort(fromFile, new Sort_State_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());                                        
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    Collections.sort(fromFile, new Sort_State_Code());                 
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo()); // print the sorted information by state and county code
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Name());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo()); // print the sorted information by state and county code
                    }        
                }           
            }
                                    
            if(primary_sort==3&&secondary_sort==1){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_State_Code());
                    Collections.sort(fromFile,new Sort_State_Name());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile, new Sort_State_Code().reversed());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile,new Sort_State_Code().reversed());
                    Collections.sort(fromFile, new Sort_State_Name());                 
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo()); // print the sorted information by state and county code
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Code());
                    Collections.sort(fromFile, new Sort_State_Name().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            
            if(primary_sort==1&&secondary_sort==4){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    Collections.sort(fromFile, new Sort_County_Name());
                    Collections.sort(fromFile,new Sort_State_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    Collections.sort(fromFile,new Sort_State_Code().reversed());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile,new Sort_County_Name().reversed());
                    Collections.sort(fromFile, new Sort_State_Code());                 
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Name());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            
            if(primary_sort==4&&secondary_sort==1){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    Collections.sort(fromFile, new Sort_State_Code());
                    Collections.sort(fromFile,new Sort_County_Name());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    
                    Collections.sort(fromFile, new Sort_State_Code().reversed());
                    Collections.sort(fromFile,new Sort_County_Name().reversed());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile,new Sort_State_Code().reversed());
                    Collections.sort(fromFile, new Sort_County_Name());                 
                    for(int i=0; i<fromFile.size(); i++){
                        System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Code());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }                                    
            if(primary_sort==1&&secondary_sort==5){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    Collections.sort(fromFile, new SortFirstConfirmCount());
                    Collections.sort(fromFile,new Sort_State_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_State_Code());
                                     
                    for(int i=0; i<fromFile.size(); i++){
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
                         System.out.println(fromFile.get(i).printInfo());
                    }       
                }           
            }
                                                            
            if(primary_sort==5&&secondary_sort==1){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    Collections.sort(fromFile,new Sort_State_Code());
                    Collections.sort(fromFile, new SortFirstConfirmCount());
                     for(int i=0; i<fromFile.size(); i++){
                         System.out.println(fromFile.get(i).printInfo());
                    } 
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile, new Sort_State_Code().reversed());
                    Collections.sort(fromFile,new SortFirstConfirmCount().reversed());
                     for(int i=0; i<fromFile.size(); i++){
                         System.out.println(fromFile.get(i).printInfo());
                    } 
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile,new Sort_State_Code().reversed());
                    Collections.sort(fromFile, new SortFirstConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo()); // print the sorted information 
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Code());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo()); // print the sorted information 
                    }       
                }           
            }
            
                                                            
            if(primary_sort==1&&secondary_sort==6){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortSecondConfirmCount());
                    Collections.sort(fromFile,new Sort_State_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo()); 
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo()); 
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_State_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo()); // print the sorted information by state and county code
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo()); // print the sorted information by state and county code
                    }       
                }           
            }
                                                                        
            if(primary_sort==6&&secondary_sort==1){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    Collections.sort(fromFile,new Sort_State_Code());
                    Collections.sort(fromFile, new SortSecondConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile, new Sort_State_Code().reversed());
                    Collections.sort(fromFile,new SortSecondConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile,new Sort_State_Code().reversed());
                    Collections.sort(fromFile, new SortSecondConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Code());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                            
            if(primary_sort==1&&secondary_sort==7){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortThirdConfirmCount());
                    Collections.sort(fromFile,new Sort_State_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_State_Code());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                                                    
            if(primary_sort==7&&secondary_sort==1){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    Collections.sort(fromFile,new Sort_State_Code());
                    Collections.sort(fromFile, new SortThirdConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile, new Sort_State_Code().reversed());
                    Collections.sort(fromFile,new SortThirdConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile,new Sort_State_Code().reversed());
                    Collections.sort(fromFile, new SortThirdConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Code());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                                        
            if(primary_sort==1&&secondary_sort==8){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortFourthConfirmCount());
                    Collections.sort(fromFile,new Sort_State_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_State_Code());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    Collections.sort(fromFile, new Sort_State_Code().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            
                                                                                    
            if(primary_sort==8&&secondary_sort==1){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    Collections.sort(fromFile,new Sort_State_Code());
                    Collections.sort(fromFile, new SortFourthConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile, new Sort_State_Code().reversed());
                    Collections.sort(fromFile,new SortFourthConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile,new Sort_State_Code().reversed());
                    Collections.sort(fromFile, new SortFourthConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Code());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                                        
            if(primary_sort==2&&secondary_sort==3){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_State_Name());
                    Collections.sort(fromFile,new Sort_County_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    Collections.sort(fromFile, new Sort_County_Code().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_State_Name().reversed());
                    Collections.sort(fromFile,new Sort_County_Code());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Name());
                    Collections.sort(fromFile, new Sort_County_Code().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                                                    
            if(primary_sort==3&&secondary_sort==2){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Code());
                    Collections.sort(fromFile,new Sort_State_Name());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    Collections.sort(fromFile, new Sort_State_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Code().reversed());
                    Collections.sort(fromFile,new Sort_State_Name());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Code());
                    Collections.sort(fromFile, new Sort_State_Name().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                                                    
            if(primary_sort==2&&secondary_sort==4){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Name());
                    Collections.sort(fromFile,new Sort_County_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Name().reversed());
                    Collections.sort(fromFile, new Sort_County_Code().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    Collections.sort(fromFile,new Sort_County_Code());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Name());
                    Collections.sort(fromFile, new Sort_County_Code().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                                                                
            if(primary_sort==4&&secondary_sort==2){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Code());
                    Collections.sort(fromFile,new Sort_County_Name());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Code().reversed());
                    Collections.sort(fromFile,new Sort_County_Name());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Code());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            
            if(primary_sort==2&&secondary_sort==5){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    Collections.sort(fromFile, new Sort_County_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    
                    Collections.sort(fromFile,new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_County_Code());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    
                    Collections.sort(fromFile, new SortFirstConfirmCount());
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                                                                
            if(primary_sort==5&&secondary_sort==2){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Code());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Code().reversed());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Code());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }                                                                                    
                        
            if(primary_sort==2&&secondary_sort==6){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    Collections.sort(fromFile, new Sort_County_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    
                    Collections.sort(fromFile,new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_County_Code());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    
                    Collections.sort(fromFile, new SortSecondConfirmCount());
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }                                                                                                
            if(primary_sort==6&&secondary_sort==2){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Code());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Code().reversed());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Code());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            } 
                        
            if(primary_sort==2&&secondary_sort==7){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    Collections.sort(fromFile, new Sort_County_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    
                    Collections.sort(fromFile,new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_County_Code());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    
                    Collections.sort(fromFile, new SortThirdConfirmCount());
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }                                                                                                
            if(primary_sort==7&&secondary_sort==2){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Code());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Code().reversed());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Code());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                        
            if(primary_sort==2&&secondary_sort==8){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    Collections.sort(fromFile, new Sort_County_Code());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    
                    Collections.sort(fromFile,new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_County_Code());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    
                    Collections.sort(fromFile, new SortFourthConfirmCount());
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }                                                                                                
            if(primary_sort==8&&secondary_sort==2){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Code());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Code().reversed());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Code().reversed());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Code());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());                                
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            } 
                        
            if(primary_sort==3&&secondary_sort==4){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    
                    Collections.sort(fromFile,new Sort_County_Name());
                    Collections.sort(fromFile, new Sort_State_Name());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    
                    Collections.sort(fromFile,new Sort_County_Name().reversed());
                    Collections.sort(fromFile, new Sort_State_Name());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    
                    Collections.sort(fromFile, new Sort_County_Name());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==4&&secondary_sort==3){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_State_Name());
                    Collections.sort(fromFile,new Sort_County_Name());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_State_Name().reversed());
                    Collections.sort(fromFile,new Sort_County_Name());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Name());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                    
            if(primary_sort==3&&secondary_sort==5){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    Collections.sort(fromFile, new Sort_State_Name());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    
                    Collections.sort(fromFile,new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_State_Name());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    
                    Collections.sort(fromFile, new SortFirstConfirmCount());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==5&&secondary_sort==3){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_State_Name());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_State_Name().reversed());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Name());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                    
            if(primary_sort==3&&secondary_sort==6){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    Collections.sort(fromFile, new Sort_State_Name());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    
                    Collections.sort(fromFile,new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_State_Name());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile, new SortSecondConfirmCount());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==6&&secondary_sort==3){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_State_Name());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_State_Name().reversed());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Name());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                    
            if(primary_sort==3&&secondary_sort==7){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    Collections.sort(fromFile, new Sort_State_Name());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    
                    Collections.sort(fromFile,new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_State_Name());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    
                    Collections.sort(fromFile, new SortThirdConfirmCount());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==7&&secondary_sort==3){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_State_Name());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_State_Name().reversed());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Name());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                    
            if(primary_sort==3&&secondary_sort==8){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    Collections.sort(fromFile, new Sort_State_Name());
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    
                    Collections.sort(fromFile,new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_State_Name());
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    
                    Collections.sort(fromFile, new SortFourthConfirmCount());
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==8&&secondary_sort==3){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_State_Name());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_State_Name().reversed());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_State_Name().reversed());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_State_Name());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            
            if(primary_sort==4&&secondary_sort==5){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortFirstConfirmCount());
                    Collections.sort(fromFile,new Sort_County_Name());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_County_Name());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                        
            if(primary_sort==5&&secondary_sort==4){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Name());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Name().reversed());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Name());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                        
            if(primary_sort==4&&secondary_sort==6){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortSecondConfirmCount());
                    Collections.sort(fromFile,new Sort_County_Name());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_County_Name());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                        
            if(primary_sort==6&&secondary_sort==4){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Name());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Name().reversed());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Name());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                        
            if(primary_sort==4&&secondary_sort==7){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortThirdConfirmCount());
                    Collections.sort(fromFile,new Sort_County_Name());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_County_Name());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                        
            if(primary_sort==7&&secondary_sort==4){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Name());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Name().reversed());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Name());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                        
            if(primary_sort==4&&secondary_sort==8){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortFourthConfirmCount());
                    Collections.sort(fromFile,new Sort_County_Name());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile,new Sort_County_Name());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                        
            if(primary_sort==8&&secondary_sort==4){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new Sort_County_Name());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new Sort_County_Name().reversed());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new Sort_County_Name().reversed());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new Sort_County_Name());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                    
            if(primary_sort==5&&secondary_sort==6){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortSecondConfirmCount());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                
            if(primary_sort==6&&secondary_sort==5){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortFirstConfirmCount());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                
            if(primary_sort==5&&secondary_sort==7){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortThirdConfirmCount());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                
            if(primary_sort==7&&secondary_sort==5){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortFirstConfirmCount());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                
            if(primary_sort==5&&secondary_sort==8){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortFourthConfirmCount());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
                                                
            if(primary_sort==8&&secondary_sort==5){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortFirstConfirmCount());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortFirstConfirmCount().reversed());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortFirstConfirmCount());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==6&&secondary_sort==7){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortThirdConfirmCount());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==7&&secondary_sort==6){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortSecondConfirmCount());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==6&&secondary_sort==8){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortFourthConfirmCount());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==8&&secondary_sort==6){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortSecondConfirmCount());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortSecondConfirmCount().reversed());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortSecondConfirmCount());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==7&&secondary_sort==8){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortFourthConfirmCount());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order==2){
                    //primary is descending
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
            if(primary_sort==8&&secondary_sort==7){
                if(primary_order==1&&secondary_order==1){
                    //primary and second is ascending
                    
                    Collections.sort(fromFile, new SortThirdConfirmCount());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                
                else if(primary_order==2&&secondary_order==2){
                    //both descending
                    Collections.sort(fromFile,new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    
                    for(int i=0; i<fromFile.size(); i++){            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
              
                else if(primary_order==1){
                    //secondary is descending
                    Collections.sort(fromFile, new SortThirdConfirmCount().reversed());
                    Collections.sort(fromFile,new SortFourthConfirmCount());
                    
                                     
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }
                }
                else if(primary_order == 2){
                    //primary is descending
                    Collections.sort(fromFile,new SortThirdConfirmCount());
                    Collections.sort(fromFile, new SortFourthConfirmCount().reversed());
                    
                    for(int i=0; i<fromFile.size(); i++){
            
                         System.out.println(fromFile.get(i).printInfo());
                    }         
                }           
            }
         }
       }
 
 