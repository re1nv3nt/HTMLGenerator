/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alex Paczynski
 */
public class HTMLStyle {
    private static FileWriter fwriter;
    private static PrintWriter outputFile;
    
    
    public static String addTextStyles(String color, String alignment) throws IOException{
        
        String textColorStyle = "style=\"color:" + color + "; " 
                + "text-align: " + alignment + ";\"";
        
        return textColorStyle;
    }
    
    public static String addPhotoStyle(int size) throws IOException{
        size = 100 / size;
        
        String photoStyle = "style=\"width: " + size + "%;\"";
        
        return photoStyle;
    }
    
    public static void clearExternalStyles() throws IOException{
        fwriter = new FileWriter("Styles.css");
        outputFile = new PrintWriter(fwriter);
        outputFile.println();
    }
    
    public static void addBackgroundPhotoStyle(String backgroundImage) throws FileNotFoundException, IOException{
        fwriter = new FileWriter("Styles.css", true);
        outputFile = new PrintWriter(fwriter);

        outputFile.print("body\n" +
                        "{\n" +
                        "	background-image: url(\"" + backgroundImage + ".jpg\");\n" +
                        "}\n");
        
        outputFile.close();
        
    }
    
    public static void addBackgroundColorStyle(String backgroundColor) throws FileNotFoundException, IOException{
        fwriter = new FileWriter("Styles.css", true);
        outputFile = new PrintWriter(fwriter);

        outputFile.print("body\n" +
                        "{\n" +
                        "	background-color: " + backgroundColor + ";\n" +
                        "}\n");
        
        outputFile.close();
        
    }
    
}
