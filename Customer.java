import java.util.*;
/**
 * Write a description of class Customer here.
 *
 * @author Muhammad Hasan Qasim
 * @version 17/9/2018
 */
public class Customer extends User
{
    // instance variables - replace the example below with your own
    private ArrayList<String> orderArray;
    private String cardNumber;
    private String cardName;
    private String cardCCV;
    private boolean accountStatus;
    private String paymentPreference;
    private String collectionPreference;

    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        // initialise instance variables
        orderArray = new ArrayList<String>();
        cardNumber = "";
        cardName = "";
        cardCCV = "";
        accountStatus = false;
        paymentPreference = "";
        collectionPreference = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean getaccountStatus()
    {
        // put your code here
        return accountStatus;
    }
    
    public String getCardCCV()
    {
        // put your code here
        return cardCCV;
    }
    
    public String getCardName()
    {
        // put your code here
        return cardName;
    }
    
    public String getCardNumber()
    {
        // put your code here
        return cardNumber;
    }
    
    public String getCollectionPreference()
    {
        // put your code here
        return collectionPreference;
    }
    
    public ArrayList<String> getOrderArray()
    {
        // put your code here
        return orderArray;
    }
    
     public String getPaymentPreference()
    {
        // put your code here
        return paymentPreference;
    }
    
     public void setaccountStatus(boolean status)
    {
        // put your code here
        accountStatus = status;
    }
    
    public void setCardCCV(String ccv)
    {
        // put your code here
        cardCCV = ccv;
    }
    
    public void setCardName(String name)
    {
        // put your code here
        cardName = name;
    }
    
    public void setCardNumber(String number)
    {
        // put your code here
        cardNumber = number;
    }
    
    public void setCollectionPreference(String preference)
    {
        // put your code here
        collectionPreference = preference;
    }
    
    public void setOrderArray()
    {
        // put your code here
        ;
    }
    
     public void setPaymentPreference(String preference)
    {
        // put your code here
        paymentPreference = preference;
    }
}
