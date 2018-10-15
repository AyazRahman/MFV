import java.math.BigInteger; 
import java.util.*;
import java.util.regex.*;
import java.time.*;
import java.time.format.DateTimeFormatter;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
// java.time.LocalDate;  
/**
 * Write a description of class Validation here.
 *
 * @author Team118
 * @version 1.0
 */
public class Validation
{
    private ArrayList<String> postcodes;
    private ArrayList<String> states;
    private ArrayList<String> saleTypes;

    /**
     * Constructor for objects of class Validation
     */
    public Validation()
    {
        postcodes = new ArrayList<>(Arrays.asList("3122", "3142", "3143", "3144", "3145", "3146", "3161", "3162", "3163", "3166", "3181", "3182",
                                                  "3183", "3184", "3185", "3186", "3187", "3188", "3204"));
        states = new ArrayList<>(Arrays.asList("VIC", "Victoria", "NSW", "New South Wales", "QLD", "Queensland", "ACT", "Australian Capital Territory", 
                                               "SA", "South Australia", "NT", "Northern Territory", "TAS", "Tasmania", "WA", "Western Australia"));
        saleTypes = new ArrayList<>(Arrays.asList("kg", "bag", "box", "punnet", "piece", "bundle", "stalk"));                                       
    }
    
    /**
     * This method is used to validate entred password to be
     * more than 5 in length of string.
     * @param pwd This is the first paramter to validatePwd method.
     * @return boolean This returns true if password lenght is more than 4 .
     */
    public boolean validatePwd(String pwd)
    {
        if (pwd.length() >= 5)
        return true;
        else
        return false;
    }
    
    /**
     * This method is used to validate entred name.
     * @param name This is the first paramter to validateName method.
     * @return boolean This returns true if name length greater then 2 and less that 10.
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
    
    /**
     * This method is used to validate entred cartd number.
     * @param cardNumber This is the first paramter to validateCardNumber method.
     * @return boolean This returns true if entred number length is 16 digits.
     */
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
    
    /**
     * This method is used to validate entred email.
     * @param email This is the first paramter to validateEmail method.
     * @return boolean This returns true if entred email is valid.
     */
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
    
    /**
     * This method is used to validate entred address.
     * @param address This is the first paramter to validateAddress method.
     * @return boolean This returns true if entred address is valid.
     */
    public boolean validateAddress(String address)
    {
        String addressRegex = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
        Pattern pat = Pattern.compile(addressRegex);
        if (address.trim() == "")
        return false;
        else
        return address.matches(addressRegex);
    }
    
    /**
     * This method is used to validate entred post code.
     * @param pc This is the first paramter to validatePostcodeDelivery method.
     * @return boolean This returns true if entred post code is valid and with in the range of two suburbs.
     */
    public boolean validatePostcodeDelivery(String pc)
    {
        if (pc.trim() == "")
            return false;
        for (String s : postcodes) 
        {
            if (pc.equals(s))
            return true;
        }
        return false;
    }
    
    /**
     * This method is used to validate entred post code.
     * @param pc This is the first paramter to validatePostcodeDelivery method.
     * @return boolean This returns true if entred post code is met with regex for australian post codes.
     */
    public boolean validatePostcode(String pc)
    {
        String postcodes = "^(0[289][0-9]{2})|([1345689][0-9]{3})|(2[0-8][0-9]{2})|(290[0-9])|(291[0-4])|(7[0-4][0-9]{2})|(7[8-9][0-9]{2})$";
        if (pc.trim() == "")
            return false;
        else if (pc.matches(postcodes))
        {
            return true;
        }
        return false;
    }
    
    /**
     * This method is used to validate entred state.
     * @param state This is the first paramter to validateState method.
     * @return boolean This returns true if entred state is valid.
     */
    public boolean validateState(String state)
    {
        if (state.trim() == "")
            return false;
        for (String s : states)
        {
            if (state.trim().equalsIgnoreCase(s))
            return true;
        }
        return false;
    }
    
    /**
     * This method is used to validate entred name on card.
     * @param name This is the first paramter to validateCardName method.
     * @return boolean This returns true if entred card name is valid.
     */
    public boolean validateCardName(String name)
    {
        for (char c : name.toCharArray()) {
            if (!Character.isAlphabetic(c)){
                System.out.println("INVALID");
                return false;
            }
        }
        
        if (name.length() < 2 || name.length() > 25)
            return false;
        return true;
    }
    
    /**
     * This method is used to validate entred ccv on card.
     * @param ccv This is the first paramter to validateCCV method.
     * @return boolean This returns true if entred card name is from 3 to 4 digts.
     */
    public boolean validateCCV(String ccv)
    {
        String s = ccv.trim();
        String regex = "^[0-9]{3,4}$";
        if (s.trim() == "")
        return false;
        else 
        return s.matches(regex);
    }
    
    /**
     * This method is used to validate entred product name.
     * @param prodName This is the first paramter to validateProdName method.
     * @return boolean This returns true if entred product name is valid.
     */
    public boolean validateProdName(String prodName)
    {
        for (char c : prodName.toCharArray()) {
            if (!Character.isAlphabetic(c)){
                System.out.println("INVALID");
                return false;
            }
        }
        
        if (prodName.length() < 2 || prodName.length() > 20)
            return false;
        return true;
    }
    
    /**
     * This method is used to validate shelf life.
     * @param days This is the first paramter to validateShelfLife method.
     * @return boolean This returns true if entred shelf life is valid.
     */
    public boolean validateShelfLife(String days)
    {
        if (days.trim().matches("^[0-9]{1,3}$") && days.trim() != "0")
        {
            return true;
        }
        else
            return false;
    }
    
    /**
     * This method is used to validate sale type.
     * @param saleType This is the first paramter to validateSaleType method.
     * @return boolean This returns true if entred sale type is valid.
     */
    public boolean validateSaleType(String saleType)
    {
        if (saleType.trim() == "")
            return false;
        for (String s : saleTypes)
        {
            if (saleType.trim().equalsIgnoreCase(s))
            return true;
        }
        return false;
    }
    
    /**
     * This method is used to validate quantity.
     * @param qty This is the first paramter to validateQty method.
     * @return boolean This returns true if entred quantity is valid.
     */
    public boolean validateQty(String qty)
    {
        if (qty.trim().matches("^[0-9]{1,3}$") && qty.trim() != "0")
        {
            return true;
        }
        else
            return false;
    }
    
    /**
     * This method is used to validate the date entred for system report and
     * checking the formate to match dd/mm/yyyy and
     * prevent future dates.
     * @param entredDate This is the first paramter to validateDate method.
     * @return boolean This returns true if entred date is valid.
     */
    public static boolean validateDate(String entredDate)
    {
        String dateRegex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        Pattern p = Pattern.compile(dateRegex);
        Matcher m = p.matcher(entredDate);
      
        if (m.matches())
        {
            LocalDateTime today = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String todayString = today.format(formatter);
          
            LocalDate entredDateToDate = LocalDate.parse(entredDate,formatter);
            LocalDate todayStringToDate = LocalDate.parse(todayString,formatter);

            if (entredDateToDate.isBefore(todayStringToDate)) 
            {
                System.out.println("Date is valid ");
                return true;
            }
            if (entredDateToDate.isAfter(todayStringToDate)) 
            {
                System.out.println("Future date not acceptable");
                return false;
            }
            if (entredDateToDate.isEqual(todayStringToDate)) 
            {
                System.out.println("Date should not be current date, select past date please");
                return false;
            }
            else
            System.out.println("Date is not valid  ");
            return false;
        }
        System.out.println("Date format is not valid");
        return false;
    }
    
    /**
     * This method is used to validate entred word
     * @param word This is the first paramter to validateWord method.
     * @return boolean This returns true if entred word is valid.
     */
    public boolean validateWord(String word)
    {
        for (char c : word.toCharArray()) {
            if (!Character.isAlphabetic(c)){
                System.out.println("INVALID");
                return false;
            }
        }
        
        if (word.length() < 2 || word.length() > 20)
            return false;
        return true;
    }
    
    /**
     * This method is used to validate the receipt date
     * checking the formate to match dd/mm/yyyy and
     * prevent past dates.
     * @param receiptDate This is the first paramter to validateReceiptDate method.
     * @return boolean This returns true if entred receipt date is valid.
     */
    public boolean validateReceiptDate(String receiptDate)
    {
        String dateRegex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        Pattern p = Pattern.compile(dateRegex);
        Matcher m = p.matcher(receiptDate);
      
        if (m.matches())
        {
            LocalDateTime today = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String todayString = today.format(formatter);
          
            LocalDate entredDateToDate = LocalDate.parse(receiptDate,formatter);
            LocalDate todayStringToDate = LocalDate.parse(todayString,formatter);

            if (entredDateToDate.isBefore(todayStringToDate)) 
            {
                return false;
            }
            if (entredDateToDate.isAfter(todayStringToDate)) 
            {
                return true;
            }
            if (entredDateToDate.isEqual(todayStringToDate)) 
            {
                return false;
            }
            else
            return false;
        }
        return false;
    }
    
    /**
     * This method is used to validate a string number
     * @param string This is the first paramter to valNum method.
     * @return boolean This returns true if entred word is valid.
     */
    public boolean valNum(String string)
    {
        return string.matches("[0-9]+");
    }
}
