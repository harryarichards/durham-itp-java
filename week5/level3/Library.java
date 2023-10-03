import java.util.*;

public class Library
{
    private String title;
    
       
    private ArrayList<LibraryMember> libraryMembers = new ArrayList<LibraryMember>();
       
    public Library(String title)
    {
        
    }
    
    public void addBooks(Book book){
        
    }

    public void addLibraryMember(LibraryMember libraryMember){
        libraryMembers.add(libraryMember);
    }
    
    public void printLibraryMembers() {
        System.out.println("Current library members are: ");
        for (LibraryMember libraryMember: libraryMembers){
            System.out.println();
            System.out.println(libraryMember.getPerson().newMemberToString());
            System.out.println();
            System.out.println("Books currently on loan by member "+ libraryMember.getPerson().getName() + " " + libraryMember.getLibraryID() + " are: ");
            libraryMember.booksOnLoan();
            System.out.println();
            System.out.println("The loan history of member "+ libraryMember.getPerson().getName() + " " + libraryMember.getLibraryID() + " is: ");
            libraryMember.loanHistory();
        }
        
    }
}
