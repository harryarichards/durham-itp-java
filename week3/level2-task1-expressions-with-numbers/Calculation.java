
/**
 * Write a description of class Calculation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculation
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Calculation
     */
    public Calculation()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public void hoursInAWeek(){
        System.out.println("Number of hours in a week:" + 24*7);
    }
    
    public void secondsInAYear(){
        System.out.println("Number of seconds in a year:" + 24*7*3600*52);
    }
}
