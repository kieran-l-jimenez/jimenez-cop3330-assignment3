package ex42;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Kieran Jimenez
 */
/*
    Exercise 42 - Parsing a Data File
Sometimes data comes in as a structured format that you have to break down and turn into records so you can process them.
CSV, or comma-separated values, is a common standard for doing this.

Construct a program that reads in the following data file:

Ling,Mai,55900
Johnson,Jim,56500
Jones,Aaron,46000
Jones,Chris,34500
Swift,Geoffrey,14200
Xiong,Fong,65000
Zarnecki,Sabrina,51500

Process the records and display the results formatted as a table, evenly spaced, as shown in the example output.

    Example Output
Last      First     Salary
--------------------------
Ling      Mai       55900
Johnson   Jim       56500
Jones     Aaron     46000
Jones     Chris     34500
Swift     Geoffrey  14200
Xiong     Fong      65000
Zarnecki  Sabrina   51500

    Constraints
Write your own code to parse the data. Don't use a CSV parser.
Use spaces to align the columns.
Make each column one space longer than the longest value in the column.
    Challenges
-Format the salary as currency with dollar signs and commas.
-Sort the results by salary from highest to lowest.
-Rework your program to use a CSV parsing library and compare the results.
 */
public class App {
    public static void main (String[] args)
    {
        //declare new App
        App myApp = new App();
        // declare new PersonArray
        PersonArray myPArray = new PersonArray();
        // read in data
        myPArray.EmployeeRecord = myPArray.readCSV("src/main/java/ex42/EmployeeRecordCSV.txt");
        // find number of employees
        myPArray.numEmployees = myPArray.EmployeeRecord.length;
        // find longest string in each column
        myPArray.longestFName = myPArray.findLongestString(myPArray.EmployeeRecord, "fname", myPArray.numEmployees);
        myPArray.longestLName = myPArray.findLongestString(myPArray.EmployeeRecord, "lname", myPArray.numEmployees);
        myPArray.longestSalary = myPArray.findLongestString(myPArray.EmployeeRecord, "salary", myPArray.numEmployees);
        // change strings so they all have same length in their column
        for(int i = 0; i < myPArray.numEmployees; i++)
        {
            myPArray.EmployeeRecord[i].fName = myPArray.formatProperLength(myPArray.EmployeeRecord[i].fName, myPArray.longestFName + 1);
            myPArray.EmployeeRecord[i].lName = myPArray.formatProperLength(myPArray.EmployeeRecord[i].lName, myPArray.longestLName + 1);
            myPArray.EmployeeRecord[i].salary = myPArray.formatProperLength(myPArray.EmployeeRecord[i].salary, myPArray.longestSalary + 1);
        }
        // find total string length
        myPArray.totalLength = myPArray.longestFName + myPArray.longestLName + myPArray.longestSalary + 3;
        // make file
            // print to file formatProperLength for "Last", "First", and "Salary"
            // loop (print to file "-") * total string length
            // print Person[] entries until done
        myApp.makeFile(myPArray);
    }

    void makeFile(PersonArray myArray)
    {
        try {
            File output = new File("src/main/java/ex42/output.txt");

            if(output.createNewFile())
            {
                FileWriter myWriter = new FileWriter(output);
                myWriter.write(String.format("%s", myArray.formatProperLength("Last", myArray.longestFName + 1)));
                myWriter.write(String.format("%s", myArray.formatProperLength("First", myArray.longestLName + 1)));
                myWriter.write(String.format("%s", myArray.formatProperLength("Salary", myArray.longestSalary + 1)));
                myWriter.write("\n");
                for(int i = 0; i < myArray.totalLength; i++)
                {
                    myWriter.write("-");
                }
                myWriter.write("\n");

                for(int i = 0; i < myArray.numEmployees; i++)
                {
                    myWriter.append(String.format("%s%s%s\n", myArray.EmployeeRecord[i].lName, myArray.EmployeeRecord[i].fName, myArray.EmployeeRecord[i].salary));
                }
                myWriter.close();
                System.out.println("Created and Filled \"output.txt\".");
            }
            else
            {
                System.out.println("\"output.txt\" already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error making file.");
            e.printStackTrace();
        }
    }
}
