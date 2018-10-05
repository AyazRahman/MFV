
/**
 * Write a description of class System here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class MFVSystem
{
    private static Scanner scan;
    private static String option;
    private FileManager db;
    private UserInterface ui;
    private User loggedUser;

    public MFVSystem()
    {
        db = new FileManager();
        db.loadData();
        ui = new UserInterface();
        ui.loadMenuItems();
        loggedUser = new User();
    }

    public void systemStart()
    {
        ui.displayLogo();

        String selection = ui.displayMenu(1);

        if (selection.matches("[Aa]"))
        {
            //System.out.println("Call login method here");
            userLogin();
        }
        else if (selection.matches("[Bb]"))
        {
            //TODO: implement userRegister()
            userRegister();
        }
        else if (selection.matches("[Cc]"))
        {
            //exit
            exitProgram();
        }
        //Unexpected input handled inside Menu class
    }

    private void userLogin()
    {
        //TODO: create Login form to get email and password from user
        String email = ui.emailInput();
        String password = ui.pwdLogin();
        for (User u : db.getUsers())
        {
            if (email.equals(u.getEmail()) && password.equals(u.getPassword()))
            {
                loggedUser = u;
                ui.logSuccess();
                break;
            }
        }

        if (loggedUser.getEmail().equals(email))
        {
            //display userMenu()
            userMenu();
        }
        else
        {
            ui.loginError();
            systemStart();
        }
    }

    private void userRegister()
    {
        //TODO create register form and get more information other that email and password
        String email = ui.emailInput();
        String password = ui.pwdInput();
        boolean userExist = false;
        for (User u : db.getUsers())
        {
            if ( email.equals(u.getEmail()))
            {
                userExist = true;
                break;
            }
        }
        if (userExist)
        {
            ui.userExistsMsg();
            systemStart();
        }
        else
        {
            //create new user and add it to the database
            User newUser = new Customer();
            newUser.setEmail(email);
            newUser.setPassword(password);
            //add to the DB list
            db.getUsers().add(newUser);
            ui.regSuccess();
        }
        systemStart();
    }

    //TODO: change the method to private after testing
    private void userMenu()
    {
        if (loggedUser instanceof Customer)
        {
            //call Customer menu
            String selection =ui.displayMenu(2);
            if (selection.matches("[Aa]"))
            {
                //browse products
                //TODO: test
                String id = ui.displayAllProduct(db.getProductArray());
                int pid = Integer.parseInt(id);
                browseSelect(pid);
            }
            else if (selection.matches("[Bb]"))
            {
                //search
                search();
            }
        }
        else
        {
            //call Admin menu
            String selection = ui.displayMenu(3);
            //TODO: check selection
        }
    }

    //turn to private after testing
    public void search()
    {
        String input = ui.searchBox();
        if (db.getKeywords().containsKey(input.toLowerCase()))
        {
            Product result = db.getProducts().get(db.getKeywords().get(input.toLowerCase()));
            //send result to view search result
            //TODO: pass only values instead of the Product object
            ui.searchResult(input, result);
            //TODO: display user options for product
        }
        else
        {
            //call does not exist method
            ui.searchError(input);
            userMenu();
        }

    }

    private void browseSelect(int pid)
    {
        Product p = db.getProducts().get(pid);
        //TODO: send the values rather than the product object
        ui.browseResult(p);
        //TODO: display user options for product
    }

    private void exitProgram()
    {
        db.saveData();
        System.exit(0);
    }

    //TODO: the following may be deleted

    /*public static void main(String[] args) 
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
    }*/

}
