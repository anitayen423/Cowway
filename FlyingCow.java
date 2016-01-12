
import java.util.concurrent.ThreadLocalRandom;

/*
 * Moves to a random square (not occupied by a cow) on the farm every hour
 *
 * @author Anita
 */
public class FlyingCow extends Cow {

    public FlyingCow(String name, int hungriness, int sicknessLevel, int age, int x, int y) {
        super(name, hungriness, sicknessLevel, age, x, y);
    }

    public FlyingCow(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean generateNewLocation(int gridLimit) {
        newX = ThreadLocalRandom.current().nextInt(0, gridLimit) + this.getX();
        newY = ThreadLocalRandom.current().nextInt(0, gridLimit) + this.getY();
        return true;
    }

    @Override
    public String toString() {
        String temp = super.toString();
        temp = temp.replaceAll("Cow", "FlyingCow");
        return temp;
    }

    @Override
    public void printObjectID() {
        System.out.print(FLYING_COW);
    }
}
