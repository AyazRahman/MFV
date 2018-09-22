/**
 * Write a description of class Batch here.
 * 
 * @author M Muhtasim Ayaz Rahman 
 * @version (a version number or a date)
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class Batch
{
    // instance variables - replace the example below with your own
    private int batchID;
    private int quantity;
    private Date dateReceived;
    private String saleMethod;
    private double price;
    private String source;
    private String name;

    /**
     * Constructor for objects of class Batch
     */
    public Batch()
    {
        // initialise instance variables
        batchID = 0;
        quantity = 0;
        dateReceived = new Date();
        saleMethod = "";
        price = 0.0;
        source = "";
        name = "";
    }
    
    public Batch(int newBatchID, int newQuantity, 
                 String newDateReceived, String newSaleMethod, 
                 double newPrice, String newSource, String newName)
    {
        batchID = newBatchID;
        quantity = newQuantity;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            dateReceived = format.parse(newDateReceived);
        }
        catch (Exception e)
        {
            System.out.println("Could not set date");
        }
        saleMethod = newSaleMethod;
        price = newPrice;
        source = newSource;
        name = newName;
    }

    // getters
    public int getBatchID()
    {
        return batchID;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public Date getDateReceived()
    {
        return dateReceived;
    }
    
    public String getSaleMethod()
    {
        return saleMethod;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public String getSource()
    {
        return source;
    }
    
    public String getName()
    {
        return name;
    }
    
    //setters
    public void setBatchID(int newBatchID)
    {
        batchID = newBatchID;
    }
    
    public void setQuantity(int newQuantity)
    {
        quantity = newQuantity;
    }
    
    public void setDateReceived(Date newDateReceived)
    {
        dateReceived = newDateReceived;
    }
    
    public void setSaleMethod(String newSaleMethod)
    {
        saleMethod = newSaleMethod;
    }
    
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }
    
    public void setSource(String newSource)
    {
        source = newSource;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }
    
    
}
