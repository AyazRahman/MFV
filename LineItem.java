 


/**
 * A unique instance of product-price-quantity detailing a specific line item e.g. on an invoice.
 *
 * @author Team118
 * @version v1.1.0
 */
public class LineItem
{
    private String name;
    private int qty;
    private double unitPrice;
    private double price;
    private String batchID;

    /**
     * Constructor for objects of class LineItem
     */
    public LineItem()
    {
        // initialise instance variables
        name = " ";
        qty = 0;
        unitPrice = 0.00;
        price = 0.00;
        batchID = " ";
    }
    
    /**
     * Alt. constructor for creating line items.
     */
    public LineItem(String name, int qty, double unitPrice, String batchID)
    {
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
        price = qty * unitPrice;
        this.batchID = batchID;
    }
    
    public void setItem(String name)
    {
        this.name = name;
    }
    
    public void setQuantity(int qty)
    {
        this.qty = qty;
    }
    
    public void setTotalPrice(double price)
    {
        this.price = price;
    }
    
    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }
    
    public String getItem()
    {
        return name; 
    }
    
    public int getQuantity()
    {
        return qty;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public double getUnitPrice()
    {
        return unitPrice;
    }
    
    public String getBatchID()
    {
        return batchID;
    }
    
    public String toString()
    {
        return name + "," + qty + "," + unitPrice + "," + price + "," + batchID;
    }
    
    public void setBatchID(String batchID)
    {
        this.batchID = batchID;
    }
}
