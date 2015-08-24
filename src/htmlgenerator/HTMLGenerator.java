/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlgenerator;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 *
 * @author Alex Paczynski
 */
public class HTMLGenerator {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        int userSelect = 0;

        System.out.println();
        
        //[REQ#1]Introduces the program and displays my name
        System.out.println("=======HTML Webpage Generator=======\n"
                         + "~~~~~~~~~By: Alex Paczynski~~~~~~~~~\n"
                         + "~~~~~~~======= v. 1.0 =======~~~~~~~\n");
        System.out.println("What would you like to do?");
        
        //[REQ#7]The first of many loops, used to validate user input
        do{
            System.out.println("--------------------------\n"
                             + "Enter a number (1-3):");
            System.out.println("1. Create my own webpage from scratch\n"
                             + "2. Convert a text file to an HTML page\n"
                             + "3. Exit the program\n");
            System.out.print("CHOICE: ");
            
            //[REQ#2]Accepts numeric input from the user and validates the input
            //[REQ#5]Also the first of many "if" statements
            if(!(keyboard.hasNextInt())){
                System.out.println("\nNot a valid choice.");
                keyboard.next();
                
            }else if(keyboard.hasNextInt()){
                userSelect = keyboard.nextInt();
                
                if(userSelect < 1 || userSelect > 3){
                    System.out.println("\nNot a valid choice.");
                }
            }
            
            //Uses my own "htmlSetup()" method to setup a new .htm file
            HTMLCode.htmlSetup();

        }while(!(userSelect == 1 || userSelect == 2 || userSelect == 3));
        
        
        if(userSelect == 1){
            
            HTMLStyle.clearExternalStyles();
                    
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                + "NEW WEBPAGE FROM SCRATCH\n"
                                + "~~~~~~~~~~~~~~~~~~~~~~~~");
            
            while(userSelect != 5){
                
                do{
                    System.out.println("\nMain Menu\n"
                                        + "---------\n"
                                        + "What would you like for your web page?\n"
                                        + "Enter a number (1-5):\n"
                                        + "1. Page Title\n"
                                        + "2. Body Content\n"
                                        + "3. Add an Image\n"
                                        + "4. Background\n"
                                        + "5. Done\n");
                    try{
                    System.out.print("CHOICE: ");  
                    userSelect = keyboard.nextInt();
                    keyboard.nextLine();

                    }catch(InputMismatchException e){
                        keyboard.next();
                        userSelect = 0;
                    }

                    if(userSelect < 1 || userSelect > 5){
                            System.out.println("\nNot a valid choice.");
                    }

                }while(!(userSelect == 1 || 
                            userSelect == 2 || 
                            userSelect == 3 ||
                            userSelect == 4 ||
                            userSelect == 5));

                if(userSelect == 1 || userSelect == 2){

                    String textInput = "";
                    int sizeSelect = 0;

                    //[REQ#6] "switch" statement used for decision branching
                    switch(userSelect){

                        case 1:
                            System.out.println("\nWhat would you like the title to be?");

                            //[REQ#2]Accepts String input from the user
                            textInput = keyboard.nextLine();

                            System.out.println("\nHow large should the title be?\n"
                                    + "Enter a number (1-5):\n"
                                    + "1. Humongous\n"
                                    + "2. Very Large\n"
                                    + "3. Large\n"
                                    + "4. Medium\n"
                                    + "5. Small\n");
                            System.out.print("CHOICE: ");
                            sizeSelect = keyboard.nextInt();
                            keyboard.nextLine();

                            break;

                        case 2:
                            System.out.println("\nWhat would you like to say in the "
                                    + "body of the webpage?");
                            textInput = keyboard.nextLine();
                            break;

                    }

                    String color ="";

                    do{
                        System.out.println("\nType in a color choice for this text.\n\n"
                                        + "Chartreuse\n"
                                        + "RoyalBlue\n"
                                        + "Crimson\n"
                                        + "SlateGray\n"
                                        + "Orchid\n"
                                        + "DarkCyan\n"
                                        + "Gold\n"
                                        + "MidnightBlue\n"
                                        + "Coral\n"
                                        + "Black\n");
                        System.out.print("COLOR: ");
                        color = keyboard.nextLine();

                    //[REQ#3]String method equalsIgnoreCase() used to validate String input
                    }while(!(color.equalsIgnoreCase("Chartreuse") ||
                            color.equalsIgnoreCase("RoyalBlue") ||
                            color.equalsIgnoreCase("Crimson") ||
                            color.equalsIgnoreCase("SlateGray") ||
                            color.equalsIgnoreCase("Orchid") ||
                            color.equalsIgnoreCase("DarkCyan") ||
                            color.equalsIgnoreCase("Gold") ||
                            color.equalsIgnoreCase("MidnightBlue") ||
                            color.equalsIgnoreCase("Coral") ||
                            color.equalsIgnoreCase("Black")));

                    System.out.println("\nType in an alignment choice for this text.\n\n"
                                    + "right\n"
                                    + "left\n"
                                    + "center\n"
                                    + "justify\n");
                    System.out.print("ALIGN: ");
                    String alignment = keyboard.nextLine();

                    if(userSelect == 1){  
                        //[REQ#8]Calls my own pageTitle() which accepts accepts
                        // various parameters, including a String value via
                        // HTMLStyle method addTextStyles()
                        HTMLCode.pageTitle(textInput, sizeSelect, HTMLStyle.addTextStyles(color, alignment));
                    }else if(userSelect == 2){
                        HTMLCode.bodyContent(textInput, HTMLStyle.addTextStyles(color, alignment));
                    }

                }else if(userSelect == 3){
                    String photo = "";
                    
                    do{
                        System.out.println("\nType in the name of the picture you choose.\n\n"
                                        + "islands\n"
                                        + "mountain\n"
                                        + "city\n"
                                        + "random\n");
                        System.out.print("CHOICE: ");
                        //[REQ#3]String method toLowerCase() to ensure accurate input
                        photo = keyboard.nextLine().toLowerCase();

                    
                    }while(!(photo.equals("islands") ||
                            photo.equals("mountain") ||
                            photo.equals("city") ||
                            photo.equals("random")));
                    
                    System.out.println("\nType in an alignment choice for this photo.\n\n"
                                    + "right\n"
                                    + "left\n"
                                    + "center\n");
                    System.out.print("ALIGN: ");
                    String alignment = keyboard.nextLine();
                    
                    int sizeSelect = 0;
                    do{
                        System.out.println("\nHow large should the photo be?\n"
                                        + "Enter a number (1-5):\n"
                                        + "1. Very Large\n"
                                        + "2. Large\n"
                                        + "3. Medium\n");
                        try{
                        System.out.print("CHOICE: ");  
                        sizeSelect = keyboard.nextInt();
                        keyboard.nextLine();

                        }catch(InputMismatchException e){
                            keyboard.next();
                            userSelect = 0;
                        }
                        
                        if(userSelect < 1 || userSelect > 3){
                            System.out.println("\nNot a valid choice.");
                    }
                        
                    }while(!(sizeSelect == 1 || 
                            sizeSelect == 2 || 
                            sizeSelect == 3));
                    
                     HTMLCode.addPicture(photo, HTMLStyle.addPhotoStyle(sizeSelect), alignment);
                    
                }else if(userSelect == 4){
                    
                    int userChoice;
                    
                    do{
                        System.out.println("\nWould you like a full background image?\n"
                                            + "Enter 1 or 2:\n"
                                            + "1. YES\n"
                                            + "2. NO\n");
                        try{
                            System.out.print("CHOICE: ");  
                            userChoice = keyboard.nextInt();
                            keyboard.nextLine();

                        }catch(InputMismatchException e){
                            keyboard.next();
                            userChoice = 0;
                        }

                        if(userChoice < 1 || userChoice > 2){
                                System.out.println("\nNot a valid choice.");
                        }
                    }while(!(userChoice == 1 || 
                            userChoice == 2));
                    
                    if(userChoice == 1){
                        
                        String backgroundPhoto = "";
                        
                        do{
                        System.out.println("\nType in the name of the background picture you choose.\n\n"
                                        + "islands\n"
                                        + "mountain\n"
                                        + "city\n");
                        System.out.print("CHOICE: ");
                        //String method toLowerCase() to ensure accurate input
                        backgroundPhoto = keyboard.nextLine().toLowerCase();

                    
                        }while(!(backgroundPhoto.equals("islands") ||
                                backgroundPhoto.equals("mountain") ||
                                backgroundPhoto.equals("city")));
                    
                        HTMLStyle.addBackgroundPhotoStyle(backgroundPhoto);
                        
                    } 
                            
                    String backgroundColor = "";
                    
                    do{
                        System.out.println("\nType in a color choice for the background.\n\n"
                                        + "White\n"
                                        + "Gray\n"
                                        + "Navy\n"
                                        + "Green\n"
                                        + "Red\n"
                                        + "Yellow\n"
                                        + "Pink\n"
                                        + "Blue\n"
                                        + "Orange\n"
                                        + "Black\n");
                        System.out.print("COLOR: ");
                        backgroundColor = keyboard.nextLine();

                    //String method equalsIgnoreCase() used to validate String input
                    }while(!(backgroundColor.equalsIgnoreCase("White") ||
                            backgroundColor.equalsIgnoreCase("Gray") ||
                            backgroundColor.equalsIgnoreCase("Navy") ||
                            backgroundColor.equalsIgnoreCase("Green") ||
                            backgroundColor.equalsIgnoreCase("Red") ||
                            backgroundColor.equalsIgnoreCase("Yellow") ||
                            backgroundColor.equalsIgnoreCase("Pink") ||
                            backgroundColor.equalsIgnoreCase("Blue") ||
                            backgroundColor.equalsIgnoreCase("Orange") ||
                            backgroundColor.equalsIgnoreCase("Black")));
                    
                    HTMLStyle.addBackgroundColorStyle(backgroundColor);
                    
                }

            }
            
            //Adds final HTML code to create a valid and complete web page
            HTMLCode.finalizePage();
            System.out.println("\nYour web page is ready!\n");

            //[REQ#9]Uses created class HTMLCode and constucts an object
            //that can be executed as a webpage
            HTMLCode page1 = new HTMLCode();
            
            do{
                System.out.println("Would you like to open your new web page?\n"
                                + "Enter 1 or 2:\n"
                                + "1. YES\n"
                                + "2. NO\n");  
                try{
                    System.out.print("CHOICE: ");  
                    userSelect = keyboard.nextInt();
                    keyboard.nextLine();

                }catch(InputMismatchException e){
                    keyboard.next();
                    userSelect = 0;
                }

                if(userSelect < 1 || userSelect > 2){
                    System.out.println("\nNot a valid choice.");
                }
            }while(!(userSelect == 1 || 
                     userSelect == 2));

            if(userSelect == 1){
                //[REQ#9] Allows the user to open her unique webpage by calling the openPage()
                //method on the HTMLCode object "page1"
                page1.openPage();
            }
            
        }else if(userSelect == 2){
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                + "CONVERT A TEXT FILE TO A WEBPAGE\n"
                                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            
            System.out.println();
            System.out.println("Unfortunately this service is UNDER CONSTRUCTION "
                                + " at this time.\nCheck for updates in the near future.\n"
                                + ":D");
        }
            
        System.out.println("\nGoodbye.");
            
    } 
}
