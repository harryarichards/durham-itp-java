
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
    
    public double getY() {
        return y;
    }
    
    public double getX() {
        return x;
    }
    
    public void setY(int setY) {
        y = setY;
    }
    
    public void setX(int setX) {
        x = setX;
    }
    
    public void quadraticSolver(double a, double b, double c) {
        x = (-b + Math.sqrt((b*b) - (4*a*c)))/(2*a);
        y = (-b - Math.sqrt((b*b - 4*a*c)))/(2*a);
        System.out.println("The first solution to the quadratic equation is: " + x);
        System.out.println("The second solution to the quadratic equation is: " + y);
    }
    
    public void isItOdd(int a) {
        if (a%2 != 0) 
        System.out.println("The number is odd.");
        else{
        System.out.println("The number is even.");    
        }
    }
    
    public void separateDate(String a) {
        String bstring = a.substring(6,8);
        int b = Integer.parseInt(bstring);
        System.out.println("The day is: " + a.substring(0,2));
        if (a.length() == 10)         
        System.out.println("The year is: " + a.substring(6,10));
        else{
        if (b <= 16) 
        System.out.println("The year is: 20" + a.substring(6,8));
        else{
        System.out.println("The year is: 19" + a.substring(6,8));    
        }
        }
    }
    

    public void minumumNumberOfCoins(int valueInPence)
    {
       int x = valueInPence%50;
       
          if (x==0)
          {System.out.println("Minumum number of coins for change: " + valueInPence/50);}
       
          else if (x!=0)
          {int leftOverValue = x;
           int y = leftOverValue%20;
        
              if (y==0)
             {System.out.println("Minumum number of coins for change: " + ((valueInPence/50)+(x/20)));}
       
                else if (y!=0)
             {int leftOverValue2 = y;
              int z = leftOverValue2%10;
            
                if (z==0)
                {System.out.println("Minumum number of coins for change: " + ((valueInPence/50)+(x/20)+(y/10)));}
       
                else if (z!=0)
                {int leftOverValue3 = z;
                 int a = leftOverValue3%5;
                
                    if (a==0)
                    {System.out.println("Minumum number of coins for change: " + ((valueInPence/50)+(x/20)+(y/10)+(z/5)));}
       
                     else if (a!=0)
                     {int leftOverValue4 = a;
                      int b = leftOverValue4%2;
                    
                           if (b==0)
                           {System.out.println("Minumum number of coins for change: " + ((valueInPence/50)+(x/20)+(y/10)+(z/5)+(a/2)));}
       
                           else if (b!=0)
                           {int leftOverValue5 = b;
                            int c = leftOverValue5%1;
                        
                                    if (c==0)
                                    {System.out.println("Minumum number of coins for change: " + ((valueInPence/50)+(x/20)+(y/10)+(z/5)+(a/2)+(b/1)));}
       
                                    }}}}
         }
      }
      
    
    public void getDayForDate (int day, int month, int year) {
        if (year > 99)
          year = year - 2001;
        else{
            year = year - 1;
        }
        int z = (year * 365);
        
        
        z += (year + 1)/4;     
        
        if ((year + 1)%4 == 0 && month <= 2){
            z = z -1;
        }
        
        if (month == 1)
            z += day - 1;
        else if (month == 2)
            z+= 30 + day;
        else if (month == 3)
            z+= 58 + day;
        else if (month == 4)
            z+= 89 + day;
        else if (month == 5) 
            z+= 119 + day;
        else if (month == 6) 
            z+= 150 + day;
        else if (month == 7) 
            z+= 180 + day;
        else if (month == 8) 
            z+= 211 + day;
        else if (month == 9) 
            z+= 242 + day;
        else if (month == 10) 
            z+= 272 + day;
        else if (month == 11) 
            z+= 303 + day;
        else if (month == 12) {
            z+= 333 + day;
        }
        
        if (z%7 == 0) 
            System.out.println("Monday");
        else if(z%7 == 1)
            System.out.println("Tuesday");
        else if(z%7 == 2)
            System.out.println("Wednesday");
        else if(z%7 == 3)
            System.out.println("Thursday");
        else if(z%7 == 4)
            System.out.println("Friday");
        else if(z%7 == 5)
            System.out.println("Saturday");
        else if(z%7 == 6){
            System.out.println("Sunday");
        }
        }
    }
       
