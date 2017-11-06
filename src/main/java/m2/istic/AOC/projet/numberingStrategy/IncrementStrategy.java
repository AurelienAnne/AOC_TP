package m2.istic.AOC.projet.numberingStrategy;

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
