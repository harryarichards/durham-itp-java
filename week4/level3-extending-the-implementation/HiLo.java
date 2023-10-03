import java.util.Scanner;

public class HiLo
{
    private int upperLimit;
    public int g;
    public int numberOfGuesses;
    public int randomNumber;
    
    
    public void playHiLo (int upperLimit)
    {
       Scanner input = new Scanner(System.in);
       
       numberOfGuesses = 0;
       randomNumber = (int)((Math.random() * upperLimit)+1);
       int guess = -1;
        
       while (randomNumber != guess)
       {
         // Ask the user for a guess
         System.out.print("Enter a number: ");
         guess = input.nextInt();
         numberOfGuesses++;
    
         // If the user' guess is high/low, tell them and play again
         if (randomNumber == guess)
         {
            System.out.println("That is correct! You win!");
         }
         else if (randomNumber < guess)
         {
            System.out.println("Guess is too high!");
         }
         else
         {
            System.out.println("Guess is too Low!");
         }
        
         // Continue playing until the iser guesses the correct number
       }
       
       System.out.println("Number of Guesses: " + numberOfGuesses);
    }
    
    public int getPlayerGuesses() {
        return numberOfGuesses;
    }
}

