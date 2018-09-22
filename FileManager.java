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

    /**
     * Constructor for objects of class FileManager
     */
    public FileManager()
    {
        products = new Hashtable<Integer, Product>();
        keywords = new HashMap<String, Integer>();
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
    
    //setters
    public void setProducts(Hashtable<Integer, Product> newProducts)
    {
        products = newProducts;
    }
    
    public void setKeywords(HashMap<String, Integer> newKeywords)
    {
        keywords = newKeywords;
    }
    
    /**
     * reads from the Products.csv file and creates all the products
     */
    public void createProducts()
    {
        String filename = ("Products.csv");
        
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine())
            {
                String [] productInfo = parser.nextLine().split(",");
                String[] saleTypes = {productInfo[3].trim(), productInfo[4].trim()};
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
    public void createBatches()
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
    
    public void loadDate()
    {
        createProducts();
        createBatches();
    }
}
