import java.util.*;

public class Dice implements DiceInterface
{
    private Die die1, die2;
    private ArrayList<Integer> values;
    private ArrayList<DieInterface> dice;
    public Dice()
    {
        die1 = new Die();
        die2 = new Die();
        values = new ArrayList<Integer>();

        dice = new ArrayList<DieInterface>();
        dice.add(die1);
        dice.add(die2);
    }
    /**
     * @return true if and only if both of the dice have been rolled
     **/
    public boolean haveRolled(){
        if (die1.hasRolled() == true && die2.hasRolled() == true){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Roll both of the dice
     */
    public void roll(){
        clear();
        die1.roll();
        die2.roll();
        try {
            values.add(die1.getValue());
            values.add(die2.getValue());
            if (die1.getValue() == die2.getValue()){
                values.add(die1.getValue());
                values.add(die2.getValue());
            }
        }
        catch (NotRolledYetException e){
        }

    }

    /**
     * @return four numbers if there is a double, otherwise two
     *
     * @throws NotRolledYetException if either of the dice have not been rolled yet
     **/
    public List<Integer> getValues() throws NotRolledYetException{
        if (haveRolled() == true && values.size() >= 2 && values.size() <= 4){
            return values;
        }
        else{
            throw new NotRolledYetException("Dice not yet rolled.");
        }
    }

    
    /**
     * clear both of the dice so they have no value until they are rolled again
     **/
    public void clear(){
        values.clear();
        die1.clear();
        die2.clear();
    }

    /**
     * Get the individual dice in a list.
     *
     * @return the Die objects in a list, which will have length 2
     */
    public List<DieInterface> getDice(){
        return dice;
    }
}
