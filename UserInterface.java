import java.util.*;

/**
 * Write a description of class Menu here.
 *
 * @author Team118
 * @version 1.0
 */
public class UserInterface
{
    // instance variables - replace the example below with your own
    private ArrayList<String> startMenu;
    String startRange;
    private ArrayList<String> cusStartMenu;
    String cusStartRange;
    private ArrayList<String> ownStartMenu;
    String ownStartRange;
    private ArrayList<String> cusProductMenu;
    String cusProductRange;
    private ArrayList<String> prodSelectMenu;
    String prodSelectRange;
    private ArrayList<String> cusProductMenu2;
    String cusProductRange2;
    private ArrayList<String> ownProductMenu;
    String ownProductRange;
    private ArrayList<String> ownProductMenu2;
    String ownProductRange2;
    Validation valid;
    private Scanner scan;

    /**
     * Constructor for objects of class Menu
     */
    public UserInterface()
    {
        scan = new Scanner(System.in);

        //ID: 1
        startMenu = new ArrayList<String>();
        startRange = "[A-Ca-c]";
        //ID: 2
        cusStartMenu = new ArrayList<String>();
        cusStartRange = "[A-Ga-g]";
        //ID: 3
        ownStartMenu = new ArrayList<String>();
        ownStartRange = "[A-La-l]";
        valid = new Validation();
        ownStartRange = "[A-Ea-e]";
        //ID: 4
        cusProductMenu = new ArrayList<String>();
        cusProductRange = "[A-Ca-c]";
        //ID: 5
        prodSelectMenu = new ArrayList<String>();
        prodSelectRange = "[A-Ba-b]";
        //ID: 6
        cusProductMenu2 = new ArrayList<String>();
        cusProductRange2 = "[A-Ca-c]";
        //ID: 7
        ownProductMenu = new ArrayList<String>();
        ownProductRange = "[A-Ba-b]";
        //ID: 8
        ownProductMenu2 = new ArrayList<String>();
        ownProductRange2 = "[A-Fa-f]";
    }

    public void userExistsMsg()
    {
        System.out.println("You already have an account. Login or register with a different email address.");
    }
    
    public String emailInput()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your email address: ");
        String email = "";
        while(email.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateEmail(input.trim()) == true)
            {
                email = input;
            }
            else
            {
                System.out.println("Valid email addresses only mate!");
            }
        }    
        return email;
    }

    public String pwdInput()
    {
        System.out.println("Enter your password: ");
        String pwd = "";
        while(pwd.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validatePwd(input.trim()) == true)
            {
                System.out.println("Confirm your password: ");
                String confirm = scan.nextLine();
                if (input.equals(confirm))
                {
                    pwd = input;
                }
                else
                {
                    System.out.println("Passwords don't match, please enter a new password and confirm it again.");
                }
            }
            else
            {
                System.out.println("Passwords must be at least 5 characters long.");
            }
        }
        return pwd;
    }
    
    

    public void displayLogo()
    {
        System.out.println(" __  __ _____   __ ");
        System.out.println("|  \\/  | __\\ \\ / /");
        System.out.println("| |\\/| | _| \\ V /");                 
        System.out.println("|_|  |_|_|   \\_/ ");                    

    }
    
    public void loadMenuItems()
    {
        //Start menu items ID: 1
        startMenu.add("[A] Login");
        startMenu.add("[B] Register");
        startMenu.add("[C] Exit");

        //Customer menu items ID: 2
        cusStartMenu.add("Menu");
        cusStartMenu.add("[A] View Products");
        cusStartMenu.add("[B] Shopping Cart");
        cusStartMenu.add("[C] Checkout");
        cusStartMenu.add("[D] Order History");
        cusStartMenu.add("[E] Account Details");
        cusStartMenu.add("[F] Logout");
        cusStartMenu.add("[G] Exit");

        //Owner menu items ID: 3
        ownStartMenu.add("Menu");
        ownStartMenu.add("[A] Product Management");
        ownStartMenu.add("[B] Order Management");
        ownStartMenu.add("[C] Account Management");
        ownStartMenu.add("[D] Logout");
        ownStartMenu.add("[E] Exit");

        //Customer Initial product menu ID: 4
        cusProductMenu.add("Menu");
        cusProductMenu.add("[A] Product Search");
        cusProductMenu.add("[B] Browse Products");
        cusProductMenu.add("[C] Back");

        //Product selection menu (customer and owner) ID: 5
        prodSelectMenu.add("Menu");
        prodSelectMenu.add("[A] View Product Details");
        prodSelectMenu.add("[B] Back");

        //Owner initial product menu ID: 6
        ownProductMenu.add("Menu");
        ownProductMenu.add("[A] Product Search");
        ownProductMenu.add("[B] Browse Products");
        ownProductMenu.add("[C] Add Product");
        ownProductMenu.add("[D] Add Batch");
        ownProductMenu.add("[E] Back");

        //Customer product interaction menu ID: 7
        cusProductMenu2.add("Menu");
        cusProductMenu2.add("[A] Purchase Product");
        cusProductMenu2.add("[B] Back");

        //Owner product interaction menu ID: 8
        ownProductMenu2.add("Menu");
        ownProductMenu2.add("[A] Edit Product");
        ownProductMenu2.add("[B] Remove Product");
        ownProductMenu2.add("[C] Add Batch");
        ownProductMenu2.add("[D] Edit Batch");
        ownProductMenu2.add("[E] Remove Batch");
        ownProductMenu2.add("[F] Back");
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
            case 4:
            range = cusProductRange;
            options = cusProductMenu;
            break;
            case 5:
            range = prodSelectRange;
            options = prodSelectMenu;
            break;
            case 6:
            range = ownProductRange;
            options = ownProductMenu;
            break;
            case 7:
            range = cusProductRange2;
            options = cusProductMenu2;
            break;
            case 8:
            range = ownProductRange2;
            options = ownProductMenu2;
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
