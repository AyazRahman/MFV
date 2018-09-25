import java.io.*;
import java.util.*;
/**
 * Write a description of class FileManager here.
 * 
 * @author M Muhtasim Ayaz Rahman 
 * @version 21/09/2018
 */
public class FileManager
{
    // instance variables - replace the example below with your own
    private Hashtable<Integer, Product> products;
    private HashMap<String, Integer> keywords;
    private User loggedUser;
    private List<Customer> users;

    /**
     * Constructor for objects of class FileManager
     */
    public FileManager()
    {
        products = new Hashtable<Integer, Product>();
        keywords = new HashMap<String, Integer>();
        loggedUser = new User();
        users  = new ArrayList<Customer>();
    }

    //getters
    public Hashtable<Integer, Product> getProducts()
    {
        return products;
    }
    
    public HashMap<String, Integer> getKeywords()
    {
        return keywords;
    }
    
    public User getLoggedUser()
    {
        return loggedUser;
    }
    
    public List<Customer> getUsers()
    {
        return users;
    }
    
    //setters
    public void setProducts(Hashtable<Integer, Product> newProducts)
    {
        products = newProducts;
    }
    
    public void setKeywords(HashMap<String, Integer> newKeywords)
    {
        keywords = newKeywords;
    }
    
    public void setLoggedUser(User newUser)
    {
        loggedUser = newUser;
    }
    
    public void setUsers(List<Customer> newUsers)
    {
        users = newUsers;
    }
    
    /**
     * reads from the Products.csv file and creates all the products
     */
    private void createProducts()
    {
        String filename = ("Products.csv");
        
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine())
            {
                String [] productInfo = parser.nextLine().split(",");
                String[] saleTypes = {productInfo[3], productInfo[4]};
                int productID = Integer.parseInt(productInfo[0].trim()); 
                products.put(productID, new Product(productID, 
                                                    productInfo[1].trim(), 
                                                    Integer.parseInt(productInfo[2].trim()),
                                                    saleTypes));
            }
            inputFile.close();
        }

        catch(FileNotFoundException e)
        {
            System.out.println(filename + " not found");
        }

        catch(IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
    }
    
    /**
     * reads from Batches.csv files and creates and adds the products 
     */
    private void createBatches()
    {
        String filename = ("Batches.csv");
        
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine())
            {
                String [] batchInfo = parser.nextLine().split(",");
                
                int batchID = Integer.parseInt(batchInfo[0].trim()); 
                int productID = batchID/10000;
                Product p = products.get(productID);
                int quantity = Integer.parseInt(batchInfo[1].trim());
                String dateReceived = batchInfo[2].trim();
                String saleMethod =  batchInfo[3].trim();
                double price = Double.parseDouble(batchInfo[4].trim());
                String source = batchInfo[5].trim();
                String name = batchInfo[6].trim();
                
                p.addBatch(batchID, quantity, dateReceived, saleMethod, price, source, name);
                //add to dictionary if keyword doesnt exist
                if (!keywords.containsKey(name))
                {
                    keywords.put(name, productID);
                }
            }
            inputFile.close();
        }

        catch(FileNotFoundException e)
        {
            System.out.println(filename + " not found");
        }

        catch(IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
    }
    
    public void createUsers()
    {
        String filename = ("User.csv");
        
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            
            while (parser.hasNextLine())
            {
                String [] userInfo = parser.nextLine().split(",");
                
                Customer newCustomer = new Customer();
                
                newCustomer.setUId(Integer.parseInt(userInfo[0].trim())); 
                newCustomer.setFName(userInfo[1].trim());
                newCustomer.setLName(userInfo[2].trim());
                newCustomer.setAddress(userInfo[3].trim());
                newCustomer.setSuburb(userInfo[4].trim());
                newCustomer.setPostcode(Integer.parseInt(userInfo[5].trim()));
                newCustomer.setState(userInfo[6].trim());
                newCustomer.setEmail(userInfo[7].trim());
                newCustomer.setPassword(userInfo[8].trim());
                newCustomer.setCardNumber(userInfo[9].trim());
                newCustomer.setCardName(userInfo[10].trim());
                newCustomer.setCardCCV(userInfo[11].trim());
                newCustomer.setAccountStatus(Boolean.parseBoolean(userInfo[12].trim()));
                newCustomer.setPaymentPreference(userInfo[13].trim());
                newCustomer.setCollectionPreference(userInfo[14].trim());
                
                users.add(newCustomer);
                
            }
            inputFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(filename + " not found");
        }

        catch(IOException e)
        {
            System.out.println("Unexpected I/O error");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    /**
     * Loads data from the CSV files according to the type of entity
     */
    
    public void loadData()
    {
        createProducts();
        createBatches();
        createUsers();
    }
    
    /**
     * Sava data into the corresponding CSV files
     */
    public void saveData()
    {
        Product[] allProducts = products.values().toArray(new Product[0]);
        saveProducts(allProducts);
        saveBatches(allProducts);
        saveUsers();
    }
    
    /**
     * Saves all Products information into Products.csv file
     */
    private void saveProducts(Product[] allProducts)
    {
        String filename = ("Products.csv");
            try
            {
                PrintWriter outputFile = new PrintWriter(filename);
                for (Product p : allProducts)
                {
                    outputFile.println(p.toString());
                }
                outputFile.close();
            }
            catch (IOException e)
            {
                System.out.println("Unexpected I/O error");
            }
            catch (Exception e)
            {
                System.out.println("Something went wrong");
            }
            finally
            {
                System.out.println("Products saved");
            }
    }
    
    /**
     * Saves all Batch information into Batches.csv
     */
    private void saveBatches(Product[] allProducts)
    {
        String filename = ("Batches.csv");
            try
            {
                PrintWriter outputFile = new PrintWriter(filename);
                for (Product p : allProducts)
                {
                    for (Batch b : p.getBatches())
                    {
                        outputFile.println(b.toString());
                    }
                }
                outputFile.close();
            }
            catch (IOException e)
            {
                System.out.println("Unexpected I/O error");
            }
            catch (Exception e)
            {
                System.out.println("Something went wrong");
            }
            finally
            {
                System.out.println("Batches saved");
            }
    }
    
    public void saveUsers()
    {
        String filename = ("User.csv");
        
        try
            {
                PrintWriter outputFile = new PrintWriter(filename);
                for (Customer u : users)
                {
                    outputFile.println(u.toString());
                    System.out.println(u.toString());
                }
                outputFile.close();
            }
            catch (IOException e)
            {
                System.out.println("Unexpected I/O error");
            }
            catch (Exception e)
            {
                System.out.println("Something went wrong");
            }
            finally
            {
                System.out.println("Users saved");
            }
    }
    
    /**
     * Adds a new product to the hashtable
     */
    private boolean addProduct(int productID, String name, 
                               int avgShelfLife, String[] saleTypes)
    {
        int initialSize = products.size();
        products.put(productID, new Product(productID, name, avgShelfLife, saleTypes));
        return (products.size() == (initialSize + 1));
    }
    
    /**
     * Adds a batch to it relevant product
     */
    private boolean addBatch(int batchID, int quantity, String dateReceived, String saleMethod, 
                             double price, String source, String name)
    {
        int productID = batchID/10000;
        Product p = products.get(productID);
        int initialSize = p.getBatches().size();
        p.addBatch(batchID, quantity, dateReceived, saleMethod, price, source, name);
        if (!keywords.containsKey(name))
        {
            keywords.put(name, productID);
        }
        return (p.getBatches().size() == (initialSize + 1));
    }
    
    /**
     * Remove batch with its given ID
     */
    public boolean removeBatch(int batchID)
    {
        int productID = batchID/10000;
        Product p = products.get(productID);
        return p.removeBatch(batchID);
    }
}
