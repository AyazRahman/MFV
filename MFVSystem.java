
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
                
                System.out.println("Type Your User Name Please");
                Scanner u = new Scanner(System.in);
                String userName = u.nextLine();
        
                System.out.println("Type Your Password");
                Scanner pass = new Scanner(System.in);
                String password = pass.nextLine();
                
                Login user = new Login();
                boolean loggedIn = false;
                if(user.loginUser(userName, password))
                {
                    loggedIn = true;
                }
                while (loggedIn)
                {
                    System.out.println("***** Welcom " + userName + " This Is Your Main Page ******");
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
                        System.out.println("You Are Logged Out Successfully");
                        loggedIn = false;
                    }
                    else if(option.equals("?"))
                    {
                        System.out.println("All the rest methods should be linked here");
                    }
                }
            }
            else if (option.equals("r"))
            {
                Register user = new Register();
                user.registerUser();
            }
            else System.out.println("Plese Select Valid Option");
        }
    }
}