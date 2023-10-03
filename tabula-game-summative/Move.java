public class Move implements MoveInterface
{
    private int sourceLocation = -1;
    private int diceValue = -1;

    public Move() {
    }
    
    /**
     * @param locationNumber represents the board position to move a piece from
     * in the range 0-24. 0 reresents off the board (the knocked location if there are pieces there, otherwise the off-board star location). A locationNumber of 1-24 refers to locations on the board with 1 being the first and 24 being the last.
     * @throws NoSuchLocationException if locationNumer is not in the range 0-24
     **/
    public void setSourceLocation(int locationNumber) throws NoSuchLocationException{
        if (0<= locationNumber && locationNumber <= 24){
            sourceLocation = locationNumber;
        }
        else{
            throw new NoSuchLocationException("Location is not valid.");
        }
    }

    public int getSourceLocation(){
        return sourceLocation;
    }

    /**
     *
     * @param diceValue represents the value of the dice to be used in the move 
     *
     * @throws IllegalMoveException if diceValue is not in the range 0-6 
     **/
    public void setDiceValue(int diceValue) throws IllegalMoveException{
        if (1 <= diceValue && diceValue <= 6){
            this.diceValue = diceValue;
        }
        else{
            throw new IllegalMoveException("Dice value not valid.");
        }
    }

    public int getDiceValue(){
        return diceValue;
    }

    // TODO: delete me
    public String toString() {
        String moveString = "";
        moveString += (sourceLocation != -1) ? "from " + Integer.toString(sourceLocation) + " " : "from null ";
        moveString += (diceValue != -1) ? "by " + Integer.toString(diceValue) : "by null";
        return moveString;
    }
}
