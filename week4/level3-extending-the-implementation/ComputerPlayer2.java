
/**
 * Write a description of class ComputerPlayer2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputerPlayer2
{
    private int upperLimit;
    private int guess1;
    private int initialGuess;
    public int numberOfGuesses;
    private int randomNumber;
    
    public void computerPlayerGame (int upperLimit)
    {
        int lowerLimit = 0;
        numberOfGuesses = 1;
        randomNumber = (int)((Math.random() * upperLimit)+1);
        
        
        //Guess 1:
        initialGuess = ((upperLimit+1))/2;
        
        System.out.println("Computer Guess: " + initialGuess);
        
        if (randomNumber == initialGuess)
        {
            System.out.println("That is correct! You win!");
            System.out.println("Number of Guesses: " + numberOfGuesses);
        }
        else
        {
            int guess = initialGuess;
            
            while (guess != randomNumber)
            {
                numberOfGuesses++;
                
                if (randomNumber < guess)
                {
                    System.out.println("Guess is too high!");
                    if (guess < upperLimit) {
                        upperLimit = guess;
                    }
                    guess = ((upperLimit + lowerLimit)/2);    
                     
                 
                    System.out.println("");
                    System.out.println("Computer Guess: " + guess);
                }
                else
                {
                    System.out.println("Guess is too Low!");
                    if (guess > lowerLimit) {
                        lowerLimit = guess;
                    }
                    guess = ((upperLimit + lowerLimit)/2);
                    System.out.println("");
                    System.out.println("Computer Guess: " + guess);
                }
            }
                      
           System.out.println("The computer required: " + numberOfGuesses + " guesses.");
        }
    }
    
    public int getComputerGuesses(){
        return numberOfGuesses;
    }
}
