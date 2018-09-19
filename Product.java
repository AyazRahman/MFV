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
    private int avgShelfLife; //shelf life always in days
    private List<Batch> batches;
    private String[] saleTypes;
    
    
    public Product()
    {
        productID = 0;
        name = "";
        avgShelfLife = 0; 
        batches = new ArrayList<Batch>();
        saleTypes = new String[2]; // from the data given there is a max of 2 different forms of salem methods
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
    
    public int getAvgShelfLife()
    {
        return avgShelfLife;
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
    
    public void setAvgShelfLife(int newAvgShelfLife)
    {
        avgShelfLife = newAvgShelfLife;
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
     * add the batch item to the end of the list of batches
     */
    public boolean addBatch(Batch item)
    {
        return batches.add(item);
    }
    
    /**
     * removes the batch item from the list if it exists
     */
    public boolean removeBatch(Batch item)
    {
        return batches.remove(item);
    }
    
    /**
     * removes the batch with the given batchID
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
     * 
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
}
