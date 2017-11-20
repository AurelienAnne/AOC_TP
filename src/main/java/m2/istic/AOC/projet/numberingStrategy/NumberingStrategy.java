package m2.istic.AOC.projet.numberingStrategy;


/**
 * A strategy to generate a value.
 */
public interface NumberingStrategy {
    void configure(IncrementContext context);
    Integer execute();
}
