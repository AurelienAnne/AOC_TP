package m2.istic.AOC.projet.numberingStrategy;


/**
 * Interface for a class that holds a counter.
 * The generateur implement this, to be seen by the IncrementStrategy.
 */
public interface IncrementContext {
    public void increment();
    public Integer getCounter();
}
