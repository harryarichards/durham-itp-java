import java.util.*;

public class Board implements BoardInterface
{

    private Location startLocation, knockedLocation, endLocation;
    private ArrayList<Location> locations;
    private String name;
    
    public Board()
    {
        startLocation = new Location("startLocation");
        startLocation.setMixed(true);
        endLocation = new Location("endLocation");
        endLocation.setMixed(true);
        
        locations = new ArrayList<Location>();

        knockedLocation = new Location("knockedLocation");
        knockedLocation.setMixed(true);

        locations.add(knockedLocation);

        startLocation.setNumberOfPieces(Colour.values()[0], BoardInterface.PIECES_PER_PLAYER);
        startLocation.setNumberOfPieces(Colour.values()[1], BoardInterface.PIECES_PER_PLAYER);

        for (int i = 1; i <= BoardInterface.NUMBER_OF_LOCATIONS; i++){
            Location location = new Location(Integer.toString(i));
            locations.add(location);
            location.setNumberOfPieces(Colour.values()[0], 0);
            location.setNumberOfPieces(Colour.values()[1], 0);
        }

        endLocation.setNumberOfPieces(Colour.values()[0], 0);
        endLocation.setNumberOfPieces(Colour.values()[1], 0);
    }

    public Board(Location clonedStartLocation, Location clonedKnockedLocation, Location clonedEndLocation, ArrayList<Location> clonedLocations){
        locations = new ArrayList<Location>();
        locations.addAll(clonedLocations);

        startLocation = clonedStartLocation;
        startLocation.setMixed(true);
        knockedLocation = clonedKnockedLocation;
        knockedLocation.setMixed(true);
        endLocation = clonedEndLocation;
        endLocation.setMixed(true);
    }



    public void setName(String name){
        this.name = name;
    }
    
    /**
     * @return the Location off the board where all pieces start the game. This will be a mixed location.
     **/
    public LocationInterface getStartLocation(){
        return startLocation;
    }

    /**
     * @return the Location off the board where pieces get to when they have gone all the way round the board. This will be a mixed location.
     **/
    public LocationInterface getEndLocation(){
        return endLocation;
    }

    /**
     * @return the Location where pieces go to when they are knocked off the board by an opposing piece. This will be a mixed location.
     **/
    public LocationInterface getKnockedLocation(){
        return knockedLocation;
    }

    /**
     * @return the Location corresponding to a numbered position on the board. This will not be a mixed location.
     *
     * @param locationNumber the number of the location going from 1-24
     *
     * @throws NoSuchLocationException when position is not in the range 1-24
     **/
    public LocationInterface getBoardLocation(int locationNumber) throws NoSuchLocationException{
        if (1<= locationNumber && locationNumber <= BoardInterface.NUMBER_OF_LOCATIONS){
            return locations.get(locationNumber);
        }
        else{
            throw new NoSuchLocationException("That location does not exist.");
        }
    }

    /**
     * @param colour the colour to move
     *
     * @param move the move to make
     *
     * @return true if and only if, from the current board state it would be legal for the given colour to make the given move.
     **/
    public boolean canMakeMove(Colour colour, MoveInterface move){
        LocationInterface sourceLocation, potentialLocation;
        try{
            sourceLocation = getBoardLocation(move.getSourceLocation());
        }
        catch (NoSuchLocationException e){
            if (move.getSourceLocation() == 0) {
                if (knockedLocation.numberOfPieces(colour) == 0){
                    sourceLocation = startLocation;
                }
                else{
                    sourceLocation = knockedLocation;
                }
            }
            else{
                return false;
            }
        }
        boolean canRemovePiece = sourceLocation.canRemovePiece(colour);

        if ((sourceLocation != knockedLocation) && (knockedLocation.numberOfPieces(colour) != 0)){
            canRemovePiece = false;
        }

        try {
            potentialLocation = getBoardLocation(move.getSourceLocation() + move.getDiceValue());
        }
        catch (NoSuchLocationException e){
            if ((move.getSourceLocation() + move.getDiceValue()) > 24){
                potentialLocation = endLocation;
            }
            else {
                return false;
            }
        }
        boolean canAddPiece = potentialLocation.canAddPiece(colour);
        return (canAddPiece && canRemovePiece);
    }
    
    

    /**
     * Update the Board state by making the given move for the given colour, including any knocking off.
     *
     * @param colour the colour to move
     *
     * @param move the move to make
     *
     * @throws IllegalMoveException if and only if the move is not legal.
     **/
    public void makeMove(Colour colour, MoveInterface move) throws IllegalMoveException{
        LocationInterface sourceLocation, potentialLocation;
        if (canMakeMove(colour, move)){
            try {
                sourceLocation = getBoardLocation(move.getSourceLocation());
            }
            catch (NoSuchLocationException e){
                if (move.getSourceLocation() == 0) {
                    if (knockedLocation.isEmpty()){
                        sourceLocation = startLocation;
                    }
                    else{
                        sourceLocation = knockedLocation;
                    }
                }
                else {
                    throw new IllegalMoveException("Not a valid move.");
                }
            }
            try {
                potentialLocation = getBoardLocation(move.getSourceLocation() + move.getDiceValue());
            }
            catch (NoSuchLocationException e){
                if ((move.getSourceLocation() + move.getDiceValue() > 24)){
                    potentialLocation = endLocation;
                }
                else {
                    throw new IllegalMoveException("Not a valid move.");
                }
            }

            sourceLocation.removePiece(colour);
            Colour colourKnocked = potentialLocation.addPieceGetKnocked(colour);
            if (colourKnocked != null) {
                knockedLocation.addPieceGetKnocked(colourKnocked);
            }
        }
        else{
            throw new IllegalMoveException("Not a valid move.");
        }
    }

    /**
     * Update the Board state by making the all of the moves in the given turn in order, including any knocking off, based on the given diceValues.
     *
     * @param colour the colour to move
     *
     * @param turn the turn to take
     *
     * @param diceValues the values of the dice available in no particular order. There will be repeated values in the list if a double is thrown
     *
     * @throws IllegalTurnException if and only if the turns in the move are not legal for the diceValues give. Each of the moves has to be legal, and the diceValues in the moves of the turn must match the diceValues parameter. The number of moves in the turn must be no less than the maximum possible number of legal moves: all available dice must be used. If IllegalTurnException is thrown then the board state remains unchanged.
     **/
    public void takeTurn(Colour colour, TurnInterface turn, List<Integer> diceValues) throws IllegalTurnException{
        List<Integer> possibleDiceValues = new ArrayList<Integer>(diceValues);
        for (MoveInterface move : turn.getMoves()) {
            if (possibleDiceValues.contains(move.getDiceValue())) {
                possibleDiceValues.remove(new Integer(move.getDiceValue()));
                if (canMakeMove(colour, move)){
                    try {
                        this.makeMove(colour, move);
                    }
                    catch (IllegalMoveException e) {
                        throw new IllegalTurnException("Illegal move, game forfeited.");
                    }
                }
                else {
                    throw new IllegalTurnException("Not a valid turn.");
                }
            }
            else{
                throw new IllegalTurnException("Illegal turn.");
            }
        }

       if (possibleDiceValues.size() > 0 && possibleMoves(colour, possibleDiceValues).size() > 0) {
            throw new IllegalTurnException("You can still make moves.");
       }
    }

    /**
     * @param colour the colour to check
     *
     * @return true if and only if the given colour has won
     **/
    public boolean isWinner(Colour colour){
        if (endLocation.numberOfPieces(colour) == BoardInterface.PIECES_PER_PLAYER) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return the colour of the winner if there is one, otherwise null
     **/
    public Colour winner(){
        if (isWinner(Colour.values()[0]) == true) {
            return Colour.values()[0];
        }
        else if (isWinner(Colour.values()[1]) == true) {
            return Colour.values()[1];
        }
        else {
            return null;
        }
    }

    /**
     * @return true if and only if the Board is in a valid state (do not need to check whether or not it could be reached by a valid sequence of moves)
     **/
    public boolean isValid(){
        int numPieces = 0;
        for (LocationInterface location : locations) {
            if (location.isValid() == false){
                return false;
            }
            numPieces += location.numberOfPieces(Colour.values()[0]) + location.numberOfPieces(Colour.values()[1]);
        }
        if (startLocation.isValid() == false || (numPieces + startLocation.numberOfPieces(Colour.values()[0]) + startLocation.numberOfPieces(Colour.values()[1]) + endLocation.numberOfPieces(Colour.values()[0]) + endLocation.numberOfPieces(Colour.values()[1]) != 30)){
            return false;
        }
        else {
            return true;
        }

    }

    /**
     * @param colour the colour to move next
     *
     * @param diceValues the dice values available to use
     *
     * @return a list of moves that the given colour can make from the current board state with (any one of) the given diceValues
     **/
    public Set<MoveInterface> possibleMoves(Colour colour, List<Integer> diceValues){
        Set<MoveInterface> possibleMoves = new HashSet<MoveInterface>();
        for (int diceVal : diceValues){
            for (int i = 0; i <= BoardInterface.NUMBER_OF_LOCATIONS; i++){
                MoveInterface move = new Move();
                try {
                    move.setDiceValue(diceVal);
                }
                catch (IllegalMoveException e){
                    continue;
                }

                try {
                    move.setSourceLocation(i);
                }
                catch (NoSuchLocationException e) {
                    continue;
                }
                if (canMakeMove(colour, move)) {
                    possibleMoves.add(move);
                }
            }
        }
        return possibleMoves;
    }

    /**
     * @return a copy of the board that can be passed to players to work with
     */
    public BoardInterface clone(){
        ArrayList<Location> clonedLocations = new ArrayList<>();
        for (Location location : locations){
            Location clonedLocation = location.cloneLocation();
            clonedLocations.add(clonedLocation);
        }

        Board clonedBoard = new Board(startLocation.cloneLocation(), knockedLocation.cloneLocation(), endLocation.cloneLocation(), clonedLocations);
        clonedBoard.setName(name);
        return clonedBoard;
    }

    /**
     * Overrides toString() from Object with a suitable String representation of the board state for displaying via the console to a human
     **/
    public String toString(){
        String CLI = "|   POSITION   |  KNOCKED  |  START  |";
        for (int i = 1; i <= BoardInterface.NUMBER_OF_LOCATIONS; i++){
            CLI = CLI + "  " + locations.get(i).getName() + "  |";
        }
        CLI = CLI + "  END  |\n";

            CLI = CLI + "|   " + Colour.values()[0] + "      |     " + knockedLocation.numberOfPieces(Colour.values()[0]) + "     |    " + startLocation.numberOfPieces(Colour.values()[0]) + "   |";

        for (int i = 1; i <= BoardInterface.NUMBER_OF_LOCATIONS; i++){
            if (i == 24) {
                CLI = CLI + "  " + locations.get(i).numberOfPieces(Colour.values()[0]) + "   |";
            }
            else if (i <= 9) {
                CLI = CLI + "  " + locations.get(i).numberOfPieces(Colour.values()[0]) + "  |";
            }
            else{
                CLI = CLI + "  " + locations.get(i).numberOfPieces(Colour.values()[0]) + "   |";
            }
        }
        CLI = CLI + "  " +endLocation.numberOfPieces(Colour.values()[0])+ "    |\n";

        CLI = CLI + "|   " + Colour.values()[1] + "       |     "+ knockedLocation.numberOfPieces(Colour.values()[1]) + "     |    "+  startLocation.numberOfPieces(Colour.values()[1])+ "   |";
        for (int i = 1; i <= BoardInterface.NUMBER_OF_LOCATIONS; i++){
            if (i == 24) {
                CLI = CLI + "  " + locations.get(i).numberOfPieces(Colour.values()[1]) + "   |";
            }
            else if (i <= 9) {
                CLI = CLI + "  " + locations.get(i).numberOfPieces(Colour.values()[1]) + "  |";
            }
            else{
                CLI = CLI + "  " + locations.get(i).numberOfPieces(Colour.values()[1]) + "   |";
            }

        }
        CLI = CLI + "  " +endLocation.numberOfPieces(Colour.values()[1])+ "    |\n";

        return CLI;
    }
}
