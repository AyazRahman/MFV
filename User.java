
/**
 * Write a description of class User here.
 *
 * @author Muhammad Hasan
 * @version 16/9/18
 */
public class User
{
    // instance variables - replace the example below with your own
    private int uId;
    private String fName;
    private String lName;
    private String address;
    private String suburb;
    private int postcode;
    private String state;
    private String email;
    private String password;
    
    /**
     * Constructor for objects of class User
     */
    public User()
    {   
        // initialise instance variables
        uId = 0;
        fName = "";
        lName = "";
        address = "";
        suburb = "";
        postcode = 0;
        state = "";
        email = "";
        password = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getAddress()
    {
        // put your code here
        return address;
    }
    
    public String getEmail()
    {
        // put your code here
        return email;
    }
    
    public String getFName()
    {
        // put your code here
        return fName;
    }
    
    public String getLName()
    {
        // put your code here
        return lName;
    }
    
    public String getPassword()
    {
        // put your code here
        return password;
    }
    
    public int getPostcode()
    {
        // put your code here
        return postcode;
    }
    
    public String getSuburb()
    {
        // put your code here
        return suburb;
    }
    
    public String getState()
    {
        // put your code here
        return state;
    }
    
    public int getUId()
    {
        // put your code here
        return uId;
    }

    public void setAddress(String address)
    {
        // put your code here
        this.address = address;
    }
    
    public void setEmail(String email)
    {
        // put your code here
        this.email = email;
    }
    
    public void setFName(String fName)
    {
        // put your code here
        this.fName = fName;
    }
    
    public void setLName(String lName)
    {
        // put your code here
        this.lName = lName;
    }
    
    public void setPassword(String password)
    {
        // put your code here
        this.password = password;
    }
    
    public void setPostcode(int postcode)
    {
        // put your code here
        this.postcode = postcode;
    }
    
    public void setSuburb(String suburb)
    {
        // put your code here
        this.suburb = suburb;
    }
    
    public void setState(String stateName)
    {
        // put your code here
        this.state = state;
    }
    
    public void setUId(int Id)
    {
        // put your code here
        uId = Id;
    }
}
