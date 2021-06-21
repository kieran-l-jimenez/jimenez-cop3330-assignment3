package ex43;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class websiteInfo {
    String SiteName;
    String AuthorName;
    boolean JScriptFolder;
    boolean CSSFolder;

    websiteInfo promptInfo()
    {
        websiteInfo mySite = new websiteInfo();
        Scanner in = new Scanner(System.in);

        System.out.print("Site name: ");
        mySite.SiteName = in.nextLine();
        System.out.print("Author: ");
        mySite.AuthorName = in.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        mySite.JScriptFolder = in.nextLine().equalsIgnoreCase("y");
        System.out.print("Do you want a folder for CSS? ");
        mySite.CSSFolder = in.nextLine().equalsIgnoreCase("y");

        return mySite;
    }

    void generateWebsite(websiteInfo userWebsiteInfo)
    {

        try {
            File tempFolders = new File(String.format("src/main/java/ex43/%s", userWebsiteInfo.SiteName));
            if(tempFolders.mkdir())
                System.out.printf("Created ./%s\n", userWebsiteInfo.SiteName);

            tempFolders = new File(String.format("src/main/java/ex43/%s/index.html", userWebsiteInfo.SiteName));
            if(tempFolders.createNewFile())
            {
                FileWriter myWriter = new FileWriter(tempFolders);
                myWriter.write("<!DOCTYPE html>\n<html>\n<head>\n\t<title>");
                myWriter.write(userWebsiteInfo.SiteName);
                myWriter.write("</title>\n\t<meta name=\"author\" content=\"");
                myWriter.write(userWebsiteInfo.AuthorName);
                myWriter.write("\">\n</head>\n</html>");
                myWriter.close();
                System.out.printf("Created ./%s/index.html\n", userWebsiteInfo.SiteName);
            }

            if(userWebsiteInfo.JScriptFolder)
            {
                tempFolders = new File(String.format("src/main/java/ex43/%s/js", userWebsiteInfo.SiteName));
                if(tempFolders.mkdir())
                    System.out.printf("Created ./%s/js/\n", userWebsiteInfo.SiteName);
            }

            if(userWebsiteInfo.CSSFolder)
            {
                tempFolders = new File(String.format("src/main/java/ex43/%s/css", userWebsiteInfo.SiteName));
                if(tempFolders.mkdir())
                    System.out.printf("Created ./%s/css/\n", userWebsiteInfo.SiteName);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error making file.");
            e.printStackTrace();
        }
    }
}
