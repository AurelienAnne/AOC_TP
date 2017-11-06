package m2.istic.AOC.projet.numberingStrategy;

public interface NumberingStrategy {
    void configure(IncrementContext context);
    Integer execute();
}
