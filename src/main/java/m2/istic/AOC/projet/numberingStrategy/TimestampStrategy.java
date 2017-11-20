package m2.istic.AOC.projet.numberingStrategy;


/**
 * Creates a timestamp as a value.
 */
public class TimestampStrategy implements NumberingStrategy {
    @Override
    public void configure(IncrementContext context) {

    }

    @Override
    public Integer execute() {
        return Integer.valueOf((int) (System.currentTimeMillis() / 1000));
    }
}
