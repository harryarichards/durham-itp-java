
/**
 * A simple class to apply a transformation iteratively
 * 
 * @author Steven Bradley
 */
public class CountExpr
{
  
    private double x;
    public double y;
    
    public CountExpr(int startx, int starty){
         x= startx/50.0;
        y= starty/50.0;
    }
    
    public void doOnce(){
        y=(x-25)*Math.tan(y/9) - (y-30)*Math.tan(x/9);
    }
    
    public boolean finished(){
            return x+y>100; 
    }
}
