
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

        while (!selection.matches("[Cc]"))
        {
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

            selection = ui.displayMenu(1);
        }
        if (selection.matches("[Cc]"))
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
            //systemStart();
        }
        else
        {
            //create new user and add it to the database
            User newUser = new Customer();
            newUser.setUId(db.getUsers().size());
            newUser.setEmail(email);
            newUser.setPassword(password);
            //add to the DB list
            db.getUsers().add(newUser);
            ui.regSuccess();
        }

    }

    private void updateAccount()
    {
        String selection = ui.displayMenu(9);

        if (selection.matches("[Aa]"))
        {
            String fname = ui.updateFname();
            ui.updateMsg("First Name"); //Success message when detail is updated/set
        }
        else if (selection.matches("[Bb]"))
        {
            String lname = ui.updateLname();
            ui.updateMsg("Last Name");
        }
        else if (selection.matches("[Cc]"))
        {
            String address = ui.updateAddress();
            ui.updateMsg("Address");
        }
        else if (selection.matches("[Dd]"))
        {
            String suburb = ui.updateSuburb();
            ui.updateMsg("Suburb");
        }
        else if (selection.matches("[Ee]"))
        {
            String pc = ui.updatePostcode();
            ui.updateMsg("Postcode");
        }
        else if (selection.matches("[Ff]"))
        {
            String state = ui.updateState();
            ui.updateMsg("State");
        }
        else if (selection.matches("[Gg]"))
        {
            String email = ui.emailInput();
            ui.updateMsg("Email Address");
        }
        else if (selection.matches("[Hh]"))
        {
            String pwd = ui.pwdInput();
            ui.updateMsg("Password");
        }
        else if (selection.matches("[Ii]"))
        {
            String cardNo = ui.updateCardNumber();
            ui.updateMsg("Bank Card");
        }
        else if (selection.matches("[Jj]"))
        {
            String cardName = ui.updateCardName();
            ui.updateMsg("Bank Card Name");
        }
        else if (selection.matches("[Kk]"))
        {
            String ccv = ui.updateCCV();
            ui.updateMsg("Bank Card CCV");
        }
        else if (selection.matches("[Ll]"))
        {
            String payPref = ui.updatePayPref();
            ui.updateMsg("Payment Preference");
        }
        else if (selection.matches("[Mm]"))
        {
            String collPref = ui.updateCollectionPref();
            ui.updateMsg("Collection Preference");
        }
        else if (selection.matches("[Nn]"))
        {
            String choice = ui.unregister();
            if (choice.matches("[Yy]"))
            {
                System.out.println("Call unregister method here");
            }
            if (choice.matches("[Nn]"))
            {
                userMenu();
            }
        }
        else if (selection.matches("[Oo]"))
        {
            ui.displayMenu(2);
        }
    }

    //TODO: change the method to private after testing
    private void userMenu()
    {
        if (loggedUser instanceof Customer)
        {
            //call Customer menu
            String selection = ui.displayMenu(2);
            while (!selection.matches("[Ff]") && !selection.matches("[Gg]"))
            {
                //TODO: check for user menu options
                if (selection.matches("[Aa]"))
                {
                    //view product 
                    String s = ui.displayMenu(4);
                    while (!s.matches("[Cc]"))
                    {
                        if (s.matches("[Aa]"))
                        {
                            search();
                        }
                        else if (s.matches("[Bb]"))
                        {
                            browse();
                        }
                    }
                }
                else if (selection.matches("[Bb]"))
                {
                    //shopping cart

                }
                else if (selection.matches("[Cc]"))
                {
                    //checkout

                }
                else if (selection.matches("[Dd]"))
                {
                    //order history

                }
                else if (selection.matches("[Ee]"))
                {
                    updateAccount();

                }

            }
            if (selection.matches("[Ff]"))
            {
                loggedUser = new User();
            }
            else if (selection.matches("[Gg]"))
            {
                exitProgram();
            }

        }
        else
        {
            //call Admin menu
            String selection = ui.displayMenu(3);
            while (!selection.matches("[Dd]") && !selection.matches("[Ee]"))
            {
                if (selection.matches("[Aa]"))
                {
                    productManagement();
                }
                else if (selection.matches("[Bb]"))
                {
                    orderManagement();
                }
                else if (selection.matches("[Cc]"))
                {
                    //TODO:UI Account Edit form
                }
                selection = ui.displayMenu(3);
            }
            if (selection.matches("[Dd]"))
            {
                loggedUser = new User();
            }
            else if (selection.matches("[Ee]"))
            {
                exitProgram();
            }
        }
    }

    private void productManagement()
    {
        String selection  = ui.displayMenu(6);
        while (!selection.matches("[Dd]"))
        {
            if (selection.matches("[Aa]"))
            {
                search();
            }
            else if (selection.matches("[Bb]"))
            {
                browse();
            }
            else if (selection.matches("[Cc]"))
            {
                //TODO:UI Add product form

            }
            selection = ui.displayMenu(6);
        }
    }

    private void browse()
    {
        String id = ui.displayAllProduct(db.getProductArray());
        int pid = Integer.parseInt(id);
        if (db.getProducts().containsKey(pid))
        {
            browseSelect(pid);
        }
        else
        {
            System.out.println("Wrong Id selected");
        }

    }

    private void productMenu()
    {
        if (loggedUser instanceof Customer)
        {
            //call customer product menu
            String selection = ui.displayMenu(7);
            while (!selection.matches("[Bb]"))
            {
                if (selection.matches("[Aa]"))
                {
                    //TODO: purchase product sequence and logic for customer
                    //TODO: UI need options for purchasing a batch
                }
            }
        }
        else
        {
            //call admin menu
            String selection = ui.displayMenu(8);
            while (!selection.matches("[Ff]"))
            {
                if (selection.matches("[Aa]"))
                {
                    //TODO: Edit product sequence
                    //TODO:UI Edit product sequence form
                }
                else if (selection.matches("[Bb]"))
                {
                    //TODO:UI confirmation for removing product form. Return type boolean
                    if (false)
                    {
                        //TODO: remove product Logic
                    }
                }
                else if (selection.matches("[Cc]"))
                {
                    //TODO:UI Add batch form and  System sequence
                }
                //  confusion for rest of the options
                selection = ui.displayMenu(8);
            }
        }
    }

    private void orderManagement()
    {
        //TODO: call orderManagement menu
    }

    private void orderMenu()
    {
        //TODO: need form for Order Management
    }
    //turn to private after testing
    public void search()
    {
        String input = ui.searchBox();
        if (db.getKeywords().containsKey(input.toLowerCase()))
        {
            Product result = db.getProducts().get(db.getKeywords().get(input.toLowerCase()));
            int pId = result.getProductID();
            //send result to view search result
            //TODO: pass only values instead of the Product object
            ui.searchResult(input, result);

            productMenu();
        }
        else
        {
            //call does not exist method
            ui.searchError(input);

        }

    }

    private void browseSelect(int pid)
    {
        Product p = db.getProducts().get(pid);
        //TODO: send the values rather than the product object
        ui.browseResult(p);

        productMenu();
    }

    private void exitProgram()
    {
        db.saveData();
        System.exit(0);
    }
}

