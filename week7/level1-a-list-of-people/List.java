
import java.util.*;

public class List
{
    private ArrayList<Person> people = new ArrayList<Person>();
    private ArrayList<Person> list1 = new ArrayList<Person>();
    private ArrayList<Person> adults;
    private ArrayList<Person> oldestPeople;
    private ArrayList<Person> medianList = new ArrayList<Person>();
    private ArrayList<Integer> mode;
    
    private ArrayList<Person> peopleExcludingOldest;
    
    private int oldestAge;
    private String oldestPerson;
    private int totalAge;
    private int numberOfPeople;
    private double standardDeviation;
    private int averageAge;
    
    //Level 1:
    
    public List()
    {
    }

    public void addPerson(Person person){
        people.add(person);
        list1.add(person);
    }
    
    public void getAllStatistics(){
        System.out.println("Oldest age: " + getOldestAge());
        System.out.println("Oldest person: " + getOldestPerson());
        System.out.println("Total of ages: " + getTotalAge());
        System.out.println("Average of ages: " + getAverageAge());
        System.out.println("Standard deviation of ages: " + getStandardDeviation());
    }
    
    
    public double getStandardDeviation() {
        standardDeviation = 0;
        for (Person person: people) {
            standardDeviation += (person.getAge() - averageAge)*(person.getAge()-averageAge);
        }
        standardDeviation = Math.sqrt(standardDeviation); 
        return standardDeviation;
    }
    
    
    
    public int getTotalAge(){
        totalAge = 0;
        for (Person person: people){
            totalAge += person.getAge();
        }
        return totalAge;
    }
    
    public int getAverageAge(){
        averageAge = 0;
        getTotalAge();
        numberOfPeople = 0;
        for (Person person: people){
            numberOfPeople ++;
        }
        averageAge = (totalAge/numberOfPeople);
        return averageAge;
    }
    
    
    
    public int getOldestAge(){
        for (Person person: people){
            if( oldestAge < person.getAge()){
                oldestAge = person.getAge();
            }
        }
        return oldestAge;
    }
    
    public ArrayList<String> getOldestPerson() {
        ArrayList<String> oldestPeople2 = new ArrayList<String>();
        oldestAge = getOldestAge();
        for (Person person: people){
            if( oldestAge == person.getAge()){
                oldestPerson = person.getName();
                oldestPeople2.add(oldestPerson);
            }
        }
        return oldestPeople2;
    }
    
    //Level 2:
    
    public ArrayList<Person> listAdults() {
        adults = new ArrayList<Person>();
        for (Person person: people){
                if( person.getAge() >= 18){
                adults.add(person);
            }
        }
        
        return adults;
    }
    
    public ArrayList<Person> namesOfOldestPeople() {
        oldestPeople = new ArrayList<Person>();
        oldestAge = 0;
        for (Person person: people) {
            if (oldestAge <= person.getAge()){
                oldestAge = person.getAge();
                oldestPeople.add(person);
            }
        }
        
        return oldestPeople;
    }
    
    public ArrayList<Person> listExcludingTheOldestPerson() {
        ArrayList<Person> peopleExcludingOldest = new ArrayList<Person>();
        oldestAge = 0;
        for (Person person: peopleExcludingOldest) {
            if (oldestAge < person.getAge()) {
                oldestAge = person.getAge();
            }
        }
        
        for (Person person: peopleExcludingOldest) {
            if (oldestAge == person.getAge()) {
                peopleExcludingOldest.remove(person);
            }
        }
        
        return peopleExcludingOldest;
    }
    
    //Level 3:
    
    public void sortAge() {
        oldestAge = 0;
        for (Person person: list1){
            numberOfPeople ++;
            totalAge += person.getAge();
            
            if( oldestAge < person.getAge()){
                oldestAge = person.getAge();
            }
        }
        
        for (Person person: people){
            if (person.getAge() == oldestAge){
                medianList.add(person);
                list1.remove(person);
            }
        }
        
    }
    
    
    public double medianAge () {
        
        numberOfPeople = 0;
        int list1Size = list1.size();
        for (int i = 0; i < list1Size; i++){
            
            sortAge();
        }
        if ((medianList.size())%2 == 1) {
            return medianList.get((medianList.size())/2).getAge();
        }
        else {
            double lowerMedian = medianList.get((medianList.size()-1)/2).getAge();
            double upperMedian = medianList.get((medianList.size()+1)/2).getAge();
            double averageMedian = (lowerMedian + upperMedian)/2;
            return averageMedian;
        }
    }
    
    public ArrayList<Integer> modeAge() {
        ArrayList<Integer> mode = new ArrayList<Integer>();
        int modalCount = 0;
        int count = 0;
        int mode1;
        
        for (int i = 0; i < people.size(); i++) {
                int age = people.get(i).getAge();
                count = 0;
                for (int j = 0; j< people.size(); j++) {
                        if (age == people.get(j).getAge()) {
                            count ++;
                        }
                        
                        if (count > modalCount){
                            mode.clear();
                            mode.add(age);
                            modalCount = count;
                        }
                        else if (count == modalCount) {
                            if (mode.contains(age)) {
                            break;
                            } else{
                            mode.add(age);
                        }
                }
        }
        }
        
        mode.trimToSize();
        System.out.print("Modal ages(): " + mode);
        return mode;
    }
}
