package ex41;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Kieran Jimenez
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NameList {
    ArrayList<String> names;
    int numMembers;

    ArrayList<String> readNames(String filePath)
    {
        ArrayList myStrings = new ArrayList();

        try {
            //ex41/names.txt
            File myFile = new File(filePath);
            Scanner myReader = new Scanner(myFile);

            int i;
            for(i = 0; myReader.hasNextLine(); i++)
            {
                if(i > myStrings.size())
                    myStrings = (ArrayList) Arrays.asList(Arrays.copyOf(myStrings.toArray(), i * 2));
                myStrings.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        return myStrings;
    }

    ArrayList<String> alphabetize(ArrayList<String> nameArray)
    {


        nameArray.sort(String.CASE_INSENSITIVE_ORDER);

        return nameArray;
    }
}
