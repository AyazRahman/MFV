

/**
 * Write a description of class test2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.time.LocalDate;
public class CurrentDateTimeExample1 {
  public static boolean validateDate(String entredDate)
  {
      String dateRegex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
      Pattern p = Pattern.compile(dateRegex);
      //String input = "10/01/2020";
      Matcher m = p.matcher(entredDate);
      
      if (m.matches())
      {
      
      LocalDateTime today = LocalDateTime.now();
           
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      //Date date = new Date();
      String todayString = today.format(formatter);
          
      LocalDate entredDateToDate = LocalDate.parse(entredDate,formatter);
      LocalDate todayStringToDate = LocalDate.parse(todayString,formatter);

      System.out.println("Is...");
      if (entredDateToDate.isAfter(todayStringToDate)) 
      {
          System.out.println("Future date not acceptable");
          return false;
      }

      if (entredDateToDate.isBefore(todayStringToDate)) 
      {
          System.out.println("Date is valid ");
          return true;
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
    
    
  public static void main(String[] args) {

      
      //DateTimeFormatter formatter = new DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);

      Scanner scan = new Scanner(System.in);
      System.out.println("Enter Date (format dd/mm/yyyy): ");
      String date = "";
      while(date.equals(""))
      {
          String input = scan.nextLine();  
          if (validateDate(input.trim()) == true)
            {
                date = input.trim();
            }
            else
            {
                System.out.println("Entre valid date please");
            }
      }    
          
      
        
      //Date date2 = formatter.parse(input);
      //LocalDate date2 = LocalDate.parse(input, formatter);
      //boolean after = date.after(input);
      //System.out.println(formatter.format(date2));
         
      //}
      //else System.out.println("NOT matched");
      

      
      /*
          Date current = new Date();
          String myFormatString = "dd/MM/yyy";
          SimpleDateFormat df = new SimpleDateFormat(myFormatString);
          Date givenDate = df.parse("15/02/13");
          Long l = givenDate.getTime();
          //create date object
          Date next = new Date(l);
          //compare both dates
          if(next.after(current) || (next.equals(current)))
          {
        System.out.println("The date is future day");
          } 
    else 
    {

        System.out.println("The date is older than current day");
    }
    */
        
  }    
}    