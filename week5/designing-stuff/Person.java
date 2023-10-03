
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    public String name;
    int age;
    String address;
    
    
    public Person(String name, int age, String address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    public String toString(){
        return  "My name is " + name + " and I am " + age + " years old.";
    }
    public String newMemberToString(){
        return  "Member name: " + name + "          Member age: " + age + " years old";
    }
    
    
    
    
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getAddress() {
        return address;
    }
}
