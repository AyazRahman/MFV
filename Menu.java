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
    String startRange;
    private ArrayList<String> cusStartMenu;
    String cusStartRange;
    private ArrayList<String> ownStartMenu;
    String ownStartRange;
    Validation valid;
    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        startMenu = new ArrayList<String>();
        startRange = "[A-Ca-c]";
        cusStartMenu = new ArrayList<String>();
        cusStartRange = "[A-Ha-h]";
        ownStartMenu = new ArrayList<String>();
        ownStartRange = "[A-La-l]";
        valid = new Validation();
    }

    public void loadMenuItems()
    {
        //Start menu items
        startMenu.add("[A] Login");
        startMenu.add("[B] Register");
        startMenu.add("[C] Exit");
        
        //Customer menu items
        cusStartMenu.add("Menu");
        cusStartMenu.add("[A] Browse Products");
        cusStartMenu.add("[B] Product Search");
        cusStartMenu.add("[C] Shopping Cart");
        cusStartMenu.add("[D] Checkout");
        cusStartMenu.add("[E] Order History");
        cusStartMenu.add("[F] Account Details");
        cusStartMenu.add("[G] Logout");
        cusStartMenu.add("[H] Exit");

        //Owner menu items
        ownStartMenu.add("Menu");
        ownStartMenu.add("[A] Add Product");
        ownStartMenu.add("[B] Browse Products");
        ownStartMenu.add("[C] Product Search");
        ownStartMenu.add("[D] Edit Product");
        ownStartMenu.add("[E] Remove Product");
        ownStartMenu.add("[F] Add Batch");
        ownStartMenu.add("[G] Edit Batch");
        ownStartMenu.add("[H] Remove Batch");
        ownStartMenu.add("[I] View Customer Accounts");
        ownStartMenu.add("[J] View Orders");
        ownStartMenu.add("[K] Logout");
        ownStartMenu.add("[L] Exit");
    }
    
    public String displayMenu(int menuID)
    {
        String range = "";
        ArrayList<String> options = startMenu;
        String selection = "";
        
        switch (menuID)
        {
            case 1:
                range = startRange;
                options = startMenu;
                break;
            case 2:
                range = cusStartRange;
                options = cusStartMenu;
                break;
            case 3:
                range = ownStartRange;
                options = ownStartMenu;
                break;
            default:
                System.out.println("Menu failed to initialise, give it a valid parameter.");
        }
  
        for (String i : options)
        {
            System.out.println(i);
        }
        
        while (selection.equals(""))
        {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.trim().matches(range))
            {
                selection = input;
            }
            else
            {
                System.out.println("Valid selections only mate!");
            }
        }
        
        return selection;
    }
    
    public String searchBox()
    {
        clearScreen();
        System.out.println("Enter the name of the product you want to search:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.trim();
    }
    
    public void searchResult(String input, Product p)
    {
        clearScreen();
        System.out.println("Searched keyword: " + input);
        System.out.println();
        System.out.println("Closest match");
        displayProduct(p);
    }
    
    public void browseResult(Product p)
    {
        clearScreen();
        displayProduct(p);
    }
    
    public String displayAllProduct(Product[] products)
    {
        clearScreen();
        for (Product p : products)
        {
            displayProduct(p);
        }
        //Needs validation
        System.out.println("Enter Product ID to select the product: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
    
    public void displayProduct(Product p)
    {
        System.out.println("Product ID:" + p.getProductID() +"\t Name: " + p.getName());
    }
    
    public void searchError(String keyword)
    {
        clearScreen();
        System.out.println("Searched keyword: " + keyword);
        System.out.println("The searched product does not exist. Or check the spelling and try again");
        pressEnter();
    }
    
    private void clearScreen()
    {
        System.out.print('\u000C');
    }
    
    private void pressEnter()
    {
        System.out.println("Press Enter to continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
