
/**
 * Write a description of class PlayVsComputer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayVsComputer
{
    // instance variables - replace the example below with your own
    private int x;
    
    ComputerPlayer2 COMPObject = new ComputerPlayer2();
    HiLo PlayerObject = new HiLo();

    /**
     * Constructor for objects of class PlayVsComputer
     */
    public PlayVsComputer()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void playVsComputer(int upperLimit)
    {
        PlayerObject.playHiLo(upperLimit);
        COMPObject.computerPlayerGame(upperLimit);
        
    }
}
