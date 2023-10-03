import java.util.Scanner;

public class GameManager
{
    private int upperLimit;
    private int x;
    private String y;
    private double averageNumberOfGuesses;
    private int totalGuesses = 0;
    
    
    public int xGuesses;
    public int yGuesses;
    public int computerScore = 0;
    public int playerScore = 0;
    
    HiLo HiLoObject = new HiLo();
    ComputerPlayer2 COMPObject = new ComputerPlayer2();
    
    int numberOfGames = 0;
    
    
    private int initialGuess;
    private int randomNumber;
    private int numberOfComputerGuesses;
    private int numberOfPlayerGuesses;
    
    private int numberOfComputerGames;
    
    private int totalPlayerGuesses;
    
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
            xGuesses = HiLoObject.getPlayerGuesses();
            totalGuesses += xGuesses;
            
            if (playAnswer.equals("Y"))
            {
                x=0;
                
            }
            else
            {
                x=1;
                System.out.println("Number of Games: " + numberOfGames);
                System.out.println("Average Guesses: " + totalGuesses/numberOfGames);
            }
        
        }
    }
    
    public void playMultipleComputerGames(int upperLimit)
    {
        while (x == 0)
        {
            playVsComputer(upperLimit);
        
            Scanner playAnswerInput = new Scanner(System.in);
            System.out.println("Play Again?(Y/N): ");
            String playAnswer = playAnswerInput.nextLine();
            System.out.println("");
            numberOfComputerGames++;
            totalPlayerGuesses += numberOfPlayerGuesses;
            
            if (playAnswer.equals("Y"))
            {
                x=0;
                
            }
            else
            {
                x=1;
                System.out.println("Number of Games: " + numberOfComputerGames);
                System.out.println("Average Guesses: " + totalPlayerGuesses/numberOfComputerGames);
            }
        
        }
    }
    
    public void playHiLo2 (int upperLimit, int randomNumber)
    {
       Scanner input = new Scanner(System.in);
       
       numberOfPlayerGuesses = 0;
       int guess = -1;
        
       while (randomNumber != guess)
       {
         // Ask the user for a guess
         System.out.print("Enter a number: ");
         guess = input.nextInt();
         numberOfPlayerGuesses++;
    
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
       
       System.out.println("Number of Guesses: " + numberOfPlayerGuesses);
    }
    
     public void computerPlayerGame2 (int upperLimit, int randomNumber)
    {
        int lowerLimit = 0;
        numberOfComputerGuesses = 1;
                
        
        //Guess 1:
        initialGuess = ((upperLimit+1))/2;
        
        System.out.println("Computer Guess: " + initialGuess);
        
        if (randomNumber == initialGuess)
        {
            System.out.println("That is correct! You win!");
            System.out.println("Number of Guesses: " + numberOfComputerGuesses);
        }
        else
        {
            int guess = initialGuess;
            
            while (guess != randomNumber)
            {
                numberOfComputerGuesses++;
                
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
                      
           System.out.println("The computer required: " + numberOfComputerGuesses + " guesses.");
        }
    }
        
    public void playVsComputer(int upperLimit)
    {
        randomNumber = (int)((Math.random() * upperLimit)+1);
        playHiLo2(upperLimit, randomNumber);
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        computerPlayerGame2(upperLimit, randomNumber);
        
        if (numberOfPlayerGuesses == numberOfComputerGuesses){
            System.out.println("You have drawn with the computer.");
            System.out.println();
            System.out.println("Current score:");
            System.out.println("Computer: " + computerScore + "     playerScore: " + playerScore);
        }
        else if (numberOfPlayerGuesses > numberOfComputerGuesses){
            System.out.println("You have lost to the computer.");
            System.out.println();
            System.out.println("Current score:");
            computerScore++;
            System.out.println("Computer: " + computerScore + "     playerScore: " + playerScore);
        }
        else {
            System.out.println("You have beaten the computer.");
            System.out.println();
            System.out.println("Current score:");
            playerScore++;
            System.out.println("Computer: " + computerScore + "     playerScore: " + playerScore);
        }   
              
    }
    
    
}
