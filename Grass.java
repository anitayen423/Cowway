
import java.util.concurrent.ThreadLocalRandom;

/*
 *int for amount of grass
 *Every hour, the amount of grass increases by 1.
 *Every hour, has a 0.1*(amount of grass)% chance of creating another patch of 
 *grass in a random adjacent square that is not occupied by a cow (up/down/left/right).
 *
 * @author Anita
 */
public class Grass extends FarmObject {

    protected int amount = 1;

    public Grass(int amount, int x, int y) {
        super(x, y);
        this.amount = amount;
    }

    public Grass(int x, int y) {
        super(x, y);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean doStuffInAHour(int hour) {
        amount += 1;
        return createNewGrass();
    }

    /**
     *
     * @return true if new grass is created
     */
    public boolean createNewGrass() {
        int p = (int) (10 * amount);
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        return randomNumber <= p;
    }

    @Override
    public String toString() {
        return "Grass{" + super.toString() + ", amount=" + amount + '}';
    }

    @Override
    public void printObjectID() {
        System.out.print(GRASS);
    }
}
