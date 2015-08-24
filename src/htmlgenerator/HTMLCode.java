/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlgenerator;


import java.io.File;
import java.awt.Desktop;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author Alex Paczynski
 */
public class HTMLCode {
    private static FileWriter fwriter;
    private static PrintWriter outputFile;
    private File webPage;
    
    //
    public HTMLCode(){
        webPage = new File("Content.htm");
    }
    
    public void openPage() throws IOException{
        Desktop desktop = Desktop.getDesktop();
        desktop.open(webPage);
    }  
    
    public static void htmlSetup() throws IOException{
        fwriter = new FileWriter("Content.htm");
        outputFile = new PrintWriter(fwriter);
        
        //[REQ#11]Writes HTML code to a .htm file
        outputFile.print("<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "   <head>\n" +
                            "       <title>default</title>\n" +
                            "       <link href=\"Styles.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n" +
                            "       <style type=\"text/css\">\n" +
                            "           body\n" +
                            "           {\n" +
                            "               font-family: Calibri, sans-serif; \n" +
                            "               font-size: 400%;\n" +
                            "           }\n" +
                            "           p\n" +
                            "           {\n" +
                            "               font-size: 50%;\n" +
                            "               padding: 0 5% 0 5%;\n" +
                            "           }\n" +
                            "       </style>\n" +
                            "   </head>\n" +
                            "   <body>\n");
        
        outputFile.close();
    }
    
    public static void pageTitle(String titleInput, int headingSize, String style) throws IOException{
        
        String headingNum = Integer.toString(headingSize);
        
        fwriter = new FileWriter("Content.htm", true);
        outputFile = new PrintWriter(fwriter);
        
        outputFile.println("      <h" + headingNum + " " + style + ">" + titleInput + "</h" + headingNum + ">");
    
        outputFile.close();
    }
    
    public static void bodyContent(String bodyInput, String style) throws IOException{
        fwriter = new FileWriter("Content.htm", true);
        outputFile = new PrintWriter(fwriter);
        
        outputFile.println("            <p " + style + ">" + bodyInput + "</h>");
        
        outputFile.close();
    }
    
    public static void addPicture(String photo, String style, String alignment) throws IOException{
        fwriter = new FileWriter("Content.htm", true);
        outputFile = new PrintWriter(fwriter);
        
        if(photo.equals("random")){
        //[REQ#10]Creates a String array to store the names of available photos
        String[] photos = {"islands", "mountain", "city"};
        
        //[REQ#4]Creates a Random object and uses the nextInt() method
        Random rand = new Random();
        int i = rand.nextInt(3);
        
        photo = photos[i];
        
        }
                
        outputFile.println("            <div align=\"" + alignment +"\"><img " + style + " src=\"" + photo + ".jpg" + "\" />");
        
        outputFile.close();
    }
    
    public static void finalizePage() throws IOException{
        fwriter = new FileWriter("Content.htm", true);
        outputFile = new PrintWriter(fwriter);

        outputFile.print("   </body>\n" +
                         "</html>");
        
        outputFile.close();
             
    }
    
}
