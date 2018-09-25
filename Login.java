
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
    private String checkUserName;
    private String checkPassword;

    public boolean loginUser(String userName,String password)
    {
        boolean found = false;
        checkUserName = "";
        checkPassword = ""; 
        boolean status = false;
        
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
                System.out.println("You have successfully Logged In\n");
                status = true;
            }
            else
            {
                
                System.out.println("Wrong User Name or Password\n");
                status = false;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        
        return status;
    }
     
} 

