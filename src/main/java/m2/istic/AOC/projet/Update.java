package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.Observer;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Update implements Callable<Void> {

    private Observer<GenerateurAsync> generateur;
    private GenerateurAsync subject;

    public Update(Observer<GenerateurAsync> generateur, GenerateurAsync subject) {
        this.generateur = generateur;
        this.subject = subject;
    }

    @Override
    public Void call() throws Exception {
        generateur.update(subject);
        return null;
    }
}
