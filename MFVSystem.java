
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
public class MFVSystem
{
    private static Scanner scan;
    private static String option;

    
    public static void main(String[] args) 
    {
       
        System.out.println("Welcom To MFV Store");
        System.out.println("Choose One Of The Following Options:");
        System.out.println("(v) for View Products \n(l) for Login \n(r) for Registration");
        Scanner o = new Scanner(System.in);
        option = o.nextLine();
        
        if (option.equals("v"))
        {
            System.out.println("There should be product method taken from Product class");
        }
        else if (option.equals("l"))
        {
            Login user = new Login();
            user.loginUser();
        }
        else if (option.equals("r"))
        {
            Register user = new Register();
            user.registerUser();
        }
        else System.out.println("Plese Select Valid Option");
  
    }
   
}
