
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
    private Customer editAcc;
    private Order order;

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
                if (loggedUser instanceof Customer)
                {
                    editAcc = (Customer)u;
                    order.setAccID(Integer.toString(u.getUId()));
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
                    System.out.println("Call unregister method here");
                }

            }
            selection = ui.displayMenu(9);
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

    private void printOrder(Order o)
    {
        System.out.println("Total Order Price: " + o.getPrice() + "\tOrder Placed: " + o.getStringOrderDate());
        System.out.println("Order Items:");
        for (LineItem l : o.getLineItems())
        {
            System.out.println("Name: " + l.getItem() + "\tQuantity: " + l.getQuantity()+ "\tUnit Price: " + l.getUnitPrice() + "\tPrice: " + l.getPrice());
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

    private void exitProgram()
    {
        db.saveData();
        System.exit(0);
    }
}

