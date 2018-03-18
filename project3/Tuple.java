/**
 * Will be used to store information for a specific cell in teh
 * front last game.
 * @author William Trevor Whitecar
 */
public class Tuple {
    Character frontOrLast;
    Integer total;

    public Tuple( Character frontOrBack, Integer sum) {
        this.frontOrLast = frontOrBack;
        this.total = sum;
    }

    public Character getFrontOrLast() {
        return this.frontOrLast;
    }

    public Integer getTotal() {
        return this.total;
    }

    @Override
    public boolean equals(Object pair) {
        if(pair.getClass() != Tuple.class &&
                !((Tuple) pair).getFrontOrLast().equals(this.frontOrLast) &&
                ((Tuple) pair).getTotal() != total) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("(" + this.frontOrLast + " " + this.total + ")");
    }
}
