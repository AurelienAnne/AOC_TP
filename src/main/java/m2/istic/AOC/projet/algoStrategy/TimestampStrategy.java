package m2.istic.AOC.projet.algoStrategy;

import m2.istic.AOC.projet.Generateur;

/**
 * Implements the timestamp strategy.
 * Wrap the value with a timestamp and make sure the updates are received and
 * the afficheur can infer their order.
 *
 * TODO : Implements it.
 */
public class TimestampStrategy implements AlgoDiffusion {

    private Generateur generateur;

    @Override
    public void configure(Generateur generateur) {
        this.generateur = generateur;
        this.generateur.setAlgo(this);
    }

    @Override
    public void execute() {
        // TODO
        // This is not the right algorithm.
        generateur.getObservers().forEach(o -> o.update(generateur));
    }
}
