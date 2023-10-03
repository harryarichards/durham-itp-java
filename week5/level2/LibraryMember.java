
import java.util.*;

public class LibraryMember
{
    private Person person;
    private String libraryID;
    private int bookLoanLimit;
    
    private ArrayList<Book> loanHistory = new ArrayList<Book>();
    private ArrayList<Book> booksLoaned = new ArrayList<Book>();
    
    public LibraryMember(Person person, String ID, int loanLimit)
    {
        this.person = person;
        libraryID = ID;
        bookLoanLimit = loanLimit; 
    }    
    
    public String getLibraryID(){
        return libraryID;
    }
    
    public Person getPerson(){
        return  person;
    }
    
    public void loanBook(Book book){
        if ((bookLoanLimit - booksLoaned.size()) > 0) { 
            booksLoaned.add(book);
            loanHistory.add(book);
        }
        else {
            System.out.println("You have already reached your loan limit, thus you cannot loan anymore books until you return one.");
        }
    }
    
    public void returnBook(Book book){
        booksLoaned.remove(book);
    }
    
       
    public void booksOnLoan() {
        for (Book bookLoaned: booksLoaned){
            System.out.println();
            System.out.println(bookLoaned.bookToString());
            System.out.println("Return date for book: " + bookLoaned.getReturnDate());
            System.out.println();
        }
    }
    
    public void loanHistory() {
        for (Book bookLoaned: loanHistory){
            System.out.println();
            System.out.println(bookLoaned.bookToString());
            System.out.println("Date Loaned " + bookLoaned.getDateLoaned());
            System.out.println();
        }
    }
        
}
