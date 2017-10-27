package m2.istic.AOC.projet.strategy;

import m2.istic.AOC.projet.Generateur;

public class BasicDiffusion implements AlgoDiffusion {

    private Generateur generateur;

    public void configure(Generateur generateur) {
        this.generateur = generateur;
    }

    @Override
    public void execute() {
        generateur.getObservers().forEach(o -> o.update(generateur));
    }
}
