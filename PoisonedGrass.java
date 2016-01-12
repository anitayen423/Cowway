/*
 *The amount of poisoned grass increases by 2 every hour instead of 1.
 *If a cow eats poisoned grass, it becomes sick, with sickness level 
 *equal to the amount of poisoned grass eaten.
 *
 * @author Anita
 */
public class PoisonedGrass extends Grass {

    public PoisonedGrass(int amount, int x, int y) {
        super(amount, x, y);
    }

    public PoisonedGrass(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean doStuffInAHour(int hour) {
        amount += 2;
        return createNewGrass();
    }

    @Override
    public String toString() {
        String temp = super.toString();
        temp = temp.replaceAll("Grass", "PoisonedGrass");
        return temp;
    }

    @Override
    public void printObjectID() {
        System.out.print(POISONED_GRASS);
    }
}
