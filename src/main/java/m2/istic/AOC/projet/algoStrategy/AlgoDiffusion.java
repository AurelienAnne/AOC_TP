package m2.istic.AOC.projet.algoStrategy;

import m2.istic.AOC.projet.Generateur;

/**
 * Strategy representing the algorithm used to diffuse updates.
 */
public interface AlgoDiffusion {
    /**
     * Link the generateur and the strategy.
     * @param generateur
     */
    void configure(Generateur generateur);

    /**
     * Execute the diffusion of the updates.
     * Call update on the generator's observers.
     */
    void execute();
}
