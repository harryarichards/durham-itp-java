import java.util.*;

public class Turn implements TurnInterface
{
    private ArrayList<MoveInterface> moves;

    public Turn() { moves = new ArrayList<MoveInterface>();}

    /**
     * @param move to be added after the moves already defined in the current turn
     *
     * @throws IllegalTurnException if there are already four or more moves in the turn
     */
    public void addMove(MoveInterface move) throws IllegalTurnException{
        if (moves.size() <= 4){
            moves.add(move);
        }
        else{
            throw new IllegalTurnException("All moves used for current turn.");
        }
    }

    public ArrayList<MoveInterface> getMoves(){ return moves;}

    public String toString() {
        String movesString = "";
        for (MoveInterface move: moves) {
            Move mv = (Move) move;
            movesString += "• " + move.toString() + "\n";
        }
        return movesString;
    }
}
