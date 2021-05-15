/**
 * CS 200 Homework Assignment 4
 * @author: Touchsada Jan On
 * @Due: 29 November 2020
 * @Turned in: 22 November 2020
 */
import java.util.*;
import java.lang.*;
import java.io.*;
public class FileData 
{
    // instance variables defines as onject because of using generics for searching and compare for sorting
    public Integer stateCode;
    public Integer countyCode;
    public String stateName;
    public String countyName;
    public Integer Confirmed_Count_92_96;
    public Integer Confirmed_Count_97_01;
    public Integer Confirmed_Count_02_06;
    public Integer Confirmed_Count_07_11;
    
    
    
    //constructor to get corresponding infomation
    public FileData(Integer stateCode, Integer countyCode, String stateName, String countyName, Integer Confirmed_Count_92_96, Integer Confirmed_Count_97_01, 
    Integer Confirmed_Count_02_06, Integer Confirmed_Count_07_11)
    {
        this.stateCode = stateCode;
        this.countyCode = countyCode;
        this.stateName = stateName;
        this.countyName = countyName;
        this.Confirmed_Count_92_96 = Confirmed_Count_92_96;
        this.Confirmed_Count_97_01 = Confirmed_Count_97_01;
        this.Confirmed_Count_02_06 = Confirmed_Count_02_06;
        this.Confirmed_Count_07_11 = Confirmed_Count_07_11;
        
    }
    //print sorted info
    public String printInfo(){
        return String.format("%-5d %-5d %20s %35s %10d %8d %8d %8d", stateCode, countyCode, stateName, countyName, Confirmed_Count_92_96, Confirmed_Count_97_01, Confirmed_Count_02_06, Confirmed_Count_07_11);
    }

}

// classes for corresponding variables to compare with each other to get the sorted information in ascending and decending order
class Sort_State_Code implements Comparator<FileData>
{
    public int compare(FileData first, FileData second) //compare the two variable
    {
        return first.stateCode - second.stateCode;
    }
    public int reversed(FileData first, FileData second) //compare the two variable
    {
        return second.stateCode - first.stateCode;
    }
}
class Sort_County_Code implements Comparator<FileData>
{
    public int compare(FileData first, FileData second) //compare the two variable
    {
        return first.countyCode - second.countyCode;
    }
    public int reversed(FileData first, FileData second) //compare the two variable
    {
        return second.countyCode - first.countyCode;
    }
}
class Sort_State_Name implements Comparator<FileData>
{
    public int compare(FileData first, FileData second) //compare the two variable
    {
        return first.stateName.compareTo(second.stateName);
    }
    public int reversed(FileData first, FileData second) //compare the two variable
    {
        return second.stateName.compareTo(first.stateName);
    }
    
}
class Sort_County_Name implements Comparator<FileData>
{ 
    public int compare(FileData first, FileData second)  //compare the two variable
    {
        return first.countyName.compareTo(second.countyName);
    } 
    public int reversed(FileData first, FileData second) //compare the two variable
    {
        return second.countyName.compareTo(first.countyName);
    }
    
}
class SortFirstConfirmCount implements Comparator<FileData>
{
    public int compare(FileData first, FileData second)   //compare the two variable
    {
        return first.Confirmed_Count_92_96 - second.Confirmed_Count_92_96;
    }
    public int reversed(FileData first, FileData second)   //compare the two variable
    {
        return second.Confirmed_Count_92_96 - first.Confirmed_Count_92_96;
    }
}
class SortSecondConfirmCount implements Comparator<FileData>
{
    public int compare(FileData first, FileData second)   //compare the two variable
    {
        return first.Confirmed_Count_97_01 - second.Confirmed_Count_97_01;
    }
    public int reversed(FileData first, FileData second)  //compare the two variable
    {
        return second.Confirmed_Count_97_01 - first.Confirmed_Count_97_01;
    }
}
class SortThirdConfirmCount implements Comparator<FileData>
{
    public int compare(FileData first, FileData second)  //compare the two variable
    {
        return first.Confirmed_Count_02_06 - second.Confirmed_Count_02_06;
    }
    public int reversed(FileData first, FileData second)  //compare the two variable
    {
        return second.Confirmed_Count_02_06 - first.Confirmed_Count_02_06;
    }
}
class SortFourthConfirmCount implements Comparator<FileData>
{
    
    public int compare(FileData first, FileData second)   //compare the two variable
    {
        return first.Confirmed_Count_07_11 - second.Confirmed_Count_07_11;
    }
    public int reversed(FileData first, FileData second)  //compare the two variable
    {
        return second.Confirmed_Count_07_11 - first.Confirmed_Count_07_11;
    }
}
