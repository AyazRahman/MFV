import java.util.*;

/**
 * Write a description of class Order here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Order
{
    // instance variables - replace the example below with your own
    private boolean orderStatus;
    private String accID; //customer ID
    private ArrayList<String> lineItems; //replace String with lineItem class
    private double price;
    private String orderDate; //replace String with date class
    private String deliveryDate; //replace String with date class
    private boolean delivery; //to signal if order is delivery or pickup
    private String payMeth; //payment method
    
    /**
     * Constructor for objects of class Order
     */
    public Order()
    {
        orderStatus = false;
        accID = "";
        lineItems = new ArrayList<String>(); //replace String with lineItem class
        price = 0.00;
        orderDate = "";
        deliveryDate = "";
        delivery = false;
        payMeth = "";
    }

    /**
     * Alternative constructor to initiate an empty order but also assign it to a customer and date/time it.
     */
    public Order(String cusID, String ordDate)
    {
        accID = cusID;
        orderDate = ordDate;
    }
    
    /**
     * Hello World!
     */
    public void sampleMethod()
    {
        System.out.println("Hello World!");
    }
}
