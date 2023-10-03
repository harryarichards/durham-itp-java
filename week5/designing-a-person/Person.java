
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    String name;
    int age;
    String address;
    
    
    public Person()
    {
        
    }
    
    public void setPersonDetails(String name1, int age1, String address1) {
        name = name1;
        age = age1;
        address = address1;
    }
    
    public String toString(){
        return  "My name is " + name + " and I am " + age + " years old.";
    }
}
