import java.util.Scanner;

public class GameManager
{
    private int upperLimit;
    private int x;
    private String y;
    private int averageNumberOfGuesses;
    
    HiLo HiLoObject = new HiLo();
    
    int numberOfGames = 0;
    
    public void playMultipleGames(int upperLimit)
    {
        while (x == 0)
        {
            HiLoObject.playHiLo(upperLimit);
        
            Scanner playAnswerInput = new Scanner(System.in);
            System.out.println("Play Again?(Y/N): ");
            String playAnswer = playAnswerInput.nextLine();
            System.out.println("");
            numberOfGames++;
            
            if (playAnswer.equals("Y"))
            {
                x=0;
                
            }
            else
            {
                x=1;
                System.out.println("Total Number of Guesses: " );
                System.out.println("Number of Games: " + numberOfGames);
                System.out.println("Average Guesses: " );
            }
        
        }
    }
}
