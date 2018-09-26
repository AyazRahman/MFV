import java.util.*;

/**
 * Write a description of class Menu here.
 *
 * @author Team118
 * @version 1.0
 */
public class Menu
{
    // instance variables - replace the example below with your own
    private ArrayList<String> startMenu;
    private ArrayList<String> cusMenu;
    private ArrayList<String> ownMenu;
    
    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        startMenu = new ArrayList<String>();
        cusMenu = new ArrayList<String>();
        ownMenu = new ArrayList<String>();
    }

    /**
     * 
     */
    public void loadMenuItems()
    {
        //Start menu items
        startMenu.add("[A] Login");
        startMenu.add("[B] Register");
        
        //Customer menu items
        cusMenu.add("[A] View Products");
        cusMenu.add("[B] View Shopping Cart");
        cusMenu.add("[C] Order History");
        cusMenu.add("[D] Product Search");
        cusMenu.add("[E] Checkout");
        
        //Owner menu items
        ownMenu.add("[A] Add Product");
        ownMenu.add("[B] Edit Product");
        ownMenu.add("[C] Remove Product");
        ownMenu.add("[D] Add Batch");
        ownMenu.add("[E] Edit Batch");
        ownMenu.add("[F] Remove Batch");
        ownMenu.add("[G] View Customer Accounts");
        cusMenu.add("[H] View Products");
        cusMenu.add("[I] Product Search");
        cusMenu.add("[J] View Orders");
    }
    
    public String displayStartMenu()
    {
        String selection = "";
  
        for (String i : startMenu)
        {
            System.out.println(i);
        }
        
        while (selection.equals(""))
        {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.trim().matches("[A-Ba-b]"))
            {
                selection = input;
            }
            else
            {
                System.out.println("Please make a valid selection");
            }
        }
        
        return selection;
    }
    
    public String displayCustomerMenu()
    {
        String selection = "";
  
        for (String i : cusMenu)
        {
            System.out.println(i);
        }
        
        while (selection.equals(""))
        {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.trim().matches("[A-Ea-e]"))
            {
                selection = input;
            }
            else
            {
                System.out.println("Please make a valid selection");
            }
        }
        
        return selection;
    }
    
    public String displayOwnerMenu()
    {
        String selection = "";
  
        for (String i : ownMenu)
        {
            System.out.println(i);
        }
        
        while (selection.equals(""))
        {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.trim().matches("[A-Ja-j]"))
            {
                selection = input;
            }
            else
            {
                System.out.println("Please make a valid selection");
            }
        }
        
        return selection;
    }
}
