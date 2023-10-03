import java.util.*;

public class Library
{
    private String title;
    
    
    
    private ArrayList<LibraryMember> libraryMembers = new ArrayList<LibraryMember>();
    
    public Library(String title)
    {
        
    }

    public void addLibraryMember(LibraryMember libraryMember){
        libraryMembers.add(libraryMember);
    }
    
    public void printLibraryMembers() {
        System.out.println("Current library members are: ");
        for (LibraryMember libraryMember: libraryMembers){
            System.out.println();
            System.out.println(libraryMember.getLibraryID());
            System.out.println(libraryMember.getPerson().toString());
            System.out.println();
            System.out.println("Books on loan by member "+ libraryMember.getLibraryID() + libraryMember.getPerson().getName() + " are: ");
            LibraryMember.booksOnLoan();
        }
        
    }
}
