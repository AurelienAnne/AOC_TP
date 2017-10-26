package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.SubjectAsync;

import java.util.concurrent.Future;

public interface GenerateurAsync {

    public Future<Integer> getValue();
    public void generateValue();

}
