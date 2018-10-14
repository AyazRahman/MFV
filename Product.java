/**
 * Write a description of class Product here.
 * 
 * @author M Muhtasim Ayaz Rahman 
 * @version (a version number or a date)
 */
import java.util.List;
import java.util.ArrayList;

public class Product
{
    private int productID;
    private String name;
    private int minShelfLife;
    private int maxShelfLife;
    private List<Batch> batches;
    private String[] saleTypes;
    
    /**
     * Constructor for objects of class Product
     */
    public Product()
    {
        productID = 0;
        name = "";
        minShelfLife = 0; 
        maxShelfLife = 0;
        batches = new ArrayList<Batch>();
        saleTypes = new String[2]; // from the data given there is a max of 2 different forms of salem methods
    }
    
    /**
     * Constructor for objects of class Product
     */
    public Product(int newProductID, String newName, int newMinShelfLife, int newMaxShelfLife, String[] newSaleTypes)
    {
        productID = newProductID;
        name = newName;
        minShelfLife = newMinShelfLife;
        maxShelfLife = newMaxShelfLife;
        batches = new ArrayList<Batch>();
        saleTypes = newSaleTypes; // from the data given there is a max of 2 different forms of salem methods
    }

    //getters
    public int getProductID()
    {
        return productID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getMinShelfLife()
    {
        return minShelfLife;
    }
    
    public int getMaxShelfLife()
    {
        return maxShelfLife;
    }
    
    public List<Batch> getBatches()
    {
        return batches;
    }
    
    public String[] getSaleTypes()
    {
        return saleTypes; 
    }
    
    //setters
    public void setProductID(int newProductID)
    {
        productID = newProductID;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }
    
    public void setMinShelfLife(int newMinShelfLife)
    {
        minShelfLife = newMinShelfLife;
    }
    
    public void setMaxShelfLife(int newMaxShelfLife)
    {
        maxShelfLife = newMaxShelfLife;
    }
    
    public void setBatches(List<Batch> newBatches)
    {
        batches = newBatches;
    }
    
    public void setSaleTypes(String[] newSaleTypes)
    {
        saleTypes = newSaleTypes;
    }
    
    /**
    * This method is used to add the batch item to the end of the list of batches.
    * @param item This is the first paramter to addBatch method
    * @retrun boolean This return ture if item added.
    */
    public boolean addBatch(Batch item)
    {
        return batches.add(item);
    }
    
    /**
    * This method is used to add a new batch with all the given batch information.
    * @param batchID This is the first paramter to addBatch method
    * @param quantity This is the second paramter to addBatch method
    * @param dateReceived This is the third paramter to addBatch method
    * @param saleMethod This is the fourth paramter to addBatch method
    * @param price This is the fourth paramter to addBatch method
    * @param source This is the fourth paramter to addBatch method
    * @param name This is the fourth paramter to addBatch method
    * @retrun boolean This return ture if batch added.
    */
    public boolean addBatch(int batchID, int quantity, 
                            String dateReceived, String saleMethod, 
                            double price, String source, String name)
    {
        Batch item = new Batch(batchID, quantity, dateReceived, saleMethod, price, source, name);
        return batches.add(item);
    }
    
    /**
    * This method is used to remove a batch item from the list if it exists.
    * @param item This is the first paramter to removeBatch method
    * @return boolean This returns true if item is removed.
    */
    public boolean removeBatch(Batch item)
    {
        return batches.remove(item);
    }
    
    /**
    * This method is used remove a batch with the given batchID
    * @param batchID This is the first paramter to removeBatch method
    * @return boolean This returns true if item with given batchID is removed.
    */
    public boolean removeBatch(int batchID)
    {
        for (Batch b : batches)
        {
            if (b.getBatchID() == batchID)
            {
                return batches.remove(b);
            }
        }
        return false;
    }
    
    /**
    * This method is used get a batch with the given batchID
    * @param batchID This is the first paramter to getBatch method
    * @return Batch This return the batch with given batchID.
    */
    public Batch getBatch(int batchID)
    {
        for (Batch b : batches)
        {
            if (b.getBatchID() == batchID)
            {
                return b;
            }
        }
        return new Batch();
    }
    
    /**
    * This method is used returns the total quantity in the form of an array for all the different saleMethods
    * @return int[] This return the tatal quantity for different sales methods.
    */
    public int[] totalQty()
    {
        int[] amount = {0,0};
        
        for (Batch b : batches)
        {
            if (b.getSaleMethod() == saleTypes[0])
            {
                amount[0] += b.getQuantity();
            }
            else if(b.getSaleMethod() == saleTypes[1])
            {
                amount[1] += b.getQuantity();
            }
        }
        
        return amount;
        //remember some products have only sale type in that we only display amount[0]
    }
    
    /**
    * This method is used to covert variables to String and
    * add commas between each variable integers to be easly saved in csv file.
    * @return String This returns a string of all Product class variables.
    */
    public String toString()
    {
        return (productID + "," + name + "," +  minShelfLife + "," + maxShelfLife + "," + saleTypes[0] + "," + saleTypes[1] + ",");
    }
}
