package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.SubjectAsync;

import java.util.concurrent.Future;

/**
 * Interface for a asynchronous generateur.
 * The canal is seen as a GenerateurAsync by the afficheurs.
 */
public interface GenerateurAsync {

    public Future<Integer> getValue();
    public void generateValue();

}
