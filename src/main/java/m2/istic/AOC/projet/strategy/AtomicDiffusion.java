package m2.istic.AOC.projet.strategy;

import m2.istic.AOC.projet.Generateur;

import java.util.concurrent.ExecutionException;

public class AtomicDiffusion implements AlgoDiffusion {

    private Generateur generateur;

    @Override
    public void configure(Generateur generateur) {
        this.generateur = generateur;
        this.generateur.setAlgo(this);
    }

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
