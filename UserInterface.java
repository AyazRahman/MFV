import java.util.*;
import java.text.SimpleDateFormat;  

/**
 * Comment
 *
 * @author Team118
 * @version 1.0
 */
public class UserInterface
{
    Validation valid;
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
    private ArrayList<String> accDetailsMenu;
    String accDetailsRange;
    private ArrayList<String> editProdMenu;
    String editProdRange;
    private ArrayList<String> selBatchMenu;
    String selBatchRange;
    private ArrayList<String> batchMenu;
    String batchRange;
    private ArrayList<String> edBatchMenu;
    String edBatchRange;
    private ArrayList<String> sysReportMenu;
    String sysReportRange;
    private ArrayList<String> cartMenu;
    String cartRange;
    private ArrayList<String> orderMgmtMenu;
    String orderMgmtRange;
    
    /**
     * Constructor for objects of class Menu
     */
    public UserInterface()
    {
        Scanner scan = new Scanner(System.in);
        valid = new Validation();

        //ID: 1
        startMenu = new ArrayList<String>();
        startRange = "[A-Ca-c]";
        //ID: 2
        cusStartMenu = new ArrayList<String>();
        cusStartRange = "[A-Ga-g]";
        //ID: 3
        ownStartMenu = new ArrayList<String>();
        ownStartRange = "[A-Fa-f]";
        //ID: 4
        cusProductMenu = new ArrayList<String>();
        cusProductRange = "[A-Ca-c]";
        //ID: 5
        prodSelectMenu = new ArrayList<String>();
        prodSelectRange = "[A-Ba-b]";
        //ID: 6
        ownProductMenu = new ArrayList<String>();
        ownProductRange = "[A-Da-d]";
        //ID: 7
        cusProductMenu2 = new ArrayList<String>();
        cusProductRange2 = "[A-Ba-b]";
        //ID: 8
        ownProductMenu2 = new ArrayList<String>();
        ownProductRange2 = "[A-Fa-f]";
        //ID: 9
        accDetailsMenu = new ArrayList<String>();
        accDetailsRange = "[A-Oa-o]";
        //ID: 10
        editProdMenu = new ArrayList<String>();
        editProdRange = "[A-Ea-e]";
        //ID: 11
        selBatchMenu = new ArrayList<String>();
        selBatchRange = "[A-Ba-b]";
        //ID: 12
        batchMenu = new ArrayList<String>();
        batchRange = "[A-Ca-c]";
        //ID: 13
        edBatchMenu = new ArrayList<String>();
        edBatchRange = "[A-Fa-f]";
        //ID: 14
        sysReportMenu = new ArrayList<String>();
        sysReportRange = "[A-Ca-c]";
        //ID: 15
        cartMenu = new ArrayList<String>();
        cartRange = "[A-Ca-c]";
        //ID: 16
        orderMgmtMenu = new ArrayList<String>();
        orderMgmtRange = "[A-Da-d]";
        
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
        cusStartMenu.add("[B] Shopping Cart"); //TODO
        cusStartMenu.add("[C] Checkout"); //TODO
        cusStartMenu.add("[D] Order History"); //TODO
        cusStartMenu.add("[E] Account Details"); 
        cusStartMenu.add("[F] Logout");
        cusStartMenu.add("[G] Exit");

        //Owner menu items ID: 3
        ownStartMenu.add("Menu");
        ownStartMenu.add("[A] Product Management"); //Remove prod
        ownStartMenu.add("[B] Order Management"); //View all order, complete, uncomplete => set to complete, cancel order
        ownStartMenu.add("[C] Account Management"); //TODO
        ownStartMenu.add("[D] Reporting"); //Daily report, total sales, order list, total orders
        ownStartMenu.add("[E] Logout");
        ownStartMenu.add("[F] Exit");

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
        ownProductMenu.add("[D] Back");

        //Customer product interaction menu ID: 7
        cusProductMenu2.add("Menu");
        cusProductMenu2.add("[A] Purchase Product"); //TODO
        cusProductMenu2.add("[B] Back");

        //Owner product interaction menu ID: 8
        ownProductMenu2.add("Menu");
        ownProductMenu2.add("[A] Edit Product");
        ownProductMenu2.add("[B] Remove Product"); //TODO
        ownProductMenu2.add("[C] Add Batch"); //Hasan
        ownProductMenu2.add("[D] View Batches"); //Print batch function
        ownProductMenu2.add("[E] Add Keywords"); //TODO + error message
        ownProductMenu2.add("[F] Back");

        //Customer update account details menu ID: 9
        accDetailsMenu.add("Set Account Details");
        accDetailsMenu.add("[A] First Name");
        accDetailsMenu.add("[B] Last Name");
        accDetailsMenu.add("[C] Address");
        accDetailsMenu.add("[D] Suburb");
        accDetailsMenu.add("[E] Postcode");
        accDetailsMenu.add("[F] State");
        accDetailsMenu.add("[G] Email");
        accDetailsMenu.add("[H] Password");
        accDetailsMenu.add("[I] Bank Card Number");
        accDetailsMenu.add("[J] Bank Card Name");
        accDetailsMenu.add("[K] Bank Card CCV");
        accDetailsMenu.add("[L] Payment Preference");
        accDetailsMenu.add("[M] Delivery Preference");
        accDetailsMenu.add("[N] Unregister");
        accDetailsMenu.add("[O] Back");

        //Owner edit product menu ID:10
        editProdMenu.add("Edit Product");
        editProdMenu.add("[A] Name");
        editProdMenu.add("[B] Minimum Shelf Life");
        editProdMenu.add("[C] Maximum Shelf Life");
        editProdMenu.add("[D] Sale Types");
        editProdMenu.add("[E] Back");

        //Owner select batch menu ID:11
        selBatchMenu.add("[A] Select Batch"); //Prompt form
        selBatchMenu.add("[B] Back");

        //Owner batch interaction menu ID: 12
        batchMenu.add("[A] Edit Batch"); //Hasan
        batchMenu.add("[B] Remove Batch"); //Hasan
        batchMenu.add("[C] Back");

        //Owner edit batch menu ID:13
        edBatchMenu.add("Edit Batch");
        edBatchMenu.add("[A] Quantity");
        edBatchMenu.add("[B] Sale Method");
        edBatchMenu.add("[C] Price");
        edBatchMenu.add("[D] Source");
        edBatchMenu.add("[E] Name");
        edBatchMenu.add("[F] Back");

        //Owner get system report ID:14
        sysReportMenu.add("System Report");
        sysReportMenu.add("[A] Today's Report");
        sysReportMenu.add("[B] Report for Selected date");
        sysReportMenu.add("[C] Back");
        
        //Customer cart menu ID:15
        cartMenu.add("Shopping Cart");
        cartMenu.add("[A] Edit Order Quantity");
        cartMenu.add("[B] Remove Product From Order");
        cartMenu.add("[C] Back");
        
        //Owner order management menu ID: 16
        orderMgmtMenu.add("Order Management");
        orderMgmtMenu.add("[A] View All Orders");
        orderMgmtMenu.add("[B] View Unfulfilled Orders");
        orderMgmtMenu.add("[C] View Completed Orders");
        orderMgmtMenu.add("[D] Back");
        
    }

    public void updateMsg(String detail)
    {
        System.out.println("\n" + detail + " Updated!" + "\n");
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
                email = input.trim();
            }
            else
            {
                System.out.println("Valid email addresses only mate!");
            }
        }    
        return email;
    }

    public String pwdLogin()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String pwd = "";
        while(pwd.equals(""))
        {
            String input = scan.nextLine();
            pwd = input;
        }
        return pwd;
    }

    public void loginError()
    {
        System.out.println("Error: Check your login credentials and try again.");
    }

    public String pwdInput()
    {
        Scanner scan = new Scanner(System.in);
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

    public String displayMenu(int menuID)
    {
        String range = "";
        ArrayList<String> options = startMenu;
        String selection = "";
        Scanner scanner = new Scanner(System.in);

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
            case 9:
            range = accDetailsRange;
            options = accDetailsMenu;
            break;
            case 10:
            range = editProdRange;
            options = editProdMenu;
            break;
            case 11:
            range = selBatchRange;
            options = selBatchMenu;
            break;
            case 12:
            range = batchRange;
            options = batchMenu;
            break;
            case 13:
            range = edBatchRange;
            options = edBatchMenu;
            break;
            case 14:
            range = sysReportRange;
            options = sysReportMenu;
            break;
            case 15:
            range = cartRange;
            options = cartMenu;
            break;
            case 16:
            range = orderMgmtRange;
            options = orderMgmtMenu;
            break;
            default:
            System.out.println("Menu failed to initialise, give it a valid argument.");
        }

        for (String i : options)
        {
            System.out.println(i);
        }

        while (selection.equals(""))
        {
            String input = scanner.nextLine();
            if (input.trim().matches(range))
            {
                selection = input.trim();
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
        System.out.println("Press Enter to go back");
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

    public void regSuccess()
    {
        System.out.println("\n" + "Registration Successful!" + "\n");
    }

    public void logSuccess()
    {
        System.out.println("\n" + "Login Successful!" + "\n");
    }

    public String updateFname()
    {
        Scanner scan = new Scanner(System.in);
        String fName = "";
        System.out.println("Enter your first name: ");
        while (fName.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateName(input.trim()) == true)
            {
                fName = input.trim();
            }
            else
            {
                System.out.println("Enter a valid name.");
            }
        }
        return fName;
    }

    public String updateLname()
    {
        Scanner scan = new Scanner(System.in);
        String lName = "";
        System.out.println("Enter your last name: ");
        while (lName.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateName(input.trim()) == true)
            {
                lName = input.trim();
            }
            else
            {
                System.out.println("Enter a valid name.");
            }
        }
        return lName;
    }

    public String updateAddress()
    {
        Scanner scan = new Scanner(System.in);
        String address = "";
        System.out.println("Enter your street name and number (e.g. 1 Monash Drive): ");
        while (address.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateAddress(input.trim()) == true)
            {
                address = input.trim();
            }
            else
            {
                System.out.println("Enter a valid address.");
            }
        }
        return address;
    }

    public String updateSuburb()
    {
        Scanner scan = new Scanner(System.in);
        String suburb = "";
        System.out.println("Enter your suburb: ");
        while (suburb.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateName(input.trim()) == true)
            {
                suburb = input.trim();
            }
            else
            {
                System.out.println("Enter a valid suburb.");
            }
        }
        return suburb;
    }

    public String updatePostcode()
    {
        Scanner scan = new Scanner(System.in);
        String pc = "";
        System.out.println("Enter your postcode: ");
        while (pc.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validatePostcode(input.trim()) == true)
            {
                pc = input.trim();
            }
            else
            {
                System.out.println("Enter a valid postcode.");
            }
        }
        return pc;
    }

    public String updateState()
    {
        Scanner scan = new Scanner(System.in);
        String state = "";
        System.out.println("Enter your state: ");
        while (state.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateState(input.trim()) == true)
            {
                state = input.trim();
            }
            else
            {
                System.out.println("Enter a valid state.");
            }
        }
        return state;
    }

    public String updateCardNumber()
    {
        Scanner scan = new Scanner(System.in);
        String cardno = "";
        System.out.println("Enter your card number: ");
        while (cardno.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateCardNumber(input.trim()) == true)
            {
                cardno = input.trim();
            }
            else
            {
                System.out.println("Enter a valid card number.");
            }
        }
        return cardno;
    }

    public String updateCardName()
    {
        Scanner scan = new Scanner(System.in);
        String cardname = "";
        System.out.println("Enter your full name as it appears on your card: ");
        while (cardname.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateCardName(input.trim()) == true)
            {
                cardname = input.trim();
            }
            else
            {
                System.out.println("Enter a valid name.");
            }
        }
        return cardname;
    }

    public String updateCCV()
    {
        Scanner scan = new Scanner(System.in);
        String ccv = "";
        System.out.println("Enter your CCV: ");
        while (ccv.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateCCV(input.trim()) == true)
            {
                ccv = input.trim();
            }
            else
            {
                System.out.println("Enter a valid CCV.");
            }
        }
        return ccv; 
    }

    public String updatePayPref()
    {
        Scanner scan = new Scanner(System.in);
        String paypref = "";
        System.out.println("To set your payment preference, enter 'c' for cash or 'b' for bank card: ");
        while (paypref.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().matches("[Cc]|[Bb]"))
            {
                paypref = input.trim();
            }
            else
            {
                System.out.println("Enter a valid selection.");
            }
        }
        return paypref;  
    }

    public String updateCollectionPref()
    {
        Scanner scan = new Scanner(System.in);
        String collpref = "";
        System.out.println("To set your order collection preference, enter 'p' for pick up or 'd' for delivery: ");
        while (collpref.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().matches("[Pp]|[Dd]"))
            {
                collpref = input.trim();
            }
            else
            {
                System.out.println("Enter a valid selection.");
            }
        }
        return collpref; 
    }

    public String unregister()
    {
        Scanner scan = new Scanner(System.in);
        String unregister = "";
        System.out.println("Are you sure you want to unregister? Enter 'y' for yes or 'n' for no.");
        while (unregister.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().matches("[Yy]|[Nn]"))
            {
                unregister = input.trim();
            }
            else
            {
                System.out.println("Enter a valid selection.");
            }
        }
        return unregister; 
    }

    public String prodNameInput()
    {
        Scanner scan = new Scanner(System.in);
        String prodName = "";
        System.out.println("Enter the product name: ");
        while (prodName.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateProdName(input.trim()) == true)
            {
                prodName = input.trim();
            }
            else
            {
                System.out.println("Enter a valid product name.");
            }
        }
        return prodName; 
    }

    public String minShelfLifeInput()
    {
        Scanner scan = new Scanner(System.in);
        String minShelf = "";
        System.out.println("Enter the product's minimum shelf life in days: ");
        while (minShelf.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateShelfLife(input.trim()) == true)
            {
                minShelf = input.trim();
            }
            else
            {
                System.out.println("Enter a valid product name.");
            }
        }
        return minShelf; 
    }

    public String maxShelfLifeInput()
    {
        Scanner scan = new Scanner(System.in);
        String maxShelf = "";
        System.out.println("Enter the product's maximum shelf life in days: ");
        while (maxShelf.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateShelfLife(input.trim()) == true)
            {
                maxShelf = input.trim();
            }
            else
            {
                System.out.println("Enter a valid product name.");
            }
        }
        return maxShelf; 
    }

    public String saleTypeInput()
    {
        Scanner scan = new Scanner(System.in);
        String saleType = "";
        System.out.println("Enter the product's sale type (e.g. 'kg', 'bag', 'box', 'punnet', 'peice', 'bundle', 'stalk'): ");
        while (saleType.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateSaleType(input.trim()) == true)
            {
                saleType = input.trim();
            }
            else
            {
                System.out.println("Enter a valid sale type.");
            }
        }
        return saleType; 
    }

    public String addSaleType()
    {
        Scanner scan = new Scanner(System.in);
        String response = "";
        System.out.println("Do you want to add an additional sale type? (enter 'y' for yes or 'n' for no): ");
        while (response.equals(""))
        {
            String input = scan.nextLine();
            //Pattern p = Pattern.compile("[Yy]|[Nn])");
            //Matcher m = p.matcher(input.trim());
            //if (m.find())
            if (input.trim().matches("[Yy]|[Nn]"))
            {
                response = input.trim();
            }
            else
            {
                System.out.println("Enter a valid response.");
            }
        }
        return response; 
    }

    public void addProductMsg()
    {
        System.out.println("\n" + "Product Added!" + "\n");
    }

    public String batchIDInput()
    {
        Scanner scan = new Scanner(System.in);
        String bid = "";
        System.out.println("Enter the ID of the product you want to purchase: ");
        while (bid.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().equals(""))
            {
                System.out.println("Enter a valid product ID.");
            }
            else
            {
                bid = input;
            }
        }
        return bid; 
    }

    public String prodQtyInput(int availQuant)
    {
        Scanner scan = new Scanner(System.in);
        String qty = "";
        int availQty = availQuant;
        System.out.println("Enter the quantity you want to purchase: ");

        while (qty.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateQty(input.trim()) == true && Integer.parseInt(input.trim()) <= availQty)
            {
                qty = input;
            }
            else
            {
                System.out.println("Enter a valid quantity.");
            }
        }
        return qty; 
    }

    public void purchMsg()
    {
        System.out.println("\n" + "Your selection has been added to your shopping cart." + "\n");
    }

    public void updateAccountMsg()
    {
        System.out.println("\n" + "You need to update your account details before you can check out!" + "\n");
    }

    public void confOrderDetailsMsg()
    {
        System.out.println("\n" + "These are your details associated with your order, now is your chance to go back and update anything if needed." + "\n");
        System.out.println("\n" + "You can update your account details by following the 'Account Details' menu item and you can update your order by following the 'Shopping Cart' menu item." + "\n");
    }

    public String checkOutConfirm()
    {
        Scanner scan = new Scanner(System.in);
        String response = "";
        System.out.println("Please confirm that your order and your personal details are correct (enter 'y' for yes or 'n' for no): ");
        while (response.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().matches("[Yy]|[Nn]"))
            {
                response = input.trim();
            }
            else
            {
                System.out.println("Enter a valid response.");
            }
        }
        return response; 
    }

    public void checkoutComplete()
    {
        System.out.println("Your order has been successfully placed and your payment detils routed to our payment provider for processing. Thank you come again! -MFV");  
    }

    public String getCurrentDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();  
        return formatter.format(date);
    }

    public String getEntredDate()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Date (format dd/mm/yyyy): ");
        String date = "";
        while(date.equals(""))
        {
            String input = scan.nextLine();  
            if (valid.validateDate(input.trim()) == true)
            {
                date = input.trim();
            }
            else
            {
                System.out.println("Enter Date (format dd/mm/yyyy):");
            }
        }  
        return date; 
    }
    
    public String cartUpdate()
    {
        Scanner scan = new Scanner(System.in);
        String pid = "";
        System.out.println("Enter the ID of the product whose quantity you wish to edit: ");
        while (pid.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().equals("") == false)
            {
                pid = input;
            }
            else
            {
                System.out.println("Enter a valid product ID.");
            }
        }
        return pid; 
    }
    
    public String cartRemove()
    {
        Scanner scan = new Scanner(System.in);
        String pid = "";
        System.out.println("Enter the ID of the product you want to remove from your cart: ");
        while (pid.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().equals("") == false)
            {
                pid = input;
            }
            else
            {
                System.out.println("Enter a valid product ID.");
            }
        }
        return pid; 
    }

    public void pidNotExistMsg()
    {
        System.out.println("That product ID doesn't exist in your cart, please try again.");
    }
    
    public String prodRmv()
    {
        Scanner scan = new Scanner(System.in);
        String response = "";
        System.out.println("Are you sure you want to delete this product? ('y' for yes or 'n' for no): ");
        while (response.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().matches("[Yy]|[Nn]"))
            {
                response = input;
            }
            else
            {
                System.out.println("Enter a valid option.");
            }
        }
        return response; 
    }
    
    public void pidDontExistMsg()
    {
        System.out.println("That product ID doesn't exist, please try again.");
    }
    
    public void msgCartUpdate()
    {
        System.out.println("Shopping Cart Updated!");
    }
    
    public void prodRmvMsg()
    {
        System.out.println("Product Removed!");
    }
    
    public String inpKeyWord()
    {
        Scanner scan = new Scanner(System.in);
        String key = "";
        System.out.println("Enter a key word you want to associate with this product: ");
        while (key.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateWord(input.trim()) == true)
            {
                key = input.trim();
            }
            else
            {
                System.out.println("Enter a valid word.");
            }
        }
        return key; 
    }
    
    public void keyWordMsg()
    {
        System.out.println("Key Word Added!");
    }
    
    public String selBatch()
    {
        Scanner scan = new Scanner(System.in);
        String bid = "";
        System.out.println("Enter the ID of the batch you want to select: ");
        while (bid.equals(""))
        {
            String input = scan.nextLine();
            if (input.trim().equals("") == false)
            {
                bid = input.trim();
            }
            else
            {
                System.out.println("Enter a valid batch ID.");
            }
        }
        return bid; 
    }
    
    public String selRecDate()
    {
        Scanner scan = new Scanner(System.in);
        String recDate = "";
        System.out.println("Enter the date you want to receive your order: ");
        while (recDate.equals(""))
        {
            String input = scan.nextLine();
            if (valid.validateReceiptDate(input) == true)
            {
                recDate = input.trim();
            }
            else
            {
                System.out.println("Enter a valid delivery date (i.e. at least one day from today): ");
            }
        }
        return recDate; 
    }
    
    public boolean valDelPostcode(String postcode)
    {
        return valid.validatePostcodeDelivery(postcode.trim());
    }
}
