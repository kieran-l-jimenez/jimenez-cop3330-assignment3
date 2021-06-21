package ex42;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Kieran Jimenez
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonArray {
    Person[] EmployeeRecord;
    int numEmployees;
    int longestFName;
    int longestLName;
    int longestSalary;
    int totalLength;

    int findLongestString(Person[] temp, String choice, int numEmployees)
    {
        int maxlen = 0;

        switch (choice) {
            case "fname" -> {
                maxlen = temp[0].fName.length();
                for (int i = 1; i < numEmployees; i++)
                    if (maxlen < temp[i].fName.length())
                        maxlen = temp[i].fName.length();
            }
            case "lname" -> {
                maxlen = temp[0].lName.length();
                for (int i = 1; i < numEmployees; i++)
                    if (maxlen < temp[i].lName.length())
                        maxlen = temp[i].lName.length();
            }
            case "salary" -> {
                maxlen = temp[0].salary.length();
                for (int i = 1; i < numEmployees; i++)
                    if (maxlen < temp[i].salary.length())
                        maxlen = temp[i].salary.length();
            }
        }

        return maxlen;
    }

    String formatProperLength(String temp, int newLength)
    {
        int difference = temp.length() - newLength;

        temp = temp + String.format("%"+difference+"s", " ");

        return temp;
    }

    Person[] readCSV(String filePath)
    {
        ArrayList<String> fnames = new ArrayList();
        ArrayList<String> lnames = new ArrayList();
        ArrayList<String> salary = new ArrayList();

        try {
            File myFile = new File(filePath);
            Scanner myReader = new Scanner(myFile);

            myReader.useDelimiter(",|\\n");
            myReader.tokens();

            while(myReader.hasNext())
            {
                //myReader.tokens();
                lnames.add(myReader.next());
                fnames.add(myReader.next());
                salary.add(myReader.next());
                if(myReader.hasNextLine())
                    myReader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        int numPeople = fnames.size();

        Person[] ret = new Person[numPeople];

        for(int i = 0; i < numPeople; i++)
        {
            ret[i] = new Person();
            ret[i].fName = fnames.get(i);
            ret[i].lName = lnames.get(i);
            ret[i].salary = salary.get(i);
        }

        return ret;
    }
}
