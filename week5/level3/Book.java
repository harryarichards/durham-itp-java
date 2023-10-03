import java.util.*;
import java.util.Calendar;

public class Book
{
    private String title;
    private String author;
    private int yearPublished;
    private int returnDay;
    private Calendar calendar = Calendar.getInstance();
    
    private int dateLoanedYear;
    private int dateLoanedMonth;
    private int dateLoanedDay;
    private String dateLoaned;
    
    private int dateYear;
    private int dateMonth;
    private int dateDay;
    private String returnDate;
    
    public Book(String title, String author, int yearPublished, int loanDuration)
    {      
        dateLoanedYear = calendar.get(Calendar.YEAR);
        dateLoanedMonth = calendar.get(Calendar.MONTH);
        dateLoanedDay = calendar.get(Calendar.DATE);
        dateLoaned = dateLoanedDay + "/" + dateLoanedMonth + "/" + dateLoanedYear;
        
        returnDay = calendar.get(Calendar.DAY_OF_YEAR) + loanDuration;
        calendar.set(Calendar.DAY_OF_YEAR, returnDay);
        dateYear = calendar.get(Calendar.YEAR);
        dateMonth = calendar.get(Calendar.MONTH) + 1;
        dateDay = calendar.get(Calendar.DATE);
        
        returnDate = dateDay + "/" + dateMonth + "/" + dateYear;
        
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        
    }
    
       
    public String bookToString() {
        return "Book Title: " + title + "           Book Author: " + author + "           Publication Date: " + yearPublished;
    }
    
    public String getReturnDate() {
        return returnDate;
    }
    
    public String getDateLoaned() {
        return dateLoaned;
    }
}
