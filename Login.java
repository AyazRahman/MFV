
/**
 * Write a description of class Login here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.lang.*;
import java.util.*;
import java.lang.System;

public class Login
{
    private static Scanner scan;
    private String filePath = "users.csv";
    private String userName;
    private String password;
    
    private String checkUserName;
    private String checkPassword;

    public void loginUser()
    {
        System.out.println("Login");
        
        System.out.println("Type Your User Name");
        Scanner user = new Scanner(System.in);
        userName = user.nextLine();
        
        System.out.println("Type Your Password");
        Scanner pass = new Scanner(System.in);
        password = pass.nextLine();
        
        boolean found = false;
        checkUserName = "";
        checkPassword = ""; 
        
        try 
        {
            scan = new Scanner(new File(filePath));
            
            
            while(scan.hasNext() && !found)
            {
                String data = scan.next();
                String[] values = data.split(",");
                
                checkUserName = values[0];
                checkPassword = values[1];
                
                if(checkUserName.equals(userName) && checkPassword.equals(password) )
                {
                    found = true;
                }
                
                
            }
            
            if (found)
            {
                System.out.println("You have successfully Logged In");
            }
            else
            {
                
                System.out.println("Wrong User Name or Password");
                
            }
        }
        catch(IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
     
} 

