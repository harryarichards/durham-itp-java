
/**
 * Write a description of class LibraryMember here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LibraryMember
{
    Object Person = new Person();
    String libraryID;
    /**
     * Constructor for objects of class LibraryMember
     */
    public LibraryMember()
    {
        
    }
    
    public void addLibraryMember (Person person, String ID, int loanLimit){
        libraryID = ID;
        this.Person = person;
        System.out.println(person.toString());
    }
           
    
}
