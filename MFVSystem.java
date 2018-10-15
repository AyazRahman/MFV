import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * MFVSystem class is a controller class that controlles all the logic for .
 *
 * @author Team118
 * @version 1.0
 */

public class MFVSystem
{
    private static Scanner scan;
    private static String option;
    private FileManager db;
    private UserInterface ui;
    private User loggedUser;
    private Customer editAcc;
    private Order order;

    /**
    * Constructor for objects of class Menu
    */
    public MFVSystem()
    {
        db = new FileManager();
        db.loadData();
        ui = new UserInterface();
        ui.loadMenuItems();
        loggedUser = new User();
        editAcc = new Customer();
        order = new Order();
    }

    /**
    * This method is displied when system started
    */
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

    /**
    * This method is showed when user selects login and
    * it checks if the the entred info met with existing user info and 
    * checks if the user account status is enabled in FIleManager class then
    * send the user to the right methods to UserInterface class and User class 
    */
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
                if (loggedUser instanceof Customer)
                {
                    editAcc = (Customer)u;
                    if (editAcc.getaccountStatus())
                    {
                        order.setAccID(Integer.toString(u.getUId()));
                    }
                    else
                    {
                        System.out.println("The Account is disabled");
                        break;
                    }
                }
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

    /**
    * This method is showed when a User selects Rigister and
    * it checks if the the entred user info is exist with FileManager class and 
    * save account info if not exists then 
    * send the user to the right methods such as UserInterface class and User class 
    */
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

    /**
    * This method is showed when the Admin selects Add Product and
    * it checks if the the entred info met with the conditions with the right method in UserInterface then
    * save Product info if not exists then 
    * send the Admin to the methods from UserInterface class and User class 
    */
    private void addProduct()
    {
        String productName = ui.prodNameInput();
        int minShelfLife = Integer.parseInt(ui.minShelfLifeInput());
        int maxShelfLife = Integer.parseInt(ui.maxShelfLifeInput());
        String saleType1 = ui.saleTypeInput(); //Run this multiple times to get multiple sale types
        String saleType2 = " ";
        if (ui.addSaleType().matches("[Yy]")) //Prompts user if he wants to add additional sale type, only returns y or n
        {
            saleType2 = ui.saleTypeInput();
        }
        String[] saleTypes = {saleType1, saleType2};
        int pId = 100 + db.getProducts().size();
        if(db.addProduct(pId, productName, minShelfLife, maxShelfLife, saleTypes))
        {
            ui.addProductMsg(); //Success message when product is added
        }
        else
        {
            System.out.println("Failed to add product. Something went wrong");
        }
    }

    /**
    * This method is showed when the Customer selects Update Account and
    * it checks if the the entred info met with the conditions with the right method in UserInterface then
    * save Accouotn info then
    * send the Customer to the methods from UserInterface class and User class 
    */
    private void updateAccount()
    {
        String selection = ui.displayMenu(9);

        while (!selection.matches("[Oo]"))
        {
            if (selection.matches("[Aa]"))
            {
                loggedUser.setFName(ui.updateFname());
                ui.updateMsg("First Name"); //Success message when detail is updated/set
            }
            else if (selection.matches("[Bb]"))
            {
                loggedUser.setLName(ui.updateLname());
                ui.updateMsg("Last Name");
            }
            else if (selection.matches("[Cc]"))
            {
                loggedUser.setAddress(ui.updateAddress());
                ui.updateMsg("Address");
            }
            else if (selection.matches("[Dd]"))
            {
                loggedUser.setSuburb(ui.updateSuburb());
                ui.updateMsg("Suburb");
            }
            else if (selection.matches("[Ee]"))
            {
                loggedUser.setPostcode(Integer.parseInt(ui.updatePostcode()));
                ui.updateMsg("Postcode");
            }
            else if (selection.matches("[Ff]"))
            {
                loggedUser.setState(ui.updateState());
                ui.updateMsg("State");
            }
            else if (selection.matches("[Gg]"))
            {
                loggedUser.setEmail(ui.emailInput());
                ui.updateMsg("Email Address");
            }
            else if (selection.matches("[Hh]"))
            {
                loggedUser.setState(ui.pwdInput());
                ui.updateMsg("Password");
            }
            else if (selection.matches("[Ii]"))
            {
                editAcc.setCardNumber(ui.updateCardNumber());
                ui.updateMsg("Bank Card");
            }
            else if (selection.matches("[Jj]"))
            {
                editAcc.setCardName(ui.updateCardName());
                ui.updateMsg("Bank Card Name");
            }
            else if (selection.matches("[Kk]"))
            {
                editAcc.setCardCCV(ui.updateCCV());
                ui.updateMsg("Bank Card CCV");
            }
            else if (selection.matches("[Ll]"))
            {
                editAcc.setPaymentPreference(ui.updatePayPref());
                ui.updateMsg("Payment Preference");
            }
            else if (selection.matches("[Mm]"))
            {
                editAcc.setCollectionPreference(ui.updateCollectionPref());
                ui.updateMsg("Collection Preference");
            }
            else if (selection.matches("[Nn]"))
            {
                String choice = ui.unregister();
                if (choice.matches("[Yy]"))
                {
                    //System TODO
                    editAcc.setAccountStatus(false);
                    System.out.println("Your account has been unregistered");
                    selection = "O";
                    continue;
                }

            }
            selection = ui.displayMenu(9);
        }

    }

    /**
    * This method is the Customer Menu showed when the Customer logged successfully and
    * display all cresponding customer menues and enteractios with the right method in UserInterface then
    * save Accouotn info in FileManager class then
    * send the Customer to the methods from UserInterface class and User class 
    * it finishes when if the Customer logged off or exit
    */
    //TODO: change the method to private after testing
    private void userMenu()
    {
        if (loggedUser instanceof Customer)
        {
            //call Customer menu
            String selection = ui.displayMenu(2);
            while (!selection.matches("[Ff]") && !selection.matches("[Gg]") /*&& !editAcc.getaccountStatus()*/)
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
                        s = ui.displayMenu(4);
                    }
                }
                else if (selection.matches("[Bb]"))
                {
                    //shopping cart
                    if (order.getLineItems().isEmpty())
                    {
                        System.out.println("Your cart is empty");
                    }
                    else
                    {
                        String input = ui.displayMenu(15);
                        while (!input.matches("[Cc]"))
                        {
                            if (input.matches("[Aa]"))
                            {
                                //edit order quantity
                                String lineId = ui.cartUpdate();
                                LineItem lineSelected = new LineItem();

                                for (LineItem l : order.getLineItems())
                                {
                                    if (l.getBatchID().equals(lineId))
                                    {
                                        lineSelected = l;
                                        break;
                                    }
                                }
                                if (lineSelected.getBatchID().equals(" "))
                                {
                                    ui.pidNotExistMsg(); 
                                }
                                else
                                {
                                    int lid = Integer.parseInt(lineId);
                                    Batch editBatch = db.getProducts().get(lid/10000).getBatch(lid);
                                    int newQty = Integer.parseInt(ui.prodQtyInput(editBatch.getQuantity() + lineSelected.getQuantity()));
                                    editBatch.setQuantity(editBatch.getQuantity() + lineSelected.getQuantity() - newQty);
                                    lineSelected.setQuantity(newQty);
                                    ui.msgCartUpdate();
                                }
                            }
                            else if (input.matches("[Bb]"))
                            {
                                //remove Item from order
                                String lineId = ui.cartUpdate();
                                LineItem lineSelected = new LineItem();

                                for (LineItem l : order.getLineItems())
                                {
                                    if (l.getBatchID().equals(lineId))
                                    {
                                        lineSelected = l;
                                        break;
                                    }
                                }
                                if (lineSelected.getBatchID().equals(" "))
                                {
                                    ui.pidNotExistMsg(); 
                                }
                                else
                                {
                                    int lid = Integer.parseInt(lineId);
                                    int qty = lineSelected.getQuantity();
                                    Batch editBatch = db.getProducts().get(lid/10000).getBatch(lid);
                                    editBatch.setQuantity(editBatch.getQuantity() + qty);
                                    order.getLineItems().remove(lineSelected);
                                    ui.msgCartUpdate();
                                }
                            }
                        }
                    }
                }
                else if (selection.matches("[Cc]"))
                {
                    //checkout
                    if (editAcc.updateAcc())
                    {
                        ui.updateAccountMsg();
                    }
                    else if (order.getLineItems().size() == 0)
                    {
                        System.out.println("There are no items in your order.");
                    }
                    else if (editAcc.getCollectionPreference().equals("Delivery"))
                    {
                        if (ui.valDelPostCode(""+editAcc.getPostcode()))
                        {
                            //TODO: check postcode for Order delivery option
                            ui.confOrderDetailsMsg();
                            System.out.println("Account Details:");
                            System.out.println("Card Name: " + editAcc.getCardName());
                            System.out.println("Card Number:" + editAcc.getCardName() + "\tCard CCV:" + editAcc.getCardCCV());
                            System.out.println("Payment Preference: " + editAcc.getPaymentPreference() + "\tCollection Preference: " + editAcc.getCollectionPreference());
                            System.out.println("Order Details:");
                            printOrder(order);
                            if (ui.checkOutConfirm().matches("[Yy]"))
                            {
                                //set delivery date
                                db.getOrders().add(order);
                                order = new Order();
                                ui.checkoutComplete();
                            }
                            else
                            {
                                System.out.println("Cannot deliver to the postcode. Please change delivery preference or postcode");
                            }
                        }

                    }
                }
                else if (selection.matches("[Dd]"))
                {
                    //order history
                    // List<Order> allOrder = new ArrayList();
                    for (Order o : db.getOrders())
                    {
                        if (o.getAccID().equals("" + editAcc.getUId()))
                        {
                            printOrder(o);
                        }
                    }
                }
                else if (selection.matches("[Ee]"))
                {
                    updateAccount();

                }

                selection = ui.displayMenu(2);
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
            while (!selection.matches("[Ee]") && !selection.matches("[Ff]"))
            {
                if (selection.matches("[Aa]"))
                {
                    productManagement();
                }
                else if (selection.matches("[Bb]"))
                {
                    orderMenu();
                }
                else if (selection.matches("[Cc]"))
                {
                    //TODO:UI Account Edit form
                    removeAcc();
                }
                else if (selection.matches("[Dd]"))
                {
                    //TODO:UI System Report form
                    systemReport();
                }
                selection = ui.displayMenu(3);
            }
            if (selection.matches("[Ee]"))
            {
                loggedUser = new User();
            }
            else if (selection.matches("[Ff]"))
            {
                exitProgram();
            }
        }
    }

    private void removeAcc()
    {
        HashMap<Integer, Customer> allCustomer = new HashMap<Integer, Customer>();

        for (User u : db.getUsers())
        {
            if ((u instanceof Customer))
            {
                Customer c = (Customer)u;
                if (c.getaccountStatus())
                {
                    allCustomer.put(u.getUId(), (Customer)u);
                    displayAcc(u);
                }
            }
        }
        System.out.println("Press Enter to go back");
        System.out.println("Enter the Id of the customer to disable: ");
        String accInput = ui.accNum();
        if (ui.checkNumericString(accInput))
        {
            int accNum = Integer.parseInt(accInput);
            if (allCustomer.containsKey(accNum))
            {
                allCustomer.get(accNum).setAccountStatus(false);
            }
        }
    }

    private void displayAcc(User u)
    {

        System.out.println("Account ID: " + u.getUId() + "\tName: " +u.getFName() + " " + u.getLName() +"\tEmail: " + u.getEmail());

    }

    private void printOrder(Order o)
    {
        System.out.println("Total Order Price: " + o.getPrice() + "\tOrder Placed: " + o.getStringOrderDate());
        System.out.println("Order Items:");
        for (LineItem l : o.getLineItems())
        {
            System.out.println("Name: " + l.getItem() + "\tQuantity: " + l.getQuantity()+ "\tUnit Price: " + l.getUnitPrice() + "\tPrice: " + l.getPrice());
        }
        System.out.println("");
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

                addProduct();
            }
            selection = ui.displayMenu(6);
        }
    }

    private void browse()
    {
        String id = ui.displayAllProduct(db.getProductArray());
        if (id.equals(""))
        {
            return ;
        }
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

    private void productMenu(Product p)
    {
        if (loggedUser instanceof Customer)
        {
            //call customer product menu
            String selection = ui.displayMenu(7);
            while (!selection.matches("[Bb]"))
            {
                selectProduct(p);
                selection = ui.displayMenu(7);
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
                    editProduct(p);
                }
                else if (selection.matches("[Bb]"))
                {
                    String confirm = ui.prodRmv();
                    if (confirm.matches("[Yy]"))
                    {
                        db.getProducts().remove(p.getProductID());
                        selection = "F";
                        continue;
                    }
                }
                else if (selection.matches("[Cc]"))
                {
                    //TODO:UI Add batch form and  System sequence
                    addBatch(p);
                }
                else if (selection.matches("[Dd]"))
                {
                    //TODO:UI View Batches
                }
                else if (selection.matches("[Ee]"))
                {
                    //TODO:UI Add keyword
                    String keyword = ui.inpKeyWord().toLowerCase();
                    if(db.getKeywords().containsKey(keyword))
                    {
                        System.out.println("Keyword already exists");
                    }
                    else
                    {
                        db.getKeywords().put(keyword, p.getProductID());
                        ui.keyWordMsg();
                    }
                }
                //  confusion for rest of the options
                selection = ui.displayMenu(8);
            }
        }
    }

    private void selectProduct(Product p)
    {
        System.out.println("Selected Product: ");
        System.out.println("Product Id: " + p.getProductID() + "\tProduct Name: " + p.getName());
        System.out.println("Batch list:");
        List<Integer> bId = new LinkedList();

        //TODO: purchase product sequence and logic for customer
        //TODO: UI need options for purchasing a batch
        for (Batch b : p.getBatches())
        {
            bId.add(b.getBatchID()%10000);
            displayBatch(b);
        }
        int input = Integer.parseInt(ui.batchIDInput().trim());
        if (bId.contains(input))
        {
            Batch selBatch = new Batch();
            for (Batch b : p.getBatches())
            {
                if (b.getBatchID() == (input + p.getProductID()*10000))
                {
                    selBatch = b;
                    break;
                }
            }
            if (selBatch.getName().equals(" "))
            {
                System.out.println("Wrong Id entered");
            }
            else
            {
                int qty = Integer.parseInt(ui.prodQtyInput(selBatch.getQuantity()));
                order.addLineItem(selBatch.getName(), qty, 
                    selBatch.getPrice(), "" + selBatch.getBatchID());
                selBatch.setQuantity(selBatch.getQuantity() - qty);
                ui.purchMsg();
            }
        }
        else
        {
            System.out.println("Not a Valid ID");
        }

    }

    private void displayBatch(Batch b)
    {
        System.out.println("Batch ID: " + b.getBatchID()%10000 + "\tName: " + b.getName() + "\tQuantity: " + b.getQuantity() 
            + "\t Price: " + b.getPrice() + "\tSource: " + b.getSource());
    }

    private void editProduct(Product p)
    {
        ui.displayProduct(p);
        String input = ui.displayMenu(10);
        while (!input.matches("[Ee]"))
        {
            if (input.matches("[Aa]"))
            {
                System.out.println("Current Name: " + p.getName());
                p.setName(ui.prodNameInput());
            }
            else if (input.matches("[Bb]"))
            {
                //min shelf life
                System.out.println("Current Min Shelf Life: " + p.getMinShelfLife());
                p.setMinShelfLife(Integer.parseInt(ui.minShelfLifeInput()));
            }
            else if (input.matches("[Cc]"))
            {
                //max shelf life
                System.out.println("Current Max Shelf Life: " + p.getMaxShelfLife());
                p.setMaxShelfLife(Integer.parseInt(ui.maxShelfLifeInput()));
            }
            else if (input.matches("[Dd]"))
            {
                //sale types
                System.out.println("Current Sale Types: " + p.getSaleTypes()[0] + ", " + p.getSaleTypes()[0]);
                String saleType1 = ui.saleTypeInput();
                if (ui.addSaleType().matches("[Yy]"))
                {
                    String saleType2 = ui.saleTypeInput();
                    String[] saleTypes = {saleType1, saleType2};
                    p.setSaleTypes(saleTypes);
                }
                else
                {
                    String[] saleTypes = {saleType1, " "};
                    p.setSaleTypes(saleTypes);
                }
            }
            ui.displayProduct(p);
            input = ui.displayMenu(10);
        }
    }

    private void orderMenu()
    {
        //TODO: need form for Order Management
        String select = ui.displayMenu(16);
        while (!select.matches("[Bb]"))
        {
            if (select.matches("[Aa]"))
            {
                for (Order o : db.getOrders())
                {
                    printOrder(o);
                }
            }
            select = ui.displayMenu(16);
        }
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

            productMenu(result);
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

        productMenu(p);
    }

    //14
    private void systemReport()
    {
        String selection  = ui.displayMenu(14);
        while (!selection.matches("[Cc]"))
        {
            if (selection.matches("[Aa]"))
            {
                reportOrders(ui.getCurrentDate());
            }
            else if (selection.matches("[Bb]"))
            {
                reportOrders(ui.getEntredDate());
            }
            selection = ui.displayMenu(14);
        }
    }

    private void reportOrders(String input)
    {
        List<Order> orders = new ArrayList<Order>();
        int num = 0;
        double totalPrice = 0.00;

        System.out.println("Date Selected is:" + input);
        for (Order o : db.getOrders())
        {
            if (o.checkDate(input))
            {
                orders.add(o);
                num++;
                totalPrice += o.getPrice();
            }
        }
        if (num != 0)
        {
            System.out.println("Total Price: " + totalPrice + "\tNumber of Orders: " + num);
            for (Order o : orders)
            {
                printOrder(o);
            }
        }
        else
        {
            System.out.println("No orders to show for the given date");
        }
    }
    // MFV hasan latest changes 1
    private void addBatch(Product p)
    {
        int bId = 1 + p.getBatches().get(p.getBatches().size() - 1).getBatchID();
        String name = ui.addBatchName();
        String dateRecieved = ui.addBatchRecievedDate();
        String[] saleTypes = p.getSaleTypes();
        int saleMethod = ui.addBatchSaleMethod(saleTypes[0], saleTypes[1]);
        double price = ui.addBatchPrice();
        int quantity = ui.addBatchQuantity();
        String source = ui.addBatchSource();
        p.addBatch(bId, quantity, dateRecieved, saleTypes[saleMethod - 1], price, source, name);
    }
    // MFV hasan latest changes 2
     private void editBatch(Batch b, Product p)
    {
        ui.displayBatch(b);
        String input = ui.displayMenu(13);
        while (!input.matches("[Ff]"))
        {
            if (input.matches("[Aa]"))
            {
                // quantity
                System.out.println("Current Quantity: " + b.getQuantity());
                b.setQuantity(ui.addBatchQuantity());
            }
            else if (input.matches("[Bb]"))
            {
                // sale method
                System.out.println("Current Sale Method: " + b.getSaleMethod());
                String[] saleTypes = p.getSaleTypes();
                int saleMethod = ui.addBatchSaleMethod(saleTypes[0], saleTypes[1]);
                b.setSaleMethod(saleTypes[saleMethod-1]);
            }
            else if (input.matches("[Cc]"))
            {
                // price
                System.out.println("Current Price: " + b.getPrice());
                b.setPrice((ui.addBatchPrice()));
            }
            else if (input.matches("[Dd]"))
            {
                // source
                System.out.println("Current Source: " + b.getSource());
                b.setSource(ui.addBatchSource());
            }
            else if (input.matches("[Ee]"))
            {
                //name
                System.out.println("Current name: " + b.getName());
                b.setName((ui.addBatchName()));
            }
            ui.displayBatch(b);
            input = ui.displayMenu(13);
        }
    }
   // MFV hasan latest changes 3
    private void BatchMenu(Batch b, Product p)
    {
        String selection = ui.displayMenu(12);
        while (!selection.matches("[Cc]"))
        {
             if (selection.matches("[Aa]"))
             {
                    editBatch(b, p);
             }
             else if (selection.matches("[Bb]"))
             {
                    p.removeBatch(b);
                    selection = "C";
                    continue;
             }
              selection = ui.displayMenu(12);
        }
    }
    
    private void exitProgram()
    {
        db.saveData();
        System.exit(0);
    }
}

