import java.util.Random;

public class Die implements DieInterface
{
    private int value;
    private static final Random generator = new Random();
    public Die()
    {       
    }

    /**
     * @return false when first constructed or cleared, then true once rolled (unless it is then cleared)
     **/
    public boolean hasRolled(){
        return (value != 0);
    }

    /**
     * rolls the die to give a it a value in the range 1-6
     */
    public void roll(){
        value = generator.nextInt(DieInterface.NUMBER_OF_SIDES_ON_DIE) + 1;
    }

    /**
     *
     * @return the visible face of the die, a value in the range 1-6
     *
     * @throws NotRolledYetException if the die has not been rolled or has been cleared since the last roll
     **/
    public int getValue() throws NotRolledYetException{
        if (1 <= value && value <= 6){
            return value;
        }
        else{
            throw new NotRolledYetException("Die not yet rolled.");
        }
    }

    /**
     * set the face value of the die: only needed when recreating a game state
     *
     * @param value the new value of the die. If it is not in an acceptable range then afterwards hasRolled() should return false.
     **/
    public void setValue(int value){
        if (1 <= value && value <= 6) {
            this.value = value;
        }
        else{
            this.value = 0;
        }
    }
    
    /**
     * clears the die so it has no value until it is rolled again
     **/
    public void clear(){
        value = 0;
    }

    /**
     * sets the seed for the random number generator used by all dice
     *
     * @param seed the seed value to use for randomisation
     **/
    public void setSeed(long seed){
        generator.setSeed(seed);
    }
}
