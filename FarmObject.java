
import java.util.concurrent.ThreadLocalRandom;

/*
 * contains ints for x and y coordinates on the farm
 * contains an abstract method doStuffForAnHour(int hour)
 * contains method for removing object from the farm
 *
 * @author Anita Yen
 */
public abstract class FarmObject {

    private int x, y;
    protected int newX, newY;
    public final static int COW = 1;
    public final static int NOCTURNAL_COW = 2;
    public final static int FLYING_COW = 3;
    public final static int GRASS = 4;
    public final static int POISONED_GRASS = 5;

    public abstract boolean doStuffInAHour(int hour);

    public abstract void printObjectID();

    public boolean removeObjectFromFarm(Farm farmObj) {
        for (int i = 0; i < farmObj.getListLength(); i++) {
            if (farmObj.getList()[i].equals(this)) {
                farmObj.getList()[i] = null;
                farmObj.shrinkList();
                farmObj.getGrid()[x][y] = null;
                return true;
            }
        }
        return false;
    }

    public FarmObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNewX() {
        return newX;
    }

    public int getNewY() {
        return newY;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.x;
        hash = 67 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FarmObject other = (FarmObject) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

    /**
     * prepare new location for cow to validate
     *
     * @param gridLimit
     * @return false if location is not valid
     */
    public boolean generateNewLocation(int gridLimit) {
        newX = ThreadLocalRandom.current().nextInt(-1, 2) + this.getX();
        newY = ThreadLocalRandom.current().nextInt(-1, 2) + this.getY();
        return (newX >= 0 && newX < gridLimit) && (newY >= 0 && newY < gridLimit);
    }

}
