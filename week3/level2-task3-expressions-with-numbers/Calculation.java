
/**
 * Write a description of class Calculation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculation
{
    // instance variables - replace the example below with your own
    private double average;
    private double temp;
    private double x;
    private double y;
    
    public Calculation()
    {
    }

    public void getMaximumXY(double x, double y) {
        if (x - y > 0) 
            System.out.println("Maximum of x and y is: " + x);
        else{
            System.out.println("Maximum of x and y is: " + y);
        }
    }
    
    public void getAverageXY(double x, double y) {
        average = (x+y)/2;
        System.out.println("Average of x and y is: " + average);
    }
    
    public void swapXY(double x, double y) {
        temp = y;
        y = x;
        x = temp;
        
        System.out.println("X is now: " + x);
        System.out.println("Y is now: " + y);
    }
    
    public void convertCelciusToFarenheit (double x) {
        System.out.println("Temperature in Celcius is: " + x);
        y = 1.8*x + 32;
        System.out.println("Temperature in Farenheit is: " + y);
        
    }
    
    public void hoursInAWeek(){
        System.out.println("Number of hours in a week: " + 24*7);
    }
    
    public void secondsInAYear(){
        System.out.println("Number of seconds in a year: " + 24*7*3600*52);
    }
    
    public void quadraticSolver(double a, double b, double c) {
        x = (-b + Math.sqrt((b*b) - (4*a*c)))/(2*a);
        y = (-b - Math.sqrt((b*b - 4*a*c)))/(2*a);
        System.out.println("The first solution to the quadratic equation is: " + x);
        System.out.println("The second solution to the quadratic equation is: " + y);
    }
    

    
}
