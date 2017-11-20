package m2.istic.AOC.projet.algoStrategy;

import m2.istic.AOC.projet.Generateur;

import java.util.concurrent.ExecutionException;

/**
 * Implements the atomic diffusion algorithm.
 * The next update is sent if and only if the previous one is successfully received.
 */
public class AtomicDiffusion implements AlgoDiffusion {

    private Generateur generateur;

    @Override
    public void configure(Generateur generateur) {
        this.generateur = generateur;
        this.generateur.setAlgo(this);
    }

    /**
     * Execute the diffusion of the updates.
     * Call update on the generator's observers.
     * Uses `o.update(generateur).get();` the make the call synchronous.
     */
    @Override
    public void execute() {
        generateur.getObservers().forEach(o -> {
            try {
                o.update(generateur).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
