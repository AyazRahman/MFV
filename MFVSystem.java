
/**
 * Write a description of class System here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.lang.*;
import java.util.*;
import java.lang.System;
import java.util.Calendar;

public class MFVSystem
{
    private static Scanner scan;
    private static String option;
    private FileManager db;
    private Menu menu;

    public MFVSystem()
    {
        db = new FileManager();
        db.loadData();
        menu = new Menu();
        menu.loadMenuItems();
    }

    private void displayLogo()
    {
        System.out.println(" __  __ _____   __ ");
        System.out.println("|  \\/  | __\\ \\ / /");
        System.out.println("| |\\/| | _| \\ V /");                 
        System.out.println("|_|  |_|_|   \\_/ ");                    

    }

    public void systemStart()
    {
        displayLogo();

        String selection = menu.displayMenu(1);

        if (selection.matches("[Aa]"))
        {
            System.out.println("Call login method here");
        }
        else if (selection.matches("[Bb]"))
        {
            System.out.println("Call Register method here");
        }
        else if (selection.matches("[Cc]"))
        {
            System.exit(0);
        }
        //Unexpected input handled inside Menu class
    }

    public static void main(String[] args) 
    {
        while (true) 
        {
            System.out.println("**** Welcom To MFV Store ****");
            System.out.println("Choose One Of The Following Options:");
            System.out.println("(v) To View Products \n(l) To Login \n(r) To Register\n");
            Scanner o = new Scanner(System.in);
            option = o.nextLine();

            if (option.equals("v"))
            {
                System.out.println("There should be product method taken from Product class\n");
            }
            else if (option.equals("l"))
            {
                System.out.println("******* Login Page *******");

                System.out.println("Type Your Email Please");
                Scanner e = new Scanner(System.in);
                String entredEmail = e.nextLine();

                System.out.println("Type Your Password");
                Scanner pass = new Scanner(System.in);
                String password = pass.nextLine();

                
                FileManager user = new FileManager();
                boolean loggedIn = false;
                boolean isAdmin = false;
                if(user.loginUser(entredEmail, password))
                {
                    loggedIn = true;
                    if(entredEmail.equals("admin"))
                    {
                        isAdmin = true;
                    }
                }

                while(loggedIn && isAdmin)
                {
                    System.out.println("***** This Is Admin Main Page ******");
                    System.out.println("Choose One Of The Following Options:");
                    System.out.println("(v) To View Products \n(m) To Open Admin Menu \n(l) To Logout \n");
                    Scanner a = new Scanner(System.in);
                    option = a.nextLine();
                    if (option.equals("v"))
                    {
                        System.out.println("There should be product method taken from Product class\n");
                    }
                    if (option.equals("m"))
                    {
                        System.out.println("Admin Menu method should work here\n");
                    }
                    else if(option.equals("l"))
                    {
                        System.out.println("You Are Logged Out Successfully\n");
                        loggedIn = false;
                        isAdmin = false;
                    }
                    else if(option.equals("?"))
                    {
                        System.out.println("All the rest methods should be linked here\n");
                    }
                }

                while (loggedIn && !isAdmin)
                {
                    System.out.println("***** Welcom " + entredEmail + " This Is Your Main Page ******");
                    System.out.println("Choose One Of The Following Options:");
                    System.out.println("(v) To View Products \n(l) To Logout \n(?) ect..\n");
                    Scanner a = new Scanner(System.in);
                    option = a.nextLine();
                    if (option.equals("v"))
                    {
                        System.out.println("There should be product method taken from Product class\n");
                    }
                    else if(option.equals("l"))
                    {
                        System.out.println("You Are Logged Out Successfully\n");
                        loggedIn = false;
                    }
                    else if(option.equals("?"))
                    {
                        System.out.println("All the rest of methods should be linked here\n");
                    }
                }
            }
            else if (option.equals("r"))
            {
                FileManager CheckUserToRegister = new FileManager();
                CheckUserToRegister.registerUser();
            }
            else System.out.println("Plese Select a Valid Option\n");
        }
    }
    

}
