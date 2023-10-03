public class Location implements LocationInterface
{
    private String  name;
    private boolean isMixed;
    private int greenPieces, bluePieces;

    public Location(String name)
    {
        this.name = name;
        isMixed = false;
        greenPieces = 0;
        bluePieces = 0;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    /**
     * @return true if and only if the location allows pieces of both colours
     */
    public boolean isMixed(){
        return isMixed;
    }

    /**
     * @param isMixed true if and only if the location allows pieces of both colours
     */
    public void setMixed(boolean isMixed){
        this.isMixed = isMixed;
    }

    /**
     * @return true if and only if the location has no pieces in it
     */
    public boolean isEmpty(){
        if (greenPieces == 0 && bluePieces == 0) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @param colour the colour of pieces to count
     * @return the number of pieces of that colour
     **/
    public int numberOfPieces(Colour colour){
        if (colour == Colour.values()[0]){
            return greenPieces;
        }
        else if (colour == Colour.values()[1]){
            return bluePieces;
        }
        else{
            return 0;
        }
    }

    public void setNumberOfPieces(Colour colour, int numPieces){
        if (colour == Colour.values()[0]){
            greenPieces = numPieces;
        }
        else if (colour == Colour.values()[1]){
            bluePieces = numPieces;
        }
    }

    /**
     * @param colour the colour of the piece to add
     * @return true if and only if a piece of that colour can be added (i.e. no IllegalMoveException)
     **/
    public boolean canAddPiece(Colour colour) {
        if (colour == Colour.values()[0]) {
            if (numberOfPieces(Colour.values()[1]) > 1 && !isMixed()) {
                return false;
            } else {
                return true;
            }
        }
        else if (colour == Colour.values()[1]){
            if (numberOfPieces(Colour.values()[0]) > 1 && !isMixed()){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }


    /**
     * @param colour the colour of the piece to add
     *
     * @throws IllegalMoveException if the location is not mixed and already contains two or more pieces
     * of the other colour
     *
     * @return null if nothing has been knocked off, otherwise the colour of the piece that has been knocked off
     **/
    public Colour addPieceGetKnocked(Colour colour) throws IllegalMoveException{
        if (canAddPiece(colour) && !isMixed()) {
            if (colour == Colour.values()[0]) {
                greenPieces++;
                if (bluePieces == 1) {
                    bluePieces --;
                    return Colour.values()[1];
                } else {
                    return null;
                }
            }
            else if (colour == Colour.values()[1]) {
                bluePieces++;
                if (greenPieces == 1) {
                    greenPieces --;
                    return Colour.values()[0];
                } else {
                    return null;
                }
            } else {
                throw new IllegalMoveException("No move possible.");
            }
        }
        else if (canAddPiece(colour) && isMixed()){
            if (colour == Colour.values()[0]) {
                greenPieces++;
                return null;
            }
            else{
                bluePieces++;
                return null;
            }
        }
        else{
            throw new IllegalMoveException("No move possible.");
        }
    }

    /**
     * @param colour the colour of the piece to remove
     * @return true if and only if a piece of that colour can be removed (i.e. no IllegalMoveException)
     **/
    public boolean canRemovePiece(Colour colour){
        return (numberOfPieces(colour) > 0);
    }

    /**
     * @param colour the colour of the piece to remove
     *
     * @throws IllegalMoveException if there are no pieces of that colout int the location
     *
     **/
    public void removePiece(Colour colour) throws IllegalMoveException{
        if (canRemovePiece(colour) == true){
            if (colour == Colour.values()[0]){
                greenPieces--;
            }
            else{
                bluePieces--;
            }
        }
        else{
            throw new IllegalMoveException("Cannot remove a piece, the location does not currently have any of your counters.");
        }
    }

    /**
     * @return true if and only if the Location is in a valid state depending on the number of each colour and whether or not it is a mixed location
     */
    public boolean isValid(){
        if (isMixed() == false){
            if ((0 <= bluePieces && bluePieces <= 15 && greenPieces == 0) || (0 <= greenPieces && greenPieces <= 15 && bluePieces == 0)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if ((bluePieces <= 15) && (greenPieces <= 15)){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public Location cloneLocation(){
        Location clonedLocation = new Location(name);
        clonedLocation.setMixed(isMixed);
        clonedLocation.setNumberOfPieces(Colour.values()[0], greenPieces);
        clonedLocation.setNumberOfPieces(Colour.values()[1], bluePieces);
        return clonedLocation;
    }

}


