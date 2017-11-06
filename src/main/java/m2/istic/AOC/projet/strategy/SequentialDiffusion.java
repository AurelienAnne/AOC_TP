package m2.istic.AOC.projet.strategy;

import m2.istic.AOC.projet.Generateur;

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
