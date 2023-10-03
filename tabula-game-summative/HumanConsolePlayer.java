import java.util.*;


public class HumanConsolePlayer implements PlayerInterface
{
    Scanner scan;

    public HumanConsolePlayer()
    {
        scan = new Scanner(System.in);
    }

    /**
     * Get from the player the turn that they wish to take
     *
     * @param colour the Colour they are playing as
     * 
     * @param board a clone of the current board state, so that the player can try different moves
     *
     * @param diceValues a list of the dice values the player can use.
     *
     * @return the turn the player wishes to take. It is the Player's responsibility to ensure that the turn is legal, matches the provided diceValues and uses as may of the diceValues as possible.
     *
     * @throws PauseException is only used by human players if they are in the middle of a game and wish to pause the game instead of taking a turn. 
     **/
    public TurnInterface getTurn(Colour colour, BoardInterface board, List<Integer> diceValues) throws PauseException{
        Turn turn = new Turn();
        List<Integer> diceValuesCopy = new ArrayList<Integer>(diceValues);

        while(!diceValuesCopy.isEmpty()) {
            BoardInterface boardBeforeMove = board.clone();
            Set<MoveInterface> possibleMoves = new HashSet<MoveInterface>();
            possibleMoves = board.possibleMoves(colour, diceValuesCopy); //issue in possibleMoves
            System.out.print("Available dice values: " +  diceValuesCopy +"\n");
            if (possibleMoves.isEmpty()) {
                    System.out.println("No moves to make, next player turn..");
                    return turn;
            }
            try {
                Move move = chooseMove(colour, board, diceValuesCopy);

                try {
                    board.makeMove(colour, move);
                    turn.addMove(move);
                    diceValuesCopy.remove(new Integer(move.getDiceValue()));
                    System.out.println(board.toString());
                }
                catch (IllegalMoveException e){
                    System.out.println("Move not valid.");
                    board = boardBeforeMove;
                }
                catch (IllegalTurnException e){
                    System.out.println("No more than 4 moves per turn are allowed.");
                    board = boardBeforeMove;
                }
            }
            catch (PauseException e){
                throw new PauseException("Game paused");
            }
            catch (Exception e){
                return getTurn(colour, board, diceValuesCopy);
            }

        }
        return turn;
    }

    public Move chooseMove(Colour colour, BoardInterface board, List<Integer> diceValues) throws PauseException {
        Move move = new Move();

        boolean validStartingLocation = false;
        while (!validStartingLocation) {
            System.out.println("\nChoose the position you would like to move from: ");
            String sourceLocation = scan.nextLine();
            if (sourceLocation.toLowerCase().trim().equals("pause") | sourceLocation.toLowerCase().trim().equals("p")) {
                throw new PauseException("Game Paused");
            }
            else {
                try{
                    if( ((sourceLocation.toLowerCase().equals("knocked") | sourceLocation.toLowerCase().equals("0")) && board.getKnockedLocation().canRemovePiece(colour)) | ((sourceLocation.toLowerCase().trim().equals("0") | sourceLocation.toLowerCase().trim().equals("start"))  && board.getStartLocation().canRemovePiece(colour)) ) {
                        move.setSourceLocation(0);
                        validStartingLocation = true;
                    }
                    else{
                        try{
                            move.setSourceLocation(Integer.valueOf(sourceLocation));
                            if (board.getBoardLocation(Integer.valueOf(sourceLocation)).canRemovePiece(colour)) {
                                validStartingLocation = true;
                            }
                            else{
                                System.out.println("You cannot remove a counter from this location, try again.");
                            }
                        }
                        catch (NumberFormatException e){
                            System.out.println("Please enter a valid location.");
                        }
                    }
                }
                catch (NoSuchLocationException e){
                    System.out.println("Please choose a valid location from the following: knocked, start or 1-24.");
                }
            }
        }

        boolean validDiceValueForMove = false;
        while (!validDiceValueForMove){
            System.out.println("Enter dice value you wish to use:");
            String stringDiceValue = scan.nextLine();
            if(stringDiceValue.toLowerCase().trim().equals("pause") | stringDiceValue.toLowerCase().trim().equals("p")) {
                throw new PauseException("Game Paused");
            }
            else {
                int diceValue;
                try {
                    diceValue = Integer.valueOf(stringDiceValue);
                    if (!diceValues.contains(diceValue)) {
                        System.out.println("Not a valid dice value, state a value available to you.");
                        continue;
                    }
                    move.setDiceValue(diceValue);
                    validDiceValueForMove = true;
                }
                catch (NumberFormatException e){
                    System.out.println("Not a valid dice value, state the value from 1-6.");
                    continue;
                } catch (IllegalMoveException e) {
                    System.out.println("Not a valid dice value, state the value from 1-6.");
                    continue;
                }
            }
        }
        return move;
    }
}


/*
consider every move, consider every move after that move has been made.
repeat that until, every move has been made.
*/