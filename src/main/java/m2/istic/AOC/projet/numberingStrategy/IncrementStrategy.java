package m2.istic.AOC.projet.numberingStrategy;


/**
 * Creates a value based on a context that handle the incrementing.
 */
public class IncrementStrategy implements NumberingStrategy {

    private IncrementContext context;

    @Override
    public void configure(IncrementContext context) {
        this.context = context;
    }

    @Override
    public Integer execute() {
        return context.getCounter();
    }
}
