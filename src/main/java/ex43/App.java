package ex43;

import java.util.Scanner;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Kieran Jimenez
 */
/*
    Exercise 43 - Website Generator
Programming languages can create files and folders too.

Create a program that generates a website skeleton with the following specifications:
-Prompt for the name of the site.
-Prompt for the author of the site.
-Ask if the user wants a folder for JavaScript files.
-Ask if the user wants a folder for CSS files.
-Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.

    Example Output
Site name: awesomeco
Author: Max Power
Do you want a folder for JavaScript? y
Do you want a folder for CSS? y
Created ./awesomeco
Created ./awesomeco/index.html
Created ./awesomeco/js/
Created ./awesomeco/css/
    Challenges
-Implement this in a scripting language on Windows, OSX, and Linux.
-Implement this as a web application that provides the specified site as a zip file.
 */
public class App {
    public static void main (String[] args)
    {
        //prompt and fill info
        websiteInfo myWebsite = new websiteInfo();
        myWebsite = myWebsite.promptInfo();

        //call website generator
        myWebsite.generateWebsite(myWebsite);
    }
}
