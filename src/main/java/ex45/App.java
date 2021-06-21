package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Kieran Jimenez
 */
/*
    Exercise 45 - Word Finder
There will be times when you'll need to read in one file, modify it, and then write a modified version of that file to a
new file.

Given an input file, read the file and look for all occurrences of the word utilize. Replace each occurrence with use.
Write the modified file to a new file.

    Example Output
Given the input file of

One should never utilize the word "utilize" in writing. Use "use" instead.
    The program should generate

One should never use the word "use" in writing. Use "use" instead.
    Constraints
Prompt for the name of the output file.
Write the output to a new file.
    Challenges
-Modify the program to track the number of replacements and report that to the screen when the program finishes.
-Create a configuration file that maps “bad” words to “good” words and use this file instead of a hard-coded value.
-Modify the program so it can handle a folder of files instead of a single file.
 */
public class App {
    Scanner in = new Scanner(System.in);

    public static void main (String[] args)
    {
        App myApp = new App();
        //set targetWord
        word myWord = new word();
        myWord.determineTarget("utilize");
        //prompt for file name
        String targetFile = myApp.fileNamePrompt();
        //attempt to open file
        //keep reading until end of file
            //string append(replaceWord(token))
        String replacementText = myApp.replaceFile(targetFile, myWord);
        //write filled string to new file
        myApp.writeToFile(replacementText);
    }

    String fileNamePrompt(){
        System.out.print("File: ");
        return in.next();
    }

    String replaceFile(String fileName, word myWord){
        String filePath = "src/main/java/ex45/" + fileName;
        String ret = "";

        try {
            File myFile = new File(filePath);
            Scanner myReader = new Scanner(myFile);
            myReader.tokens();

            while(myReader.hasNext()) {
                ret = ret.concat(myWord.replaceWord(myReader.next()));
                if(myReader.hasNext())
                    ret = ret.concat(" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ret;
    }

    void writeToFile(String replacedText){
        try {
            File output = new File("src/main/java/ex45/output.txt");

            if(output.createNewFile())
            {
                FileWriter myWriter = new FileWriter(output);

                myWriter.write(replacedText);

                myWriter.close();
            }
            else
            {
                System.out.println("\"input.txt\" already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error making file.");
            e.printStackTrace();
        }
    }
}

