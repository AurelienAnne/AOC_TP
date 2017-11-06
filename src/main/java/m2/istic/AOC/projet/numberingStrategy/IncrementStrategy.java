package m2.istic.AOC.projet.numberingStrategy;

public class IncrementStrategy implements NumberingStrategy {

    private Integer increment = 0;

    @Override
    public void configure() {

    }

    @Override
    public Integer execute() {
        return increment++;
    }
}
