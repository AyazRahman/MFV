
/**
 * Write a description of class Register here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.lang.*;
import java.util.*;
import java.lang.System;
public class Register
{
    private static Scanner scan;
    String filePath = "users.csv";
    private String userName;
    private String password;
    public void registerUser()
    {
        System.out.println("Welcome To Registration Page");
        
        System.out.println("Type a user name");
        Scanner user = new Scanner(System.in);
        userName = user.nextLine();
        
        System.out.println("Type a password");
        Scanner pass = new Scanner(System.in);
        password = pass.nextLine();
        boolean found = false;
        String checkUserName = "";
        
        try 
        {
            scan = new Scanner(new File(filePath));
            
            
            while(scan.hasNext() && !found)
            {
                String data = scan.next();
                String[] values = data.split(",");
                checkUserName = values[0];
                
                if(checkUserName.equals(userName))
                {
                    found = true;
                }
                
                
            }
            
            if (found)
            {
                System.out.println("This User Name Is Already Registred");
            }
            else
            {
                writeToFile(userName, password);
                System.out.println("You have successfully registred");
                
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeToFile(String username, String password) throws IOException 
    {
        BufferedWriter out = new BufferedWriter(new FileWriter("users.csv", true));
        out.write(username + "," + password);
        out.newLine();
        out.close();
    }

}


