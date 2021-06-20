package ex41;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Kieran Jimenez
 */
/*
    Exercise 41 - Name Sorter
Alphabetizing the contents of a file, or sorting its contents, is a great way to get comfortable manipulating a file in
your program.

Create a program that reads in the following list of names from a file called `names.txt` and sorts the list alphabetically:

Ling, Mai
Johnson, Jim
Zarnecki, Sabrina
Jones, Chris
Jones, Aaron
Swift, Geoffrey
Xiong, Fong

Then print the sorted list to a file called `names_sorted.txt` that looks like the following example output.

    Example Output
Total of 7 names
-----------------
Ling, Mai
Johnson, Jim
Jones, Aaron
Jones, Chris
Swift, Geoffrey
Xiong, Fong
Zarnecki, Sabrina

    Constraint
Don't hard-code the number of names.
    Challenges
-Implement this program by reading in the names from the user, one at a time, and printing out the sorted results to a file.
-Use the program to sort data from a large data set and see how well it performs.
-Implement this program in a functional programming language and compare the programs.
 */
public class App {

    public static void main (String[] args)
    {
        NameList myNameList = new NameList();
        App myApp = new App();
        //read in file
        myNameList.names = myNameList.readNames("src/main/java/ex41/names.txt");
        //find number of members
        myNameList.numMembers = myNameList.names.size();
        //sort it
        myNameList.names = myNameList.alphabetize(myNameList.names);
        //create file and write
        myApp.makeFile(myNameList);
    }

    public void makeFile(NameList myNList)
    {
        try {
            File output = new File("src/main/java/ex41/names_sorted.txt");

            if(output.createNewFile())
            {
                FileWriter myWriter = new FileWriter(output);
                myWriter.write(String.format("Total of %d names\n-----------------\n", myNList.numMembers));
                for(int i = 0; i < myNList.numMembers; i++)
                {
                    myWriter.append(String.format("%s\n", myNList.names.get(i)));
                }
                myWriter.close();
                System.out.println("Created and Filled \"names_sorted.txt\".");
            }
            else
            {
                System.out.println("\"names_sorted.txt\" already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error making file.");
            e.printStackTrace();
        }
    }
}
