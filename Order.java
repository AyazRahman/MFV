 import java.util.*;
 import java.text.SimpleDateFormat;

/**
 * Enity class Order stores order information.
 *
 * @author Team118
 * @version 1.10
 */
public class Order
{
    // instance variables - replace the example below with your own
    private boolean orderStatus;
    private String accID; //customer ID
    private ArrayList<LineItem> lineItems;
    private double price;
    private Date orderDate; //replace String with date class
    private Date deliveryDate; //replace String with date class
    private boolean delivery; //to signal if order is delivery or pickup
    private String payMeth; //payment method
    
    /**
     * Constructor for objects of class Order
     */
    public Order()
    {
        orderStatus = false;
        accID = " ";
        lineItems = new ArrayList<LineItem>();
        price = 0.00;
        orderDate = new Date();
        deliveryDate = new Date();
        delivery = false;
        payMeth = " ";
    }

    /**
     * Alternative constructor to initiate an empty order but also assign it to a customer and date/time it.
     */
    public Order(String cusID, Date ordDate)
    {
        accID = cusID;
        orderDate = ordDate;
    }
    
    /**
     * Add line items to order.
     */
    public void addLineItem(LineItem line)
    {
        lineItems.add(line);
    }
    
    public void addLineItem(String name, int qty, double unitPrice, String batchID)
    {
        lineItems.add(new LineItem(name, qty, unitPrice, batchID));
    }
    
    /**
     * Get the customer account ID associated with the order.
     */
    public String getAccID()
    {
        return accID;
    }
    
    /**
     * Get the date the order is to be delivered. 
     */
    public Date getDeliveryDate()
    {
        return deliveryDate;
    }
    
     /**
     * Get line item collection.
     */
    public ArrayList getLineItems()
    {
        return lineItems;
    }
    
    /**
     * Get the date & time the order was placed.
     */
    public Date getOrderDate()
    {
        return orderDate;
    }
    
    /**
     * Get the order receipt method.
     */
    public boolean getOrderReceiptMethod()
    {
        return delivery;
    }
    
    /**
     * Get order status.
     */
    public boolean getOrderStatus()
    {
        return orderStatus;
    }
    
    /**
     * Get order payment method.
     */
    public String getPaymentMethod()
    {
        return payMeth;
    }
    
    /**
     * Get order price.
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * Set the customer account ID associated with the order.
     */
    public void setAccID(String id)
    {
        accID = id;
    }
    
    /**
     * 
     */
    public void setDelivery(boolean newDelivery)
    {
        delivery = newDelivery;
    }
    
    /**
     * Set the date the order is to be delivered.
     */
    public void setDeliveryDate(Date delDate)
    {
        deliveryDate = delDate;
    }
    
    public void setDeliveryDate(String date)
    {
        deliveryDate = stringToDate(date);
    }
    
    /**
     * Set line item collection.
     */
    public void setLineItems(ArrayList<LineItem> lineItemz)
    {
        lineItems = lineItemz;
    }
    
     /**
     * Set the date and time the order was placed.
     */
    public void setOrderDate(Date ordDate)
    {
        orderDate = ordDate;
    }
    
    public void setOrderDate(String date)
    {
        orderDate = stringToDate(date);
    }
    
    private Date stringToDate(String date)
    {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            d = format.parse(date);
        }
        catch (Exception e)
        {
            System.out.println("Could not set date");
        }
        return d;
    }
    
    /**
     * Set the order receipt method.
     */
    public void setOrderReceiptMethod(boolean recMeth)
    {
        delivery = recMeth;
    }
    
    /**
     * Set order status.
     */
    public void setOrderStatus(boolean orderStat)
    {
        orderStatus = orderStat;
    }
    
    /**
     * Set order payment method.
     */
    public void setPaymentMethod(String payMethod)
    {
        payMeth = payMethod;
    }
    
    /**
     * Set order price.
     */
    public void setPrice(double p)
    {
        price = p;
    }
    
    public String[] toStringArray()
    {
        String[] s = new String[lineItems.size() + 3];
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        s[0] = orderStatus + "," + accID  + "," + price + "," + format.format(orderDate) 
               + "," + format.format(deliveryDate) + "," + delivery + "," + payMeth;
        s[1] = "--Start--";
        int i = 2;
        for (LineItem l: lineItems)
        {
            s[i] = l.toString();
            i++;
        }
        s[s.length - 1] = "--End--";
        return s;
    }
}

