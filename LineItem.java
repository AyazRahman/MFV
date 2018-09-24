 


/**
 * Write a description of class LineItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LineItem
{
    // instance variables - replace the example below with your own
    private String item;
    private int totalQuantity;
    private double totalPrice;


    /**
     * Constructor for objects of class LineItem
     */
    public LineItem()
    {
        // initialise instance variables
        item = "initialValue";
        totalQuantity = 0;
        totalPrice = 0.00;
    }
    
    // initialise setters methods
        public void setItem(String newItem)
    {
        item = newItem;
    }
    
    public void setQuantity(int newQuantity)
    {
        totalQuantity = newQuantity;
    }
    
        public void setTotalPrice(double newTotalPrice)
    {
        totalPrice = newTotalPrice;
    }

    // initialise getters methods
    public String getItem()
    {
        return item; 
    }
    
    public int getQuantity()
    {
        return totalQuantity;
    }
    
    public double getTotalPrice()
    {
        return totalPrice;
    }
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addToLineItem(String itemName, int quantity, double price)
    { 
        // still thinking about the logic here ..
        item = itemName;
        totalQuantity = quantity;
        totalPrice = price;
    }
}
