package m2.istic.AOC.projet.algoStrategy;

import m2.istic.AOC.projet.Generateur;


/**
 * Implements the sequential diffusion algorithm.
 * Send every updates in order. Does not check if they are received in the right order.
 */
public class SequentialDiffusion implements AlgoDiffusion {

    private Generateur generateur;

    @Override
    public void configure(Generateur generateur) {
        this.generateur = generateur;
        this.generateur.setAlgo(this);
    }

    @Override
    public void execute() {
        generateur.getObservers().forEach(o -> o.update(generateur));
    }
}
