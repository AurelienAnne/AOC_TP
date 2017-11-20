package m2.istic.AOC.projet.algoStrategy;

import m2.istic.AOC.projet.Generateur;

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
        generateur.getObservers().forEach(o -> o.update(generateur));
    }
}
