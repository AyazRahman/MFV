
/**
 * Write a description of class LineItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LineItem
{
    // instance variables - replace the example below with your own
    private String [] items;
    private int quantity;
    private double totalPrice;


    /**
     * Constructor for objects of class LineItem
     */
    public LineItem()
    {
        // initialise instance variables
        items = new String[0];
        quantity = 0;
        totalPrice = 0.00;
    }
    // initialise getters
    public String[] getItems()
    {
        return items; 
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
        public double getTotalPrice()
    {
        return totalPrice;
    }
    
    // initialise setters
        public void setItems(String[] newItems)
    {
        items = newItems;
    }
    
        public void setTotalPrice(double newTotalPrice)
    {
        totalPrice = newTotalPrice;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addToLineItem(String itemName, double price, int quantity)
    { 
        // still thinking about the logic here ..
    }
}
