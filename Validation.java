import java.math.BigInteger;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
/**
 * Write a description of class Validation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validation
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Validation
     */
    public Validation()
    {
        // initialise instance variables
        x = 0;
    }

    public boolean validatePwd(String pwd)
    {
        if (pwd.length() >= 5)
        return true;
        else
        return false;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean validateName(String name)
    {
        for (char c : name.toCharArray()) {
            if (!Character.isAlphabetic(c)){
                System.out.println("INVALID");
                return false;
            }
        }
        
        if (name.length() < 2 || name.length() > 10)
            return false;
        return true;
    }
    
    public boolean validateCardNumber(String cardNumber)
    {
        cardNumber = cardNumber.replaceAll("\\s","");
        try 
        { 
            // checking valid integer using parseInt() method 
            new BigInteger(cardNumber); ; 
        }  
        catch (NumberFormatException e)  
        { 
            System.out.println(cardNumber + " is not a valid integer number"); 
            return false;
        }
        if (cardNumber.length() != 16)
                return false;
        return true;
    }
    
    public boolean validateEmail(String email)
    {
         String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }
    
}
