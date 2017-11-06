package m2.istic.AOC.projet.numberingStrategy;

public class TimestampStrategy implements NumberingStrategy {
    @Override
    public void configure() {

    }

    @Override
    public Integer execute() {
        return Integer.valueOf((int) (System.currentTimeMillis() / 1000));
    }
}
