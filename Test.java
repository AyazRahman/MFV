import java.util.*;
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    public ArrayList<Product> products = new ArrayList<Product>();

    /**
     * Constructor for objects of class Test
     */
    public Test()
    {

    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public User sampleMethod()
    {
        String[] saletype = {"Kg","Bag"};
        
        FileManager db = new FileManager();
        db.loadData();
        
        products.add(new Product());
        products.add(new Product());
        
        products.get(0).setProductID(100);
        products.get(0).setName("Apples");
        products.get(0).setAvgShelfLife( 7 * 7 );
        products.get(0).setSaleTypes(saletype);
        
        products.get(1).setProductID(101);
        products.get(1).setName("Apricots");
        products.get(1).setAvgShelfLife( 9 * 4 * 7 );
        products.get(1).setSaleTypes(saletype);
        
        products.get(0).getBatches().add(new Batch());
        products.get(0).getBatches().add(new Batch());
        
        products.get(0).getBatches().get(0).setBatchID(products.get(0).getProductID()*1000 + 1);
        products.get(0).getBatches().get(0).setQuantity(5);
        //date
        products.get(0).getBatches().get(0).setSaleMethod(products.get(0).getSaleTypes()[0]);
        products.get(0).getBatches().get(0).setPrice(12.90);
        products.get(0).getBatches().get(0).setSource("Local");
        products.get(0).getBatches().get(0).setName("Golden Delicious");
        
        products.get(0).getBatches().get(1).setBatchID(products.get(0).getProductID()*1000 + 2);
        products.get(0).getBatches().get(1).setQuantity(1);
        //date
        products.get(0).getBatches().get(1).setSaleMethod(products.get(0).getSaleTypes()[1]);
        products.get(0).getBatches().get(1).setPrice(5.90);
        products.get(0).getBatches().get(1).setSource("Japan");
        products.get(0).getBatches().get(1).setName("Pink Lady");
        
        int[] amount = products.get(0).totalQty();
        int i = 0;
        System.out.println(products.get(0).getName() + " :");
        for (String s : products.get(0).getSaleTypes())
        {
            System.out.println(s +" : " + amount[i]);
            i++;
        }
        System.out.println();
        
        products.get(1).getBatches().add(new Batch());
        products.get(1).getBatches().add(new Batch()); 
        
        products.get(1).getBatches().get(0).setBatchID(products.get(1).getProductID()*1000 + 1);
        products.get(1).getBatches().get(0).setQuantity(2);
        //date
        products.get(1).getBatches().get(0).setSaleMethod(products.get(1).getSaleTypes()[0]);
        products.get(1).getBatches().get(0).setPrice(6.90);
        products.get(1).getBatches().get(0).setSource("Local");
        products.get(1).getBatches().get(0).setName(products.get(1).getName());
        
        products.get(1).getBatches().get(1).setBatchID(products.get(1).getProductID()*1000 + 2);
        products.get(1).getBatches().get(1).setQuantity(3);
        //date
        products.get(1).getBatches().get(1).setSaleMethod(products.get(1).getSaleTypes()[1]);
        products.get(1).getBatches().get(1).setPrice(2.90);
        products.get(1).getBatches().get(1).setSource("Local");
        products.get(1).getBatches().get(1).setName(products.get(1).getName());
        
        amount = products.get(1).totalQty();
        i = 0;
        System.out.println(products.get(1).getName() + " :");
        for (String s : products.get(1).getSaleTypes())
        {
            System.out.println(s +" : " + amount[i]);
            i++;
        }
        System.out.println();
        
        for (User c : db.getUsers())
        {
            //System.out.println(c.toString());
            System.out.println(c.getEmail()); 
            System.out.println(c.getPassword());
        }
        
        //Administrator a = new Administrator();
        Customer a = new Customer();
        return a;
    }
}
